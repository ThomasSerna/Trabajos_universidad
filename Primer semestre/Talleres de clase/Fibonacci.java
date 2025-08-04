import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = 0;
        int f = 0;

        int n1 = 1, n2 = 0;

        while (i <= n) {
            
            if (i == 0){

                System.out.println(0);

            } else if (i == 1){

                n2 = i;
                
            } else { // i = 2

                f = n1 + n2; // 2
                System.out.println(n1);
                
                n1 = n2;
                n2 = f; // 2

            }

            i++;
            
        }
        
        sc.close();

    }

}