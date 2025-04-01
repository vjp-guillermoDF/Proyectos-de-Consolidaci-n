/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej14;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Don Guillermo Domínguez de la Fuente I de España y Portugal
 */
public class Tema10ej14 {

    public static void asignaturaMasDificil(ArrayList<Alumno> lista, String[] nombreAs) {
        int i = 0;
        float minMedia = 10.0f;
        String peoresMedias = "";
        while (i < nombreAs.length) { //Primero recorremos la lista de asignaturas
            int j = 0;                  //Iniciamos el índice j
            float mediaux = 0;          //Iniciamos el auxiliar en cero
            while (j < lista.size()) {              //Recorremos la lista en segundo lugar en el bucle anidado

                mediaux += lista.get(j).getAsignaturas().get(i).getNota() / lista.size();   //Por cada vez, calculamos la media sumando las notas y dividiéndolas entre el tamaño de la lista

                if (mediaux < minMedia) {       //Si la media auxiliar es menor que diez, cambiamos los valores
                    minMedia = mediaux;
                    peoresMedias = nombreAs[i] + " con media de " + minMedia + ".";     //Sumamos el valor al String de peores medias
                } else if (mediaux == minMedia) {
                    peoresMedias += nombreAs[i] + " con media de " + mediaux + ".";     //Si hay dos medias iguales, estas se sumarán al String
                }

                j++;
            }
            System.out.println("La media de la asignatura " + nombreAs[i] + " es " + mediaux);  //LÍNEA DE PRUEBAS
            i++;
        }

        System.out.println("La peor o peores asignaturas son " + peoresMedias); //En peoresMedias se almacenan todas las notas medias más bajas, sean una o varias

    }

    public static void mejorAlumno(ArrayList<Alumno> lista) {
        Iterator<Alumno> it = lista.iterator();
        Alumno mejorAlumno = lista.get(0);
        String datosMejor = "";

        while (it.hasNext()) {
            Alumno aux = it.next();

            if (aux.media() > mejorAlumno.media()) {
                mejorAlumno = aux;
            } else if (aux.media() == mejorAlumno.media()) {

                datosMejor += aux.getNombre() + " con media de " + aux.media() + ". ";
            }

        }

        System.out.println("El mejor o mejores alumnos son: " + datosMejor);

    }

    public static void mostrarAlumnosRegistradosaFaltadeNombremasCorto(ArrayList<Alumno> lista, String[] nombreAs) {
        Iterator<Alumno> it = lista.iterator();

        while (it.hasNext()) {
            Alumno aux = it.next();

            System.out.println(aux.toString());

        }

    }

    public static void registrarAlumnos(ArrayList<Alumno> lista, String[] nombreAs) {

        lista.add(new Alumno());
        for (int i = 0; i < nombreAs.length; i++) {

            lista.getLast().getAsignaturas().add(new Asignatura(nombreAs[i]));

        }

    }

    public static void menu(ArrayList<Alumno> lista, String[] nombreAs) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {
            try {

                System.out.println("1 para registrar alumno con sus notas.");
                System.out.println("2 para mostrar alumnos introducidos hasta el momento.");
                System.out.println("3 para mostrar al mejor alumno.");
                System.out.println("4 para mostrar la asignatura con menos media.");
                System.out.println("5 para salir del sistema.");

                switch (entrada.nextInt()) {
                    case 1:
                        registrarAlumnos(lista, nombreAs);
                        break;
                    case 2:
                        mostrarAlumnosRegistradosaFaltadeNombremasCorto(lista, nombreAs);
                        break;
                    case 3:
                        mejorAlumno(lista);
                        break;
                    case 4:
                        asignaturaMasDificil(lista, nombreAs);
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opcion no permitida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un numero.");
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Alumno> alumnos = new ArrayList();
        String[] nombreAs = {"Lengua", "Mates", "Fisica"};
        menu(alumnos, nombreAs);
    }

}
