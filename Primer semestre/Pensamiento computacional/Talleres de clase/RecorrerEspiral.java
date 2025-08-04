import java.util.Scanner;

public class RecorrerEspiral {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 6, 9}
        };

        /*
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[][] arreglo = crearMatriz(n, m);
        */

        recorrerEspiral(matriz);

        sc.close();

    }

    public static int[][] recorrerEspiral(int[][] arr) {
        
        int[][] arr2 = new int[arr.length][arr.length];



        return arr2;        

    }

    public static void imprimirMatriz(int[][]arr){

        for (int i = 0; i < arr.length; i++){

            for (int i2 = 0; i2 < arr[i].length; i2++){

                System.out.println(arr[i][i2]);

            }

        }

    }

    public static int[][] crearMatriz(int n, int m){

        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++){

            for (int i2 = 0; i2 < arr[i].length; i2++){

                int v = sc.nextInt();

                arr[i][i2] = v;

            }

        }

        sc.close();

        return arr;
    }

}