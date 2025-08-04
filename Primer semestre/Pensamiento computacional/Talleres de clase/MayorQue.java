public class MayorQue {

    public static void mayor(int[] arr) {
        
        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();*/

        int[] arreglo = arr;
        boolean HayMayores = false;

        /*for (int i = 0; i < n; i++){

            arreglo[i] = sc.nextInt();

        } */

        for (int i = 1; i < arreglo.length; i++){

            if (arreglo[0] < arreglo[i]){

                System.out.println(arreglo[i]);
                HayMayores = true;

            }

        }

        if (HayMayores == false) {

            System.out.println("No hay ningun numero mayor que el primero");

        }
        
        //sc.close();

    }

}