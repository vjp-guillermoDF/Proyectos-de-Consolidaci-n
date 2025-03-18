/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicat8ej9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Test {

    public static final int MAX = 3;

    public static Scanner entrada = new Scanner(System.in);

    public static void peorAsignatura(Alumno[] alumno, String[] nombreAs) {
        float suma;
        float nota = 10;
        int peorAsignatura = 0;

        for (int i = 0; i < nombreAs.length; i++) {
            suma = 0.0f;
            for (int j = 0; j < alumno.length; j++) {
                suma += alumno[j].asignaturaPosicion(i);
            }
            if (suma < nota) {
                nota = suma;
                peorAsignatura = i;
            }
        }

        nota /= (float) alumno.length;

        System.out.println("La asignatura mas dificil es " + nombreAs[peorAsignatura] + " con una media de " + nota + ".");

    }

    public static void peorAlumno(Alumno[] alumno) {
        String peorAlumno = "";
        int suspensos = 0;
        int contador = 0;
        int todoAprobado = 0;

        for (Alumno i : alumno) {
            if (i.numeroSuspensos() > suspensos) {
                suspensos = i.numeroSuspensos();
                peorAlumno = i.getNombreAlumno();
            } else if (i.numeroSuspensos() == suspensos) {
                peorAlumno += ", " + i.getNombreAlumno();
            }

            if (i.numeroSuspensos() == i.getNota().length) {
                contador++;
            } else if (i.numeroSuspensos() == 0) {
                todoAprobado++;
            }

        }

        if (contador == alumno.length) {
            System.out.println("Todos los alumnos han suspendido todo.");
        } else if (todoAprobado == alumno.length) {
            System.out.println("Todos los alumnos han aprobado todo.");
        } else {
            System.out.println("El alumno o alumno con mas suspensos son " + peorAlumno + " con un total de " + suspensos + " suspenso(s).");
        }
    }

    public static void mejorALumno(Alumno[] alumno) {
        float mejorMedia = 0.0f;
        String mejorAlumno = "";
        int mismaMedia = 0;
        for (Alumno i : alumno) {
            if (i.obtenerMedia() > mejorMedia) {
                mejorMedia = i.obtenerMedia();

                mejorAlumno = i.getNombreAlumno();

            } else if (i.obtenerMedia() == mejorMedia) {
                mismaMedia++;

                mejorAlumno += ", " + i.getNombreAlumno();

            }

        }
        if (mismaMedia == alumno.length) {
            System.out.println("Todos los alumnos tienen la misma media de " + mejorMedia + ".");
        } else {

            System.out.println("El mejor o mejores alumnos son " + mejorAlumno + " con una nota media de " + mejorMedia + ".");

        }
    }

    public static void menu(Alumno[] alumno) {
        String[] nombreAs = {"Lengua", "Mates", "Historia", "Fisica"};
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
                        for (Alumno i : alumno) {
                            i.establecerNota();
                        }
                        break;
                    case 2:
                        for (Alumno i : alumno) {
                            i.mostrarNota();
                        }
                        break;
                    case 3:
                        mejorALumno(alumno);

                        break;
                    case 4:
                        peorAlumno(alumno);
                        break;
                    case 5:
                        peorAsignatura(alumno, nombreAs);
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
        Alumno[] alumno = new Alumno[MAX];

        boolean notNull = false;

        int i = 0;

        while (i < alumno.length) {

            if (alumno[i] == null) {
                alumno[i] = new Alumno();
                i++;

            } else {
                notNull = true;
            }

        }

        menu(alumno);

    }

}
