import java.util.Arrays;

public class Desafioanimales {

    /*
    1. **Dados un arreglo de números y un arreglo de Strings, te corresponde llevar a cabo lo siguiente:
    a. En el arreglo de números:
    - Obtener el máximo y el mínimo
    - Contar elementos pares e impares dentro del arreglo
    - Ordenar el arreglo en orden ascendente
    - Buscar duplicados dentro del arreglo
    b. En el arreglo de String:
    - Contar las vocales de cada texto
    - Ordenar alfabéticamente
    - Encontrar el texto más largo
    - Concatenar todos los textos sin usar +
    2.**Ejecución y Pruebas:**
    Ejecuta el programa y verifica lo solicitado mediante impresiones en consola. public class ArreglosFijosEjercicios {
    // Arreglo de enteros    int[] numeros = {10, 5, 20, 15, 25, 10, 30, 15, 5, 40};
    // Arreglo de String
    // String[] mascotas = {"Perro", "Cabra", "Caballo", "Pez", "Gato", "Loro", "Araña", "Capibara", "Hamster", "Vaca", "Cocodrilo"};}
    */
    public static void numeros(String[] args) {
        System.out.println("Bienvenido a la actividad numeros y animales");

        int[] numeros = {10, 5, 20, 15, 25, 10, 30, 15, 5, 40};
        System.out.println("Los numeros del uno al diez son; " + Arrays.toString(numeros));

        int maximo = numeros[0];
        int minimo = numeros[0];

        for (int num : numeros ){

            maximo = Math.max(maximo, num);
            minimo = Math.min(minimo, num);

        }

        System.out.println("Numero maximo: " + maximo);
        System.out.println("Numero minimo: " + minimo);

        int pares = 0;
        int impares = 0;

        for (int num : numeros){
            if(num % 2 == 0){
                pares++;
            }
            else{
                impares++;
            }
        }
        System.out.println("numeros pares: " + pares);
        System.out.println("numeros impares: " + impares);

        Arrays.sort(numeros);

        System.out.println("Ordenado de menor a mayor: " + Arrays.toString(numeros));

        int[] duplicados;

        for(int i = 0; i < numeros.length-2; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    System.out.println(numeros[i]);
                }
            }
        }
    }
    public static void main(String[] args) {

        //Arreglo de String
        String[] mascotas = {"Perro", "Cabra", "Caballo", "Pez", "Gato", "Loro", "Araña", "Capibara", "Hamster", "Vaca", "Cocodrilo"};

        //Cantidad de vocales
        for (String palabra : mascotas ) {
            int numeroDeVocales = 0;
            for (int i = 0; i < palabra.length(); i++){
                char vocal = palabra.charAt(i);
                if ("aeiou".indexOf(vocal) != -1){
                    numeroDeVocales++;
                }
            }
            System.out.println("El numero total de vocales en la palabra " + palabra + " es: " + numeroDeVocales);
        }

        //Ordenar alfabeticamente
        Arrays.sort(mascotas);
        System.out.println(Arrays.toString(mascotas));

        //Encontrar el texto mas largo
        String[] textoMasLargo = {""};
        for (String palabra : mascotas){
            for (int i = 0; i < palabra.length(); i++) {
                if(textoMasLargo[0].length() < palabra.length()){
                    textoMasLargo[0] = palabra;
                }
            }
        }
        System.out.println("El texto mas largo es " + textoMasLargo[0]);

        //Concatenar sin usar el +
        StringBuilder sb = new StringBuilder();
        for (String palabra : mascotas){
            sb.append(palabra);
        }
        System.out.println("Concatenacion de las palabras " + sb);
    }
}
