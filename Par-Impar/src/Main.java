import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        Scanner Sc= new Scanner(System.in);
        {
            System.out.println("Bienvenido al detector de par e impar");
            System.out.println("Dime algún numero");
            int a = Sc.nextInt();
            /*if (a % 2 == 0) {
                System.out.println("Tu numero es par: " + a);
            } else {
                System.out.println("Este numero es impar: " + a);
            }*/
            /*************** OPERADORES TERNARIO *****************/
            String mensaje = (a == 0) ? "El 0 ya es par" : (a % 2 == 0) ? "Tu numero es par" : "Este numero es impar";
            System.out.println(mensaje);
            Sc.close();
        }

    }
}
