/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej9;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema8ej9 {

    public static Scanner entrada = new Scanner(System.in);

    public static final Alumno[] LISTAALUMNOS = new Alumno[3];

    public static final Asignatura ASIGNATURAS[] = new Asignatura[4];

    public static final Asignatura ASIGNATURA = new Asignatura();

    public static void mostrarLista(Alumno[] listaAlumnos, Asignatura[] asignaturas, Asignatura asignatura) {

        for (int i = 0; i < listaAlumnos.length; i++) {

            System.out.println("El alumno " + listaAlumnos[i].getNombreAl() + " tiene una nota de " + asignatura.getNota() + " en la asginatura " + asignatura.getNombreAs());

        }

    }

    public static void crearLista(Alumno[] listaAlumnos, Asignatura[] asignaturas, Asignatura asignatura) {

        String[] nombresAl = {"Elena Nito", "Consuelo O'Sinnell", "Segundo Toro de la Tarde"};
        String[] nombresAs = {"Lengua", "Mates", "Historia", "Fisica"};

        for (int i = 0; i < listaAlumnos.length; i++) {

            listaAlumnos[i] = new Alumno(nombresAl[i], new Asignatura[asignaturas.length]);

        }

        for (int i = 0; i < asignaturas.length; i++) {

            asignaturas[i] = new Asignatura(nombresAs[i], pedirNota(asignatura));

        }
    }

    public static int pedirNota(Asignatura asignaturas) {

        System.out.println("Por favor, introduzca la nota de la asignatura " + asignaturas.getNombreAs());

        return entrada.nextInt();

    }

    public static void menu(Alumno[] listaAlumnos, Asignatura[] asignaturas, Asignatura asignatura) {
        System.out.println("1 para asignar notas. 2 para mostrarlas.");
        boolean cerrar = false;
        do {
            try {
                switch (escaner()) {
                    case 1:

                        crearLista(listaAlumnos, asignaturas, asignatura);

                        break;

                    case 2:

                        mostrarLista(listaAlumnos, asignaturas, asignatura);
                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:

                        break;

                    case 6:
                        cerrar = true;
                        break;

                    default:
                        System.out.println("MARCIONA xdd");

                        break;
                }

            } catch (Exception e) {

                System.out.println("LOLgay");

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
        menu(LISTAALUMNOS, ASIGNATURAS, ASIGNATURA);
    }

}
