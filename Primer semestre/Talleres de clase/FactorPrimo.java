import java.util.Scanner;

public class FactorPrimo {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int mFactor = 1, nTemp = n ;
        String Factores = "";


        if (n > 0){

            for (int i = 2; nTemp != 1; i++){

                if ( (nTemp%i) == 0) {

                    mFactor = mFactor * i;
                    nTemp = nTemp / i;

                    Factores = Factores + Integer.toString(i) + " ";

                    i = 1;

                }

            }

        } else {System.out.println(-1);}

        System.out.println(Factores);

        sc.close();

    }
}