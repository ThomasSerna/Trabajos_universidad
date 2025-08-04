import java.util.ArrayList;
import java.util.Scanner;

public class Ascendente {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num, temp;
        ArrayList<Integer> arr = new ArrayList<Integer>();

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

        // Eliminar negativos

        for (int i = 0; i < arr.size(); i++){

            if (arr.get(i) < 0) {
                
                arr.remove(i);
                i--;

            }

        }   

        // Ordenar arreglo

        for (int i = 0; i < arr.size(); i++){

            for (int i2 = i + 1; i2 < arr.size(); i2++){

                if (arr.get(i) > arr.get(i2)) {

                    temp = arr.get(i);

                    arr.set(i, arr.get(i2));
                    arr.set(i2, temp);

                }

            }

        }

        // Imprimir

        for (int i = 0; i < arr.size(); i++) {

            System.out.print(arr.get(i) + " ");

        }

        sc.close();

    }
    
}