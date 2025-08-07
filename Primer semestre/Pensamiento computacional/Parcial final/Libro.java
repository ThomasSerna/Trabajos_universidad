public class Libro {

    private int idLibro;
    private int idUsuario;
    private String Titulo;
    private String[] Autores;
    private int Año;
    private int Precio;
    private int Cantidad;
    private String Reseña;
    private boolean ParaVenta;
    private boolean ParaPrestamo;

    public Libro(){

        idLibro = 0;
        idUsuario = 0;
        Titulo = "";
        Autores = new String[0];
        Año = 0;
        Precio = 0;
        Cantidad = 0;
        Reseña = "";
        ParaVenta = false;
        ParaPrestamo = false;

    }

    public Libro(int idLibro, int idUsuario, String Titulo, String[] Autores, int Año, int Precio, int Cantidad, String Reseña, boolean ParaVenta, boolean ParaPrestamo){


        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.Titulo = Titulo;
        this.Autores = Autores;
        this.Año = Año;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Reseña = Reseña;
        this.ParaVenta = ParaVenta;
        this.ParaPrestamo = ParaPrestamo;


    }

    public String getTitulo(){

        return Titulo;

    }
    
    public int  getAño(){

        return Año;

    }

    public int getCantidad(){

        return Cantidad;

    }

    public boolean  getParaVenta(){

        return ParaVenta;

    }

    public boolean getParaPrestar(){

        return ParaPrestamo;

    }

    public int  getIdLibro(){

        return idLibro;

    }

    public String[] getAutor(){

        return Autores;

    }

    public void setPrecio(int Precio){

        this.Precio = Precio;

    }

    public void setCantidad(int Cantidad){

        this.Cantidad = Cantidad;

    }

    public void ImprimirInfoLibro(){

        System.out.println("Id del libro: " + idLibro);
        System.out.println("idUsuario: " + idUsuario);
        System.out.println("Titulo: " + Titulo);

        System.out.println("Autores: ");
        for (int i = 0; i < Autores.length; i++) {

            System.out.println(Autores[i]);
            
        }

        System.out.println("Año: " + Año);
        System.out.println("Precio: " + Precio);
        System.out.println("Cantidad: " + Cantidad);
        System.out.println("Reseña: " + Reseña);

        

    }

}