/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej13.pkg14;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema8ej1314 {

    public static final Alumno[] ALUMNOS = new Alumno[5];
    public static Scanner entrada = new Scanner(System.in);

    public static void buscarAlumno(Alumno[] alumnos) {
        String nombre = pedirNombre();

        for (Alumno i : alumnos) {
            if (i != null) {

                if (nombre.equalsIgnoreCase(i.getNombre())) {
                    System.out.println("El alumno " + i.getNombre() + " existe en el universo.");
                }
            }

        }
    }

    public static void suspensos(Alumno[] alumnos) {

        int contador = 0;

        for (Alumno i : alumnos) {
            if (i != null) {

                if (i.getNotaMedia() < 5) {
                    contador++;
                    System.out.println(i.toString() + " y por ende, se ha convertido en uno con la deshonra.");
                    System.out.println("El numero de suspensos aumenta a " + contador + ".");

                }

            }

        }
    }

    public static void notaMedia(Alumno[] alumnos) {

        int notaDada = pedirNotaCualquiera();

        for (Alumno i : alumnos) {
            if (i != null) {
                if (i.getNotaMedia() > notaDada) {
                    System.out.println(i.toString() + " por encima de " + notaDada + ".");
                } else {
                    System.out.println(i.toString() + " por debajo de " + notaDada + " y por ende, es una DESHONRA para su linaje. Sera desterrado a Francia. Donde coexistira con los franceses.");
                }

            }

        }
    }

    public static void mostrarAlumnos(Alumno[] alumnos) {

        for (Alumno i : alumnos) {
            if (i != null) {
                System.out.println(i.toString());

            }

        }

    }

    public static void rellenarPosicion(Alumno[] alumnos) {

        boolean salir = false;
        while (!salir) {
            System.out.println("Elija una posicion para registrar un alumno o pulse 0 para salir del registro: ");
            int posicion = entrada.nextInt();

            if (posicion == 0) {
                System.out.println("Finalizado el registro de alumnos.");
                salir = true;
            } else if (posicion < 0 || posicion >= alumnos.length) {
                System.out.println("Posición fuera de rango. TOLAI.");
            } else if (alumnos[posicion] == null) {
                alumnos[posicion] = new Alumno(pedirNombre(), pedirEdad(), pedirNotaMedia());
                System.out.println("Alumno registrado en la posicion " + posicion + ".");
            } else {
                System.out.println("Esa posicion ya está llena. MAMELUCO.");
            }
        }
    }

    public static int escaner(int numero) {

        numero = entrada.nextInt();
        return numero;

    }

    public static String pedirNombre() {
        System.out.println("Introduzca el nombre del alumno: ");
        return entrada.next();
    }

    public static int pedirEdad() {
        System.out.println("Introduzca la edad del alumno: ");
        return entrada.nextInt();
    }

    public static float pedirNotaMedia() {
        System.out.println("Introduzca la nota media del alumno: ");
        return entrada.nextFloat();
    }

    public static int pedirNotaCualquiera() {
        System.out.println("Introduzca una nota: ");
        return entrada.nextInt();

    }

    public static void menu(Alumno[] alumnos) {
        boolean cerrar = false;
        do {
            System.out.println("Pulse 1 para rellenar una tabla de Alumnos. 2 para mostrarla. 3 para mostrar alumnos por encima de una nota dada. 4 para mostrar la cantidad de suspensos. 5 para buscar alumnos. 6 para salir.");
            try {
                switch (entrada.nextInt()) {
                    case 1:
                        rellenarPosicion(alumnos);
                        cerrar = false;
                        break;

                    case 2:
                        mostrarAlumnos(alumnos);
                        cerrar = false;
                        break;

                    case 3:
                        notaMedia(alumnos);
                        cerrar = false;
                        break;

                    case 4:
                        suspensos(alumnos);
                        cerrar = false;

                        break;

                    case 5:
                        buscarAlumno(alumnos);
                        cerrar = false;

                        break;

                    case 6:
                        cerrar = true;
                        System.out.println("El sistema es salido de.");
                        break;
                    default:
                        cerrar = false;
                        System.out.println("HOPCION DESCORRECTA");

                }

            } catch (Exception e) {
                cerrar = false;
                System.out.println("QUE NO PONGAS LETRAS" + e);
                entrada.nextLine();
            }
        } while (!cerrar);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        menu(ALUMNOS);
    }
}
