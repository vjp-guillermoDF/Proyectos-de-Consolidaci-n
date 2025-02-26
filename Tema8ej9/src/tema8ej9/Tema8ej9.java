/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej9;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema8ej9 {

    public static Scanner entrada = new Scanner(System.in);

    public static final Alumno[] LISTAALUMNOS = new Alumno[3];

    public static final Asignatura ASIGNATURAS[] = new Asignatura[4];

    public static void asignaturaConPeorMedia(Alumno[] listaAlumnos, Asignatura[] asignaturas) {

        asignaturas = listaAlumnos[0].getNota();
        Asignatura asignaturaPeor = null;
        double peorMedia = 10;

        for (Asignatura i : asignaturas) {
            double sumaNotas = 0;
            int numAlumnos = listaAlumnos.length;

            for (Alumno j : listaAlumnos) {
                for (Asignatura k : j.getNota()) {
                    if (k == i) {
                        sumaNotas += k.getNota();
                    }
                }
            }

            double media = sumaNotas / numAlumnos;
            System.out.println("La media de " + i.getNombreAs() + " es " + media);

            if (media < peorMedia) {
                peorMedia = media;
                asignaturaPeor = i;
            }
        }

        if (asignaturaPeor != null) {
            System.out.println("La asignatura con la media más baja es " + asignaturaPeor.getNombreAs() + " con una media de " + peorMedia);
        }
    }

    public static void alumnoConMasSuspensos(Alumno[] listaAlumnos) {
        int maxSuspensos = 0;
        String alumnoMasSuspensos = "";

        for (Alumno alumno : listaAlumnos) {
            int suspensos = 0;

            for (Asignatura asignatura : alumno.getNota()) {
                if (asignatura.getNota() < 5) {
                    suspensos++;
                }
            }

            System.out.println(alumno.getNombreAl() + " tiene " + suspensos + " suspensos.");

            if (suspensos > maxSuspensos) {
                maxSuspensos = suspensos;
                alumnoMasSuspensos = alumno.getNombreAl();
            }
        }

        if (maxSuspensos > 0) {
            System.out.println("El alumno con más suspensos es " + alumnoMasSuspensos + " con " + maxSuspensos + " suspensos.");
        } else {
            System.out.println("Ningún alumno tiene suspensos.");
        }
    }

    public static void mejorAlumno(Alumno[] listaAlumnos) {
        double mejorMedia = 0;
        String mejorAlumno = "";

        for (Alumno i : listaAlumnos) {
            double sumaNotas = 0;
            int numAsignaturas = i.getNota().length;

            for (Asignatura asignatura : i.getNota()) {
                sumaNotas += asignatura.getNota();

            }

            double media = sumaNotas / numAsignaturas;
            System.out.println("El alumno " + i.getNombreAl() + " tiene una media de " + media);
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = i.getNombreAl();

            }

        }
        System.out.println("El mejor alumno es " + mejorAlumno + " con una media de " + mejorMedia);
    }

    public static void mostrarLista(Alumno[] listaAlumnos) {
        for (Alumno i : listaAlumnos) {
            System.out.println("Notas de " + i.getNombreAl() + ":");
            for (Asignatura j : i.getNota()) {
                System.out.println("  " + j.getNombreAs() + ": " + j.getNota());
            }
            System.out.println();
        }
    }

    public static void crearLista(Alumno[] listaAlumnos, Asignatura[] asignaturas) {
        String[] nombresAl = {"Elena Nito", "Consuelo O'Sinnell", "Segundo Toro de la Tarde"};
        String[] nombresAs = {"Lengua", "Mates", "Historia", "Fisica"};

        for (int i = 0; i < listaAlumnos.length; i++) {
            asignaturas = new Asignatura[nombresAs.length];
            for (int j = 0; j < nombresAs.length; j++) {
                asignaturas[j] = new Asignatura(nombresAs[j], 0);
            }

            listaAlumnos[i] = new Alumno(nombresAl[i], asignaturas);
        }
    }

    public static void pedirNota(Alumno[] listaAlumnos) {
        for (Alumno alumno : listaAlumnos) {

            for (Asignatura asignatura : alumno.getNota()) {
                System.out.print("Introduzca las notas de " + alumno.getNombreAl() + " para la asignatura " + asignatura.getNombreAs() + ": ");
                asignatura.setNota(escaner());
            }
        }
    }

    public static void menu(Alumno[] listaAlumnos, Asignatura[] asignaturas) {
        System.out.println("1 para asignar notas. 2 para mostrarlas. 3 para mostrar al mejor alumno");
        System.out.println("4 para mostrar al alumno con mas suspensos. 5 para mostrar la asignatura mas dificil. 6 para salir del sistema.");
        boolean cerrar = false;
        do {
            try {
                switch (escaner()) {
                    case 1:

                        crearLista(listaAlumnos, asignaturas);
                        pedirNota(listaAlumnos);
                        System.out.println("Pulse 1 para repetir esta accion. 2 para mostrar las notas creadas. 3 para mostrar al mejor alumno.");
                        System.out.println("4 para mostrar al alumno con mas suspensos. 5 para mostrar la asignatura mas dificil. 6 para salir del sistema.");

                        break;

                    case 2:

                        mostrarLista(listaAlumnos);
                        System.out.println("Pulse 1 para volver a asignar las notas. 2 para repetir esta accion. 3 para mostrar al mejor alumno.");
                        System.out.println("4 para mostrar al alumno con mas suspensos. 5 para mostrar la asignatura mas dificil. 6 para salir del sistema.");
                        break;

                    case 3:
                        mejorAlumno(listaAlumnos);
                        System.out.println("Pulse 1 para volver a asignar las notas. 2 para mostrarlas. 3 para repetir esta accion.");
                        System.out.println("4 para mostrar al alumno con mas suspensos. 5 para mostrar la asignatura mas dificil. 6 para salir del sistema.");
                        break;

                    case 4:
                        alumnoConMasSuspensos(listaAlumnos);
                        System.out.println("Pulse 1 para volver a asignar las notas. 2 para mostrarlas. 3 para mostrar al mejor alumno.");
                        System.out.println("4 para volver a realizar esta accion. 5 para mostrar la asignatura mas dificil. 6 para salir del sistema.");
                        break;

                    case 5:
                        asignaturaConPeorMedia(listaAlumnos, asignaturas);
                        System.out.println("Pulse 1 para volver a asignar las notas. 2 para mostrarlas. 3 para mostrar al mejor alumno.");
                        System.out.println("4 para mostrar al peor alumno. 5 para repetir esta accion. 6 para salir del sistema.");
                        break;

                    case 6:
                        System.out.println("AHORA HE DE IRME. MI PLANETA ME NECESITA.");
                        cerrar = true;
                        break;

                    default:
                        System.out.println("Hopcion descorrecta.");

                        break;
                }

            } catch (Exception e) {

                System.out.println("QUE NO PONGAS LETRAS.");
                entrada.nextLine();

            }
        } while (!cerrar);
    }

    public static int escaner() {

        return entrada.nextInt();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu(LISTAALUMNOS, ASIGNATURAS);

    }

}
