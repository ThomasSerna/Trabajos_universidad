    import java.util.Scanner;

    public class PrincipalCalculadoraSimple {
        
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            CalculadoraSimple cal = new CalculadoraSimple();

            int n1 =  sc.nextInt();
            int n2 =  sc.nextInt();

            System.out.println(cal.sumar(n1,n2));
            System.out.println(cal.restar(n1,n2));
            
            sc.close();     

        }

    }
