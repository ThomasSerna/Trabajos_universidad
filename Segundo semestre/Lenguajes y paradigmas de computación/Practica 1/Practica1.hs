import Data.Time.Clock
import Data.List
import System.IO
import Control.Exception
import Control.Concurrent (threadDelay)
import Data.Maybe (mapMaybe)

-- Definición del tipo de dato que representa los libros
data Libro = Libro {
        idLibro :: Int, -- Identificador único
        nombreLibro :: String,  -- Título del libro
        autorLibro :: String,  -- Nombre del autor
        prestado :: Bool,  -- True si está prestado, False si está disponible
        fechaInicialPrestamo :: Maybe UTCTime, -- Se usa Maybe porque puede existir el caso en que el libro no esté en un prestamo
        fechaFinalPrestamo :: Maybe UTCTime
    } deriving (Show, Read)

--Funcion para buscar libro por ID:
buscarLibro :: Int -> [Libro] -> Maybe Libro
buscarLibro codigo biblioteca= 
    find(\libro-> idLibro libro ==codigo) biblioteca

-- Función para mostrar la información de un libro
mostrarLibro :: Libro -> String
mostrarLibro l =
  "Id: " ++ show (idLibro l) ++
  ", nombre: " ++ nombreLibro l ++
  ", autor: " ++ autorLibro l ++
  ", prestado: " ++ show (prestado l) ++
  maybe "" ((", desde: " ++) . show) (fechaInicialPrestamo l)

-- Registrar el préstamo de un libro
registrarPrestamo :: Int -> UTCTime -> [Libro] -> [Libro]
registrarPrestamo codigo tiempo biblioteca =
    map (\libro ->
        if idLibro libro == codigo && not (prestado libro)
            then libro { prestado = True, fechaInicialPrestamo = Just tiempo, fechaFinalPrestamo = Nothing }
            else libro
        ) biblioteca

-- Registrar la devolución de un libro
registrarDevolucion :: Int -> UTCTime -> [Libro] -> [Libro]
registrarDevolucion codigo tiempo biblioteca =
    map (\libro ->
        if idLibro libro == codigo && prestado libro
            then libro { prestado = False, fechaFinalPrestamo = Just tiempo }
            else libro
        ) biblioteca
        
-- Función para calcular la duración de un préstamo
duracionPrestamo :: Libro -> UTCTime -> NominalDiffTime
duracionPrestamo libro tiempoActual =
    case (fechaInicialPrestamo libro, fechaFinalPrestamo libro) of
        (Just inicio, Just fin) -> diffUTCTime fin inicio
        (Just inicio, Nothing)  -> diffUTCTime tiempoActual inicio
        _ -> 0   -- Caso: nunca se prestó
   
-- Función que filtra los libros prestados
librosPrestados :: [Libro] -> [Libro]
librosPrestados biblioteca =
    filter (\libro -> prestado libro) biblioteca

-- Función para cargar la información de la libreria desde un archivo de texto
cargarLibreria :: IO [Libro]
cargarLibreria = do
    resultado <- try (readFile "libreria.txt") :: IO (Either IOException String)
    case resultado of
        Left ex -> do
            putStrLn $ "Error cargando la libreria: " ++ show ex
            return []

        Right contenido -> do
            let lineas = lines contenido
                forzarLectura = length lineas  -- Fuerza la lectura completa de las líneas, para evitar que el archivo quede abierto por Haskell
            forzarLectura `seq` return (map leerLibro lineas)
  where
    leerLibro linea = read linea :: Libro
    
-- Función para guardar la información de la libreria a un archivo de texto
guardarLibreria :: [Libro] -> IO()
guardarLibreria libreria = do
    resultado <- reintentar 5 (writeFile "libreria.txt" (unlines (map show libreria)))
    case resultado of
        Left ex -> putStrLn $ "Error guardando la libreria: " ++ show ex
        Right _ -> putStrLn "Libreria guardada en el archivo libreria.txt."

-- Función para reintentar una operación en caso de error
reintentar :: Int -> IO a -> IO (Either IOException a)
reintentar 0 accion = catch (accion >>= return . Right) (\(ex :: IOException) -> return (Left ex))
reintentar n accion = do
    resultado <- catch (accion >>= return . Right) (\(ex :: IOException) -> return (Left ex))
    case resultado of
        Left ex -> do
            threadDelay 1000000  -- Esperar 1 segundo antes de reintentar
            reintentar (n - 1) accion
        Right val -> return (Right val)
        
-- Función para cargar la información de los libros desde un archivo de texto
leerLibreria :: IO [Libro]
leerLibreria = do
    contenido <- readFile "libreria.txt"
    let lineas = lines contenido
        m = length lineas
    m `seq` return (mapMaybe read lineas)

-- Función principal del programa
main :: IO ()
main = do
    -- Cargar la biblioteca desde el archivo de texto
    biblioteca <- cargarLibreria
    putStrLn "¡Bienvenido al Sistema de Gestión de Biblioteca!"

    -- Ciclo principal del programa
    cicloPrincipal biblioteca

-- Función para el ciclo principal del programa
cicloPrincipal :: [Libro] -> IO ()
cicloPrincipal biblioteca = do
    putStrLn "\nSeleccione una opción:"
    putStrLn "1. Registrar préstamo de libro"
    putStrLn "2. Registrar devolución de libro"
    putStrLn "3. Buscar libro por ID"
    putStrLn "4. Listar libros prestados"
    putStrLn "5. Salir"
        
    opcion <- getLine
    case opcion of
        "1" -> do
            putStrLn "Ingrese el ID del libro a prestar:"
            codigoStr <- getLine
            let codigo = read codigoStr :: Int
            tiempoActual <- getCurrentTime
            let bibliotecaAct = registrarPrestamo codigo tiempoActual biblioteca
            guardarLibreria bibliotecaAct
            cicloPrincipal bibliotecaAct

        "2" -> do
            putStrLn "Ingrese el ID del libro a devolver:"
            codigoStr <- getLine
            let codigo = read codigoStr :: Int
            tiempoActual <- getCurrentTime
            let bibliotecaAct = registrarDevolucion codigo tiempoActual biblioteca
            guardarLibreria bibliotecaAct
            cicloPrincipal bibliotecaAct
            
        "3" -> do
            putStrLn "Ingrese el ID del libro a buscar:"
            codigoStr <- getLine
            let codigo = read codigoStr :: Int
            tiempoActual <- getCurrentTime
            case buscarLibro codigo biblioteca of
                Just libro -> do
                    let duracion = duracionPrestamo libro tiempoActual
                    putStrLn $ "Libro encontrado: " ++ nombreLibro libro ++ " de " ++ autorLibro libro
                    if prestado libro
                        then putStrLn $ "Actualmente prestado, duración: " ++ show duracion ++ " segundos."
                        else putStrLn "Actualmente disponible."
                Nothing -> putStrLn "Libro no encontrado en la biblioteca."
            cicloPrincipal biblioteca

        "4" -> do
            putStrLn "Mostrando lista de libros prestados:"
            let prestados = librosPrestados biblioteca
            if null prestados
                then putStrLn "No hay libros prestados actualmente."
                else mapM_ (putStrLn . mostrarLibro) prestados
            cicloPrincipal biblioteca

        "5" -> putStrLn "¡Hasta luego!"
        
        _ -> do
            putStrLn "Opción no válida. Por favor, seleccione una opción válida."
            cicloPrincipal biblioteca