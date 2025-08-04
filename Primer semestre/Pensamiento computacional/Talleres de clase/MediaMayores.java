import java.util.ArrayList;
import java.util.Scanner;

public class MediaMayores {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double num;
        ArrayList<Double> arr = new ArrayList<Double>();
        ArrayList<Double> arrF = new ArrayList<Double>();
        double suma = 0;
        double prom = 0;

        // Llenar arreglos

        for (int i = 0; i < n; i++){

            num = sc.nextDouble();

            arr.add(num);

        }

        // Media del arreglo

        for (int i = 0; i < arr.size(); i++){

            suma += arr.get(i);

        }

        prom = suma/arr.size();

        // Arreglo con mayores al promedio

        for (int i = 0; i < arr.size(); i++){

            if (arr.get(i) > prom){

                arrF.add(arr.get(i));

            }

        }

        // Imprimir arreglo y promedio

        System.out.println(prom);

        for (int i = 0; i < arrF.size(); i++) {

            System.out.print(arrF.get(i) + " ");

        }

        sc.close();
        
    }

}
