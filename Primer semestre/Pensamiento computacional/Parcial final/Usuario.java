public class Usuario {
    
    private String Nombre;
    private String Email;
    private float Identificacion;
    private float Telefono;
    private String Ciudad;
    private String Direccion;

    public Usuario(){

        Nombre = "";
        Email = "";
        Identificacion = 0;
        Telefono = 0;
        Ciudad = "";
        Direccion = "";

    }

    public Usuario(String Nombre, String Email, float Identificacion, float Telefono, String Ciudad, String Direccion){

        this.Nombre = Nombre;
        this.Email = Email;
        this.Identificacion = Identificacion;
        this.Telefono = Telefono;
        this.Ciudad = Ciudad;
        this.Direccion = Direccion;

    }

    public String getNombre(){

        return Nombre;

    }
    
    public String getCiudad(){

        return Ciudad;

    }

    public float getIdentificacion(){

        return Identificacion;

    }

    public void setCiudad(String Ciudad){

        this.Ciudad = Ciudad;

    }

    public void setDireccion(String Direccion){

        this.Direccion = Direccion;

    }

    public void ImprimirInfoUsuario(){

        System.out.println("Nombre: " + Nombre);
        System.out.println("Email: " + Email);
        System.out.println("Identificacion: " + Identificacion);
        System.out.println("Telefono: " + Telefono);
        System.out.println("Ciudad: " + Ciudad);
        System.out.println("Dirección: " + Direccion);

    }


}
