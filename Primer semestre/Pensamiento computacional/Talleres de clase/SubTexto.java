import java.util.Arrays;
import java.util.Scanner;

public class SubTexto {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String p = sc.next();
        
        int nI = sc.nextInt();
        int nF = sc.nextInt();

        if (nF>p.length()) {

            System.out.println("Error");

        } else if (nI>nF) {

            System.out.println("Error2");

        } else {

        char[] SubCadena = Arrays.copyOfRange(p.toCharArray(), nI, nF+1);        
        String SubCadenaF = new String(SubCadena);

        System.out.println(SubCadenaF);

        }

        sc.close();

    }

}