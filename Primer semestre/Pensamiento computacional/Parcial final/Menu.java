
import java.util.Scanner;

public class Menu {

    public int MenuPrincipal(){

        Scanner sc = new Scanner(System.in);

        System.out.println("0. Terminar programa");
        System.out.println("1. Crear usuario");
        System.out.println("2. Crear libro");
        System.out.println("3. Listar libros");
        System.out.println("4. Listar usuarios");
        System.out.println("5. Comprar libros");
        System.out.println("6. Prestar libros");
        System.out.println("Escribe la opcion a la que quieras acceder: ");

        int opcion = sc.nextInt();

        return opcion;

    }

    public int MenuListarUsuarios(){

        Scanner sc = new Scanner(System.in);

        System.out.println("0. Volver al menu anterior");
        System.out.println("1. Listar todos los usuarios");
        System.out.println("2. Listar usuarios según ciudad");
        System.out.println("3. Listar usuarios según nombre");
        System.out.println("Escribe la opcion a la que quieras acceder: ");

        int opcion = sc.nextInt();

        return opcion;

    }

    public int MenuListarLibros(){

        Scanner sc = new Scanner(System.in);

        System.out.println("0. Volver al menu anterior");
        System.out.println("1. Listar todos los libros");
        System.out.println("2. Listar libros según año");
        System.out.println("3. Listar libros según titulo");
        System.out.println("4. Listar libros según autor");
        System.out.println("Escribe la opcion a la que quieras acceder: ");

        int opcion = sc.nextInt();

        return opcion;
        
    }

}