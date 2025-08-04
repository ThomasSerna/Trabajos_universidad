import java.util.Scanner;

public class WithoutString {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String base = sc.next();
        String eliminar = sc.next();

        String f = base.replace(eliminar, "");

        System.out.println(f);

        sc.close();
    }
}
