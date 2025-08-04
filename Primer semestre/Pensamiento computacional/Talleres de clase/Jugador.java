public class Jugador {
    
    private String nombre;
    private int salud;

    public String getNombre(){

        return nombre;

    }

    public int getSalud(){

        return salud;

    }

    public void setNombre(String nombre){

        this.nombre = nombre;

    }

    public void setSalud(int salud){

        this.salud = salud;

    }

    public void reducirSalud(int s){

        salud = salud - s;

    }

}
