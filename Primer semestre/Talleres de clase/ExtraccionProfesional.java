import java.util.Scanner;

public class ExtraccionProfesional {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String texto = sc.nextLine();

        String htmlNombre = "<div class='name'>";
        String htmlApellido = "<div class='lastname'>";
        String htmlFin = "</div>";

        int InicioNombre = htmlNombre.length();
        int FinNombre = texto.indexOf(htmlFin, InicioNombre);

        int InicioApellido = texto.indexOf(htmlApellido) + htmlApellido.length();
        int FinApellido = texto.indexOf(htmlFin, InicioApellido);   
        
        String Nombre = texto.substring(InicioNombre, FinNombre);
        String Apellido = texto.substring(InicioApellido, FinApellido);        

        System.out.println(Nombre + Apellido);


        sc.close();

    }

}