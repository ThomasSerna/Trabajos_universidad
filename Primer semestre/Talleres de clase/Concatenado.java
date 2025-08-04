import java.util.ArrayList;
import java.util.Scanner;

public class Concatenado {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num;
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arrF = new ArrayList<Integer>();

        // Llenar arreglos

        for (int i = 0; i < n; i++){

            num = sc.nextInt();

            if (num>=1 && num<=50){
                
                arr1.add(num);

            } else {

                System.out.println(-1);
                return;

            }

        }

        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++){

            num = sc.nextInt();

            if (num>=1 && num<=50){
                
                arr2.add(num);

            } else {

                System.out.println(-1);
                return;

            }

        }

        // Concatenar arreglos

        for (int i = 0; i < arr1.size(); i++){

            arrF.add(arr1.get(i));

        }

        for (int i = 0; i < arr2.size(); i++){

            arrF.add(arr2.get(i));

        }

        // Imprimir

        for (int i = 0; i < arrF.size(); i++) {

            System.out.print(arrF.get(i) + " ");

        }
        
        sc.close();

    }

}