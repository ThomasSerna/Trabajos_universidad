import java.util.Scanner;

public class PrimosRango {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int suma = 0;

        for (int i = a; i <= b; i++){

            if (EsPrimo(i)){

                suma += i;

            }

        }

        if (a < 2 || suma == 0) {

            System.out.println(-1);

        } else {

            System.out.println(suma);

        }
        
        sc.close();

    }

    public static boolean EsPrimo(int n){

        for (int i = 2; i < n; i++){

            if ((n % i) == 0) {

                return false;

            }

        }

        return true;

    }

}