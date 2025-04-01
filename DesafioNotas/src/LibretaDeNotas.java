import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a la libreta de notas");

        obtenerUsuario(entrada);

        int cantidadAlumnos = obtenerCantidadAlumnos(entrada);
        int cantidadNotas = obtenerCantidadNotas(entrada);
        Map<String, List<Double>> alumnoYNotas = new HashMap<>();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno " + (i + 1) + ": ");
            String nombreAlumno = entrada.next();
            alumnoYNotas.put(nombreAlumno, new ArrayList<>());
        }

        obtenerNotas(alumnoYNotas, entrada, cantidadNotas);
        mostrarNotas(alumnoYNotas);

        Map<String,Double> promedios = calcularPromedios(alumnoYNotas);
        menuDeOpciones(entrada, alumnoYNotas, promedios);
    }

    public static void obtenerUsuario(Scanner entrada) {
        System.out.println("Cual es su nombre? ");
        String usuario = entrada.nextLine();
        System.out.println("Bienvenido profesor " + usuario);
    }

    public static Integer obtenerCantidadAlumnos(Scanner entrada) {
        int alumnos;
        while (true) {
            System.out.println("------------------------------------------\n" +
                    "Dime cuantos alumnos tienes? ");
            if (entrada.hasNextInt()) {
                alumnos = entrada.nextInt();
                if (alumnos > 0) {
                    break;
                } else {
                    System.out.println("Su cantidad de alumnos debe ser un numero positivo.");
                }
            } else {
                System.out.println("Ingresa un numero valido");
                entrada.nextLine();
            }
        }
        System.out.println("La cantidad de alumnos en total es " + alumnos +"\n" +
                "------------------------------------------");
        return alumnos;
    }
    public static Integer obtenerCantidadNotas(Scanner entrada) {
        int cantidadNotas;
        while (true){
            System.out.println("Y cuantas notas tiene cada alumno? ");
            if (entrada.hasNextInt()) {
                cantidadNotas = entrada.nextInt();
                if (cantidadNotas > 0) {
                    break;
                } else {
                    System.out.println("Ingresa un numero valido");
                }
            } else {
                System.out.println("ingrese un numero valido");
            }
        }
        System.out.println("La cantidad de notas por alumno es " + cantidadNotas + "\n" +
                "------------------------------------------");
        return cantidadNotas;
    }

    public static Map<String , Double> calcularPromedios(Map<String, List<Double>> alumnos) {
        Map<String,Double> promedios = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : alumnos.entrySet()) {
            double suma = 0;
            for (double nota : entry.getValue()) {
                suma += nota;
            }
            double promedio = suma / entry.getValue().size();
            promedios.put(entry.getKey(), promedio);
            System.out.println("------------------------------------------\n" +
                    "Alumno: " + entry.getKey() + " - Promedio: " + promedio);
        }
        return promedios;
    }

    public static double promedioCurso(Collection<Double> promedios) {
        double suma = 0;
        for (double promedio : promedios) {
            suma += promedio;
        }
        return promedios.isEmpty() ? 0 : suma / promedios.size();
    }

    public static void obtenerNotas (Map<String, List<Double>> alumnos, Scanner entrada, int cantidadNotas){
        for (String alumno: alumnos.keySet()) {
            List<Double> notas = alumnos.get(alumno);
            System.out.println("------------------------------------------\n" +
                                "Ingrese la nota del alumno " + alumno);

            for (int i = 0; i < cantidadNotas; i++){
                double nota;
                while (true) {
                    System.out.println("Nota " + (i + 1) + "(0-7): ");
                    if (entrada.hasNextDouble()) {
                        nota = entrada.nextDouble();
                        if (nota >= 0 && nota <= 7) {
                            break;
                        } else {
                            System.out.println("Dijite un numero valido");
                        }
                    } else {
                        System.out.println("Dijite un dato valido");
                        entrada.next();
                    }
                }
                notas.add(nota);
            }
        }
    }

    public static void mostrarNotas(Map<String, List<Double>> alumnos) {
        for (Map.Entry<String, List<Double>> entry : alumnos.entrySet()) {
            System.out.println("------------------------------------------\n" +
                    "Alumno: " + entry.getKey() + " - Notas: " + entry.getValue() + "\n" +
                    "Nota Máxima: " + Collections.max(entry.getValue()) +
                    " - Nota Mínima: " + Collections.min(entry.getValue()));
        }
    }

    public static void menuDeOpciones(Scanner entrada, Map<String, List<Double>> alumnoYNotas, Map<String, Double> promedios) {
        boolean exit = false;
        do {
            System.out.println("----------------------------------------------------------------------------------------------\n" +
                    "Ingrese la opcion que quiere utilizar.\n" +
                    "1. Mostrar el Promedio de Notas por Estudiante.\n" +
                    "2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.\n" +
                    "3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.\n" +
                    "0. Salir del Menú.\n" +
                    "----------------------------------------------------------------------------------------------\n" +
                    "Ingrese una Opcion: ");
            String opcion = entrada.next();

            switch (opcion) {

                case "1" -> {
                    for (Map.Entry<String, Double> entry : promedios.entrySet()) {
                        System.out.println("Alumno: " + entry.getKey() + " - Promedio: " + entry.getValue());
                    }
                }
                case "2" -> {
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String alumno = entrada.next();
                    if (alumnoYNotas.containsKey(alumno)) {
                        System.out.print("Ingrese una nota del estudiante: ");
                        double nota = entrada.nextDouble();
                        System.out.println(nota >= 4 ? "Aprobado" : "Reprobado");
                    } else {
                        System.out.println("El estudiante no existe.");
                    }
                }
                case "3" -> {
                    double promedioCurso = promedioCurso(promedios.values());
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String alumno = entrada.next();
                    if (alumnoYNotas.containsKey(alumno)) {
                        System.out.print("Ingrese una nota del estudiante: ");
                        double nota = entrada.nextDouble();
                        System.out.println(nota >= promedioCurso
                                ? "Está sobre el promedio del curso (" + promedioCurso + ")"
                                : "Está bajo el promedio del curso (" + promedioCurso + ")");
                    } else {
                        System.out.println("El estudiante no existe.");
                    }
                }
                case "0" -> {
                    exit = true;
                    System.out.println("Gracias por participar en la LibretaDeNotas, Adios");

                }
                default -> System.out.println("Opcion no Valida");
            }
        } while (!exit);
        entrada.close();
    }
}