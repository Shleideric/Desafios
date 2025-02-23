import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Bienvenido a la aplicación ComisionApp");
        System.out.println("Registre su usuario: ");
        String nombre = Sc.nextLine();
        System.out.println("Bienvenido " + nombre);
        System.out.println("Ingrese las Ventas");
        final double comision1 = 0.6;
        final double comision2 = 0.55;
        final double comision3 = 0.3;
        double comision;
        if (Sc.hasNextDouble()) {
            double numero = Sc.nextDouble();
            if (numero >= 0) {
                if (numero > 100000) {
                    comision = numero * comision1;
                    System.out.println("Se le aplico una comision del 30% y su monto subio " + comision);
                } else if (numero >= 50001 && numero <= 90999) {
                    comision = numero * comision2;
                    System.out.println("Se le aplico una comision del 20% y su monto subio " + comision);
                } else if (numero >= 10001 && numero <=40999) {
                    comision = numero * comision3;
                    System.out.println("Se le aplico una comision del 10% y su monto subio " + comision);
                } else{
                    System.out.println("Usted no aplica para la comision");
                }

            } else {
                System.out.println("El número no puede ser negativo");
        }

        }else{
            System.out.println("Dato Invalido");
        }Sc.close();
    }
}