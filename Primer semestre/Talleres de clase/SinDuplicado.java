import java.util.ArrayList;
import java.util.Scanner;

public class SinDuplicado {
    
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < n; i++){

            int num = sc.nextInt();

            if (num>=1 && num<=100){
                
                arr.add(num);

            } else {

                System.out.println(-1);

            }

        }

        for (int i = 0; i < arr.size(); i++){

            for (int i2 = i + 1; i2 < arr.size(); i2++){

                if (arr.get(i).equals(arr.get(i2))){

                    arr.remove(i2);
                    i2--;

                }

            }

        }

        System.out.println(arr.toString());

        /*
        for (int i = 0; i < arr.size(); i++){

            System.out.println(arr.get(i));

        }
        */

        sc.close();

    }

}
