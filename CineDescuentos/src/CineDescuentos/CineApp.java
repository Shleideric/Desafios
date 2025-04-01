package CineDescuentos;

import java.util.Scanner;

public class CineApp {
    public static void main(String[] args){
        System.out.println("Bienvenido a Cine Yiba");
        System.out.println("Indique la cantidad de boletos deseada");

        Scanner entrada = new Scanner(System.in);
        final int precio = 3500;
        final float descuento1 = 0.6f;
        final float descuento2 = 0.55f;
        final float descuento3 = 0.3f;
        float precioFinal = 0;
        float descuentoFinal;

        if (entrada.hasNextInt()) {
            int boletos = entrada.nextInt();
            if (boletos > 0) {
                for (int a = 1; a <= boletos; a++) {
                    System.out.println("Digame cuantos años tiene para ver si obtiene el descuento");

                    if (entrada.hasNextInt()) {
                        int edad = entrada.nextInt();

                        if (edad > 0 && edad <= 110) {
                            if (edad >= 1 && edad < 5) {
                                descuentoFinal = precio - (descuento1 * precio);
                                System.out.println("El descuento otorgado es del 60%");
                                System.out.println("Aqui tiene su boleto con valor de: " + descuentoFinal);
                                precioFinal += descuentoFinal;
                            } else if (edad > 60) {
                                descuentoFinal = precio - (descuento2 * precio);
                                System.out.println("El descuento otorgado es del 55%");
                                System.out.println("Aqui tiene su boleto con valor de: " + descuentoFinal);
                                precioFinal += descuentoFinal;
                            } else {
                                System.out.println("USted no aplica para el descuento");
                                System.out.println("Aqui tiene su boleto con valor de: " + precio);
                                precioFinal += precio;
                            }
                        } else {
                            System.out.println("Usted ha indicado una edad o dato erroneo, Intentelo de nuevo.");
                            a--;
                        }
                    } else {
                        System.out.println("Usted a indicado una edad fuera de rango, Intentelo de nuevo");
                        entrada.next();
                        a--;
                    }
                }

                if (boletos >= 2) {
                    precioFinal = precioFinal - (precioFinal * descuento3);
                    System.out.println("El precio final es de: " + precioFinal + " con un descuento del 30%");
                } else {
                    System.out.println("El precio final es de: " + precioFinal);
                }
            } else {
                System.out.println("Usted a indicado un dato invalido");
            }
            entrada.close();
        } else {
            System.out.println("Entada invalida de boletos");
        }
    }
}

