import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenida al detector de palabras, aqui podras invertir las palabras que escribas");
        Scanner invertido = new Scanner(System.in);
        System.out.print("Ingrese la palabra que quieres invertir: ");
        String texto = invertido.nextLine();

        String invertir = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertir += texto.charAt(i);
        }

        System.out.println("El texto al invertirlo es: " + invertir);
        invertido.close();
    }
}

