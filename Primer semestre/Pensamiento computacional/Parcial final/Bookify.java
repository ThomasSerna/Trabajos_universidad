import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bookify{

    private ArrayList<Usuario> Usuarios = new ArrayList<>();
    private ArrayList<Libro> Libros = new ArrayList<>();
    private int idLibros = 0;

    public static void main(String[] args) {

        Bookify bookify = new Bookify();
        
        System.out.println("Bienvenido a Bookify");
        System.out.println("");

        bookify.GestionMenu();

    }

    public void GestionMenu(){

        Bookify bookify = new Bookify();
        Menu menu = new Menu();

        int menuP = -1;
        int menuLL = 0;
        int menuLU = 0;

        while (menuP < 0 || menuP > 6){

            menuP = menu.MenuPrincipal();

            if (menuP == 1){ 

                bookify.CrearUsuario(); 

            } else if (menuP == 2){ 

                bookify.CrearLibro();

            } else if (menuP == 3){

                while (menuLL <= 0 || menuLL > 4){

                    menuLL = menu.MenuListarLibros();

                    if (menuLL == 1) {

                        bookify.ListarLibrosTodos();

                    } else if (menuLL == 2) {

                        bookify.ListarLibrosAño();
                        
                    } else if (menuLL == 3) {

                        bookify.ListarLibrosTitulo();
                        
                    } else if (menuLL == 4) {

                        bookify.ListarLibrosAutor();
                        
                    }
                }            
            
            } else if (menuP == 4){ 

                while (menuLU <= 0 || menuLU > 3){

                    menuLU = menu.MenuListarUsuarios();

                    if (menuLU == 1) {

                        bookify.ListarUsuariosTodos();

                    } else if (menuLU == 2) {

                        bookify.ListarUsuariosCiudad();
                        
                    } else if (menuLU == 3) {

                        bookify.ListarUsuariosNombre();
                        
                    }
                }
            
            
            } else if (menuP == 5){ 
            
                bookify.ComprarLibro();
            
            } else if (menuP == 6){ 
                
                bookify.PrestarLibro();
            
            }

            if (menuP != 0) {

                menuP = -1;
                
            }

        }
    }

    public void ComprarLibro(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el id del libro que quieras comprar: ");
        int idLib = sc.nextInt();
        Libro lib = Libros.get(0);

        for (int i = 0; i < Libros.size(); i++){

            if (Libros.get(i).getIdLibro() == idLib){

                lib = Libros.get(i);
                i = Libros.size();

            }

        }


        if (lib.getCantidad() >= 1 || lib.getParaVenta() == true){

            lib.setCantidad(lib.getCantidad()-1);
            System.out.println("El libro se vendió exitosamente");

            System.out.println("Dame tu id de usuario: ");
            int idUser = sc.nextInt();
            
            System.out.println("Dime la dirección a la cual será enviado: ");
            String DireccionEnvio = sc.nextLine();


        } else {

            System.out.println("El libro no pudo ser vendido.");

        }

    }

    public void PrestarLibro(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el id del libro que quieras prestar: ");
        int idLib = sc.nextInt();
        Libro lib = Libros.get(0);

        for (int i = 0; i < Libros.size(); i++){

            if (Libros.get(i).getIdLibro() == idLib){

                lib = Libros.get(i);
                i = Libros.size();

            }

        }


        if (lib.getCantidad() >= 1 || lib.getParaPrestar() == true){

            lib.setCantidad(lib.getCantidad()-1);
            System.out.println("El libro se prestó exitosamente");

            System.out.println("Dame tu id de usuario: ");
            int idUser = sc.nextInt();
            
            System.out.println("Dime la dirección a la cual será enviado: ");
            String DireccionEnvio = sc.nextLine();


        } else {

            System.out.println("El libro no pudo ser prestado.");

        }

    }

    public void ListarUsuariosTodos(){

        for (int i = 0; i < Usuarios.size(); i++){

            Usuarios.get(i).ImprimirInfoUsuario();

        }

    }

    public void ListarUsuariosCiudad(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Que ciudad desea usar como filtro: ");
        String ciudad = sc.nextLine();

        for (int i = 0; i < Usuarios.size(); i++){

            if (Usuarios.get(i).getCiudad().equals(ciudad)){

                Usuarios.get(i).ImprimirInfoUsuario();

            }

        }

    }

    public void ListarUsuariosNombre(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Que nombre desea usar como filtro: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < Usuarios.size(); i++){

            if (Usuarios.get(i).getNombre().equals(nombre)){

                Usuarios.get(i).ImprimirInfoUsuario();

            }

        }

    }

    public void ListarLibrosTodos(){

        for (int i = 0; i < Libros.size(); i++){

            Libros.get(i).ImprimirInfoLibro();

        }

    }

    public void ListarLibrosAño(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Que año desea usar como filtro: ");
        int año = sc.nextInt();

        for (int i = 0; i < Libros.size(); i++){

            if (Libros.get(i).getAño() == año){

                Libros.get(i).ImprimirInfoLibro();

            }

        }

    }

    public void ListarLibrosTitulo(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Que titulo desea usar como filtro: ");
        String Titulo = sc.nextLine();

        for (int i = 0; i < Libros.size(); i++){

            if (Libros.get(i).getTitulo().equals(Titulo)){

                Libros.get(i).ImprimirInfoLibro();

            }

        }

    }

    public void ListarLibrosAutor(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime cuantos autores tiene el libro, para poder filtrarlos");
        int autoresN = sc.nextInt();

        System.out.println("Escribe los autores, separandolos por renglones");

        String[] autores = new String[autoresN];
        for (int i = 0; i < autores.length; i++){

            String autor = sc.nextLine();
            autores[i] = autor;

        }

        for (int i = 0; i < Libros.size(); i++){

            if (Arrays.equals(Libros.get(i).getAutor(), autores)){

                Libros.get(i).ImprimirInfoLibro();

            }

        }

    }


    public void CrearUsuario(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime tu nombre:");
        String nombre = sc.nextLine();

        System.out.println("Dime tu email:");
        String email = sc.nextLine();

        System.out.println("Dime tu identificación:");
        float id = sc.nextFloat();

        System.out.println("Dime tu telefono:");
        float telefono = sc.nextFloat();

        System.out.println("Dime la ciudad en que vives:");
        String ciudad = sc.nextLine();

        System.out.println("Dime la dirección en que vives:");
        String direccion = sc.nextLine();

        Usuario user = new Usuario(nombre, email, id, telefono, ciudad, direccion);
        
        Usuarios.add(user);

    }

    public void CrearLibro(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime tu id de Usuario:");
        int id = sc.nextInt();

        System.out.println("Dime el titulo del libro:");
        String titulo = sc.nextLine();

        System.out.println("Dime cuantos autores tiene el libro");
        int autoresN = sc.nextInt();

        System.out.println("Escribe los autores, separandolos por renglones");
        String[] autores = new String[autoresN];
        for (int i = 0; i < autores.length; i++){

            String autor = sc.nextLine();
            autores[i] = autor;

        }
        

        System.out.println("Dime el año de salida del libro:");
        int año = sc.nextInt();

        System.out.println("Dime el precio del libro:");
        int precio = sc.nextInt();

        System.out.println("Dime la cantidad de libros que vas a vender:");
        int cantidad = sc.nextInt();

        System.out.println("Dime una reseña del libro:");
        String reseña = sc.nextLine();

        System.out.println("El libro estará disponible para la venta:");
        boolean ParaVenta = sc.nextBoolean();

        System.out.println("El libro estará disponible para prestamo:");
        boolean ParaPrestamo = sc.nextBoolean();

        Libro book = new Libro(idLibros, id, titulo, autores, año, precio, cantidad, reseña, ParaVenta, ParaPrestamo);
        

        Libros.add(book);
        idLibros++;

    }



}