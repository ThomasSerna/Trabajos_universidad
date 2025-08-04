import java.util.Scanner;

public class Invertido {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("-1");
            sc.close();
            return;
        }

        int nElementos = sc.nextInt();

        int[] nArreglo = new int[nElementos];
        int temp = 0;

        for (int i = 0; i < nArreglo.length; i++){

            if (!sc.hasNextDouble()) {

                System.out.println("-1");

                sc.close();
                return;
            }

            nArreglo[i] = sc.nextInt();

        }

        for (int i = 0; i<nElementos/2; i++){

            temp = nArreglo[i];
            nArreglo[i] = nArreglo[nArreglo.length - 1 - i];
            nArreglo[nArreglo.length - 1 - i] = temp;

        }

        for (int i = 0; i < nElementos; i++) {
            System.out.print(nArreglo[i] + " ");
        }

        //System.out.println(Arrays.toString(nArreglo));
        
        sc.close();

    }

}
