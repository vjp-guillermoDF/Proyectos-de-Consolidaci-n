/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicatema7ej16;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class PracticaTema7ej16 {

    public static void peorAsignatura(int[][] notas, String[] alumnos, String[] asignaturas) {
        int peorMedia = 10;
        String peorAsignatura = "";
        for (int i = 0; i < asignaturas.length; i++) {

            int suma = 0;

            for (int j = 0; j < alumnos.length; j++) {

                suma += notas[j][i];

            }

            int media = suma / alumnos.length;

            if (media < peorMedia) {
                peorMedia = media;
                peorAsignatura = asignaturas[i];

            }
        }

        System.out.println("La asignatura mas dificil es " + peorAsignatura + " con una media de " + peorMedia + ".");

    }

    public static void peorAlumno(int[][] notas, String[] alumnos, String[] asignaturas) {
        int numSuspensos = 0;

        String peorAlumno = "";

        for (int i = 0; i < alumnos.length; i++) {
            int contador = 0;
            for (int j = 0; j < asignaturas.length; j++) {

                if (notas[i][j] < 5) {
                    contador++;
                }

            }
            if (contador > numSuspensos) {
                numSuspensos = contador;
                peorAlumno = alumnos[i];
            }
        }
        System.out.println("El peor alumno es " + peorAlumno + " con un sumero de suspensos de " + numSuspensos + ".");
    }

    public static void mejorAlumno(int[][] notas, String[] alumnos, String[] asignaturas) {
        int mejorMedia = 0;
        String mejorAlumno = "";
        for (int i = 0; i < alumnos.length; i++) {
            int suma = 0;
            for (int j = 0; j < asignaturas.length; j++) {
                suma += notas[i][j];

            }

            int media = suma / asignaturas.length;
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = alumnos[i];
            }
        }

        System.out.println("El mejor alumno es " + mejorAlumno + " con media de " + mejorMedia + ".");

    }

    public static void rellenarNotas(int[][] notas, String[] alumnos, String[] asignaturas) {
        Scanner entrada = new Scanner(System.in);
        String[] nombres = {"Elena Nito", "Armando J.Leo", "Ines Perado", "Segundo Toro de la Tarde", "Consuelo O'Sinnell", "Lola Mento"};
        String[] nombreAs = {"Lengua", "Mates", "Historia", "Fisica"};
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < asignaturas.length; j++) {
                alumnos[i] = nombres[i];
                asignaturas[j] = nombreAs[j];
                System.out.println("Introduce la nota de " + alumnos[i] + " para la asignatura " + asignaturas[j] + ":");
                notas[i][j] = entrada.nextInt();
            }

        }

    }

    public static void mostrarNotas(int[][] notas, String[] alumnos, String[] asignaturas) {

        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < asignaturas.length; j++) {
                System.out.println("La nota del alumno " + alumnos[i] + " en la asignatura " + asignaturas[j] + " es: " + notas[i][j] + ".");
            }

        }

    }

    public static void menu(int[][] notas, String[] alumnos, String[] asignaturas) {
        Scanner entrada = new Scanner(System.in);

        boolean cerrar = false;

        do {
            try {

                System.out.println("1 para rellenar notas");
                System.out.println("2 para mostrar las notas");
                System.out.println("3 para mostrar al mejor alumno");
                System.out.println("4 para mostrar al peor alumno");
                System.out.println("5 para la asignatura mas dificil");
                System.out.println("6 para salir del programa");

                switch (entrada.nextInt()) {
                    case 1:
                        rellenarNotas(notas, alumnos, asignaturas);
                        break;
                    case 2:
                        mostrarNotas(notas, alumnos, asignaturas);
                        break;
                    case 3:
                        mejorAlumno(notas, alumnos, asignaturas);
                        break;
                    case 4:
                        peorAlumno(notas, alumnos, asignaturas);
                        break;
                    case 5:
                        peorAsignatura(notas, alumnos, asignaturas);
                        break;
                    case 6:

                        System.out.println("Saliendo del sistema.");

                        cerrar = true;
                        break;

                    default:

                        System.out.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR");
                entrada.nextLine();
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] alumnos = new String[6];
        String[] nombreAs = new String[4];
        int[][] notas = new int[alumnos.length][4];
        menu(notas, alumnos, nombreAs);

    }
}
