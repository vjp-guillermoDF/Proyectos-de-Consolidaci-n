/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej8 {

    public static Scanner entrada = new Scanner(System.in);

    public static void mostrarLista(ArrayList<Alumno> lista) {
        int indice = 0;

        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (Alumno i : lista) {
                System.out.println(indice + ") Nombre del alumno: " + i.getNombre() + ". Curso: " + i.getCurso() + ".");
                indice++;
            }
        }

    }

    public static void llenarLista(ArrayList<Alumno> lista) {
        int indice = 0;
        boolean cerrar = false;
        do {
            System.out.println("¿Desea introducir alumnos?");

            String respuesta = entrada.next();

            if (respuesta.equalsIgnoreCase("Si")) {

                do {

                    lista.add(new Alumno(pedirNombre(), pedirCurso()));

                    System.out.println("Alumno " + lista.get(indice).getNombre() + " en curso " + lista.get(indice).getCurso() + " añadido a la posicion " + indice + " de la lista.");
                    indice++;

                    System.out.println("¿Desea continuar?");

                    respuesta = entrada.next();

                    if (respuesta.equalsIgnoreCase("No")) {
                        cerrar = true;
                    } else {
                        System.out.println("La respuesta debe ser si o no.");

                    }

                } while (respuesta.equalsIgnoreCase("Si"));

            } else if (respuesta.equalsIgnoreCase("No")) {
                cerrar = true;

            } else {
                System.out.println("La respuesta debe ser si o no.");

            }
        } while (!cerrar);
        System.out.println("A continuacion, se mostrara la lista.");
    }

    public static int pedirCurso() {
        int curso = 0;
        boolean cerrar = false;
        do {
            try {
                System.out.println("Introduzca el curso del alumno: ");
                curso = entrada.nextInt();
                cerrar = true;

            } catch (InputMismatchException e) {
                System.out.println("Error. Se debe introducir un numero.");
                entrada.next();
            }

        } while (!cerrar);
        return curso;
    }

    public static String pedirNombre() {

        System.out.println("Introduzca el nombre del alumno: ");
        String nombre = entrada.next();
        return nombre;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Alumno> lista = new ArrayList();
        llenarLista(lista);
        mostrarLista(lista);
    }

}
