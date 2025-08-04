public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y){

        this.x = x;
        this.y = y;

    }

    public double getX(){

        return x;

    }

    public double getY(){

        return y;

    }

    public void setX(double x){

        this.x = x;

    }

    public void setY(double y){

        this.y = y;

    }

    public static double distancia(double d1, double d2){

        return d2 - d1;

    }


}