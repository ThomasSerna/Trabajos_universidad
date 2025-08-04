import java.util.Scanner;

public class PrincipalJugador {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Jugador p1 = new Jugador();

        int s = sc.nextInt();
        p1.setSalud(s);

        String n = sc.next();
        p1.setNombre(n);

        int r = sc.nextInt();
        p1.reducirSalud(r);

        r = sc.nextInt();
        p1.reducirSalud(s);

        System.out.println(p1.getNombre() + p1.getSalud());


        
        sc.close();

    }

}
