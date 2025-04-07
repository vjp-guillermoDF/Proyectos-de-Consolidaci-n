/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema11ej11 {

    public static void mostrarPorNota(HashMap<Integer, Alumno> lista) {

        if (!lista.isEmpty()) {
            ArrayList<Alumno> alumnos = new ArrayList<>(lista.values());

            Collections.sort(alumnos, (a1, a2) -> Float.compare(a1.getNotaMedia(), a2.getNotaMedia()));
            for (Alumno i : alumnos) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("No hay alumnos registrados.");
        }

    }

    public static void buscarAlumnos(HashMap<Integer, Alumno> lista) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = lista.keySet().iterator();
        boolean enc = false;
        System.out.println("Introduzca el numero de expediente: ");
        int respuesta = entrada.nextInt();
        if (!lista.isEmpty()) {
            while (!enc && it.hasNext()) {
                int clave = (int) it.next();
                Alumno aux = lista.get(clave);
                if (respuesta == aux.getExpediente()) {
                    System.out.println("Alumno encontrado:");
                    System.out.println(aux.toString());
                    enc = true;
                }
                if (!enc) {
                    System.out.println("No hay alumnos con ese numero de expediente.");
                }
            }
        } else {
            System.out.println("No hay alumnos registrados.");
        }

    }

    public static void mostrarAlumnos(HashMap<Integer, Alumno> lista) {

        if (!lista.isEmpty()) {
            ArrayList<Alumno> alumnos = new ArrayList<>(lista.values());

            Collections.sort(alumnos);

            for (Alumno i : alumnos) {
                System.out.println(i);
            }

        } else {
            System.out.println("No hay alumnos registrados.");
        }

    }

    public static void anadirAlumno(HashMap<Integer, Alumno> lista) {

        Alumno aux = new Alumno();
        aux.pedirDni();
        aux.pedirExpediente();
        aux.pedirnNotaMedia();

        lista.put(aux.getExpediente(), aux);

        System.out.println("Alumno anadido con exito.");

    }

    public static void menu(HashMap<Integer, Alumno> lista) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para anadir un alumno.");
            System.out.println("2 para mostrar los alumnos ordenados de mayor a menor en funcion de su numero de expediente.");
            System.out.println("3 para buscar alumnos por su numero de expediente.");
            System.out.println("4 para mostrar a los alumnos en funcion de su nota.");
            System.out.println("5 para salir del programa.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        anadirAlumno(lista);
                        break;

                    case 2:
                        mostrarAlumnos(lista);
                        break;

                    case 3:
                        buscarAlumnos(lista);
                        break;

                    case 4:
                        mostrarPorNota(lista);
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema.");
                        cerrar = true;
                        break;

                    default:
                        System.out.println("Opcion incorrecta.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Introduzca un numero.");
                entrada.next();

            }

        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer, Alumno> lista = new HashMap();
        menu(lista);
    }

}
