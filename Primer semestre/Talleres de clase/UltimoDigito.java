import java.util.Scanner;

public class UltimoDigito {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ultimoDigito(2343431);

        sc.close();

    }

    public static void ultimoDigito(int n) {

        int UD = n - (n / 10) * 10;
        
        System.out.println(UD);

    }

}