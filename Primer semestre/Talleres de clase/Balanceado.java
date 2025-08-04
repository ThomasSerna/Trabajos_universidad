public class Balanceado {
    
    public static boolean balancear(int[] arr){
        
        boolean balanceado = false;

        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < arr.length/2; i++){

            sum1 += arr[i];

        }

        for (int i = (arr.length/2) + 1; i < arr.length; i++){

            sum2 += arr[i];

        }
        
        if (sum1 == sum2) { balanceado = true;}

        return balanceado;

    }
}