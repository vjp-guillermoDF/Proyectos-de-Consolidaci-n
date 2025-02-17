/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej16;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema7ej16 {

    public static final Scanner entrada = new Scanner(System.in);

    private static final String[] ALUMNOS = new String[6];

    private static final String[] ASIGNATURAS = new String[4];

    private static final int[][] NOTAS = new int[ALUMNOS.length][ASIGNATURAS.length];

    public static void peorAsignatura(int[][] tablaVacia, String[] alumnos, String[] asignaturas) {
        int suma;
        int media;
        int min = 10;

        for (int j = 0; j < tablaVacia[0].length; j++) {
            suma = 0;
            for (int i = 0; i < tablaVacia.length; i++) {
                suma += tablaVacia[i][j];

            }
            media = suma / tablaVacia.length;

            if (media < min) {
                min = media;

                System.out.println("La asignatura con la media más baja es: " + asignaturas[j] + " con " + min + ".\n");

            }
        }
    }

    public static void peorAlumno(int[][] tablaVacia, String[] alumnos, String[] asignaturas) {
        int suspensos;
        int contador;
        int max = 0;
        int peorIndice = 0;
        for (int i = 0; i < tablaVacia.length; i++) {
            contador = 0;
            for (int j = 0; j < tablaVacia[i].length; j++) {
                if (tablaVacia[i][j] < 5) {
                    contador++;

                }

            }
            suspensos = contador;

            if (suspensos > max) {
                max = suspensos;
                peorIndice = i;
            }
        }
        if (peorIndice != -1) {
            System.out.println("El alumno más LAMENTABLE y piojoso es " + alumnos[peorIndice] + " con " + max + " suspensos.\n");
        } else {
            System.out.println("¡Increíble! Nadie ha suspendido.\n");
        }
    }

    public static void mejorAlumno(int[][] tablaVacia, String[] alumnos, String[] asignaturas) {
        int suma;
        int media;
        int max = 0;
        int mejor = 0;

        for (int i = 0; i < tablaVacia.length; i++) {
            suma = 0;
            for (int j = 0; j < tablaVacia[i].length; j++) {
                suma += tablaVacia[i][j];

            }
            media = suma / tablaVacia[i].length;

            if (media > max) {
                max = media;
                mejor = i;

            }
        }
        System.out.println("El alumno con la media mas alta es " + alumnos[mejor] + " con una media de " + max + ".\n");

    }

    public static void mostrarNotas(int[][] tablaVacia, String[] alumnos, String[] asignaturas) {
        for (int i = 0; i < tablaVacia.length; i++) {
            for (int j = 0; j < tablaVacia[j].length; j++) {

                System.out.println("La nota de " + alumnos[i] + " en la asignatura de " + asignaturas[j] + " es " + tablaVacia[i][j] + ".\n");

            }
        }

    }

    public static void llenarNotas(int[][] tablaVacia, String[] alumnos, String[] asignaturas) {

        String[] datos = {"Lengua", "Mates", "Historia", "Fisica"};
        String[] nombres = {"Elena Nito", "Ines Perado", "Consuelo O' Sinell", "Armando J. Leo", "Justin Case", "Segundo Toro de la Tarde"};

        for (int i = 0; i < tablaVacia.length; i++) {
            for (int j = 0; j < tablaVacia[j].length; j++) {
                alumnos[i] = nombres[i];
                asignaturas[j] = datos[j];
                System.out.println("Introduzca la nota de " + alumnos[i] + " en la asignatura de " + asignaturas[j] + ".");
                tablaVacia[i][j] = escaner();
            }
        }

    }

    public static void menu() {
        boolean cerrarBucle = false;
        System.out.println("Pulse 1 para introducir las notas de los alumnos.\nPulse 2 para ver las notas introducidas.\nPulse 3 para mostrar al alumno con la media mas alta.\nPulse 4 para mostrar al PEOR alumno.\nPulse 5 para mostrar la asignatura con la media mas baja.\nPulse 6 para salir del programa.");
        do {
            int var = escaner();
            switch (var) {
                case 1:
                    llenarNotas(NOTAS, ALUMNOS, ASIGNATURAS);
                    System.out.println("Pulse 2 para ver las notas introducidas.");
                    break;

                case 2:
                    mostrarNotas(NOTAS, ALUMNOS, ASIGNATURAS);
                    System.out.println("Pulse 3 para mostrar al alumno con la media mas alta.\n");
                    break;

                case 3:
                    mejorAlumno(NOTAS, ALUMNOS, ASIGNATURAS);
                    System.out.println("Pulse 4 para mostrar al alumno mas lamentable y MELIFLUO.");
                    break;

                case 4:
                    peorAlumno(NOTAS, ALUMNOS, ASIGNATURAS);
                    System.out.println("Pulse 5 para ver la asignatura con la media mas baja.");

                    break;

                case 5:
                    peorAsignatura(NOTAS, ALUMNOS, ASIGNATURAS);
                    System.out.println("Pulse 6 para salir del programa.");
                    break;

                case 6:
                    cerrarBucle = true;
                    System.out.println("Ha finalizado el programa.");
                    break;

                default:
                    throw new AssertionError();
            }

        } while (!cerrarBucle);
    }

    public static int escaner() {

        while (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            entrada.nextInt();
        }
        return entrada.nextInt();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

}
