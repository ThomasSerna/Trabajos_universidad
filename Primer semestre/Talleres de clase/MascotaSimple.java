public class MascotaSimple {
    
    private int edad = 8;
    private String nombre;

    public MascotaSimple(){

        nombre = "Kitty";

    }

    public MascotaSimple(String nombre){

        this.nombre = nombre;

    }

    public MascotaSimple(String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;

    }

    public String getNombre(){

        return nombre;

    }

    public int getEdad(){

        return edad;

    }

}
