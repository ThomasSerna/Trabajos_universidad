import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int prodPar = 1, prodImp = 1;

        // Llenar arreglos

        for (int i = 0; i < n; i++){

            num = sc.nextInt();

            if (num>=1 && num<=50){
                
                arr.add(num);

            } else {

                System.out.println(-1);
                return;

            }

        }

        // Producto de los pares

        for (int i = 0; i < arr.size(); i++){

            if ((arr.get(i) % 2) == 0){

                prodPar = prodPar * arr.get(i);

            }

        }

        // Producto de los impares

        for (int i = 0; i < arr.size(); i++){

            if ((arr.get(i) % 2) != 0){

                prodImp = prodImp * arr.get(i);

            }

        }

        // Imprimir valores

        System.out.println(prodPar);
        System.out.println(prodImp);

        sc.close();

    }

}
