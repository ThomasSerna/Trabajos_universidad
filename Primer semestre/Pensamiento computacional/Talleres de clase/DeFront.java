import java.util.Arrays;
import java.util.Scanner;

public class DeFront {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String p = sc.next().toLowerCase();

        char[] pc = p.toCharArray();

        String CadenaDeFront = DeFr(pc);

        System.out.println(CadenaDeFront);
        
        sc.close();

    }

    public static String DeFr(char[] pc){
        
        String f;

        if (pc[0] == 'a') {

            if (pc[1] == 'b'){

                f = new String(pc);

            } else {

            char[] pcf = Arrays.copyOfRange(pc, 1, pc.length);
            pcf[0] = 'a';
            f = new String(pcf);

            }

        } else if (pc[1] == 'b') {

            char[] pcf = Arrays.copyOfRange(pc, 1, pc.length);
            pcf[0] = 'b';
            f = new String(pcf);
            

        } else {

            char[] pcf = Arrays.copyOfRange(pc, 2, pc.length);
            f = new String(pcf);

        }

        return f;
    }
}