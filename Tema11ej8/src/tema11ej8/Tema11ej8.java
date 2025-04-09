/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema11ej8 {

    private static void ordenarSedes(ArrayList<Ciudad> ciudades) {
        ArrayList<Sede> listaux = new ArrayList();
        Iterator it = ciudades.iterator();
        while (it.hasNext()) {
            Ciudad aux = (Ciudad) it.next();

            if (!aux.getSedes().isEmpty()) {
                Iterator it2 = aux.getSedes().keySet().iterator();
                while (it2.hasNext()) {
                    String clave = (String) it2.next();
                    listaux.add(aux.getSedes().get(clave));
                }

            }
        }

        listaux.sort((sede1, sede2) -> Float.compare(sede1.getIngresoAnual(), sede2.getIngresoAnual()));
        System.out.println("Sedes ordenadas de menor a mayor en funcion de sus ingresos anuales: " + listaux.toString());

    }

    public static void anadirSede(ArrayList<Ciudad> ciudades) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = ciudades.iterator();
        boolean enc = false;
        System.out.println("Introduzca el nombre de la ciudad en la que quiera anadir sede: ");
        String respuesta = entrada.next();

        while (!enc && it.hasNext()) {
            Ciudad aux = (Ciudad) it.next();
            if (respuesta.equalsIgnoreCase(aux.getNombre())) {

                aux.setSedes(aux.introducirSedes());

                enc = true;
            }
        }

    }

    public static void buscarSede(ArrayList<Ciudad> ciudades) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = ciudades.iterator();
        boolean enc = false;
        System.out.println("Introduzca el nombre de la sede que desee buscar: ");

        String respuesta = entrada.next();

        while (!enc && it.hasNext()) {
            Ciudad aux = (Ciudad) it.next();
            if (!aux.getSedes().isEmpty()) {
                Iterator it2 = aux.getSedes().keySet().iterator();

                while (!enc && it2.hasNext()) {
                    String clave = (String) it2.next();
                    Sede aux2 = aux.getSedes().get(clave);

                    if (respuesta.equalsIgnoreCase(aux2.getNombre())) {
                        enc = true;
                        System.out.println("Sede encontrada: ");
                        System.out.println(aux2.toString());

                    } else {
                        System.out.println("No se ha encontrado sede con ese nombre.");
                    }

                }
            }

        }
    }

    public static void mejoresSedes(ArrayList<Ciudad> ciudades) {
        Iterator it = ciudades.iterator();
        float mediaAnual = 0;
        ArrayList<Sede> listaSedes = new ArrayList();
        while (it.hasNext()) {
            Ciudad aux = (Ciudad) it.next();
            if (!aux.getSedes().isEmpty()) {
                Iterator it2 = aux.getSedes().keySet().iterator();

                while (it2.hasNext()) {
                    String clave = (String) it2.next();
                    Sede aux2 = aux.getSedes().get(clave);
                    listaSedes.add(aux2);
                    mediaAnual += aux2.getIngresoAnual();
                    if (aux2.getIngresoAnual() > (mediaAnual / listaSedes.size())) {

                        System.out.println(aux2.toString());

                    }
                }

            }

        }

        System.out.println("La media total anual es de " + mediaAnual / listaSedes.size() + " euros.");

    }

    /**
     * @param ciudades
     */
    public static void mostrarCiudadesySedes(ArrayList<Ciudad> ciudades) {
        Iterator it = ciudades.iterator();

        while (it.hasNext()) {
            Ciudad aux = (Ciudad) it.next();
            if (aux != null) {
                System.out.println(aux.getNombre() + ". " + aux.getSedes().toString());

            }

        }

    }

    public static void anadirCiudad(ArrayList<Ciudad> ciudades) {
        Ciudad aux = new Ciudad();
        aux.pedirNombre();
        aux.introducirSedes();
        ciudades.add(aux);

    }

    public static void menu(ArrayList<Ciudad> ciudades) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para anadir una ciudad.");
            System.out.println("2 para mostrar las ciudades y sus sedes.");
            System.out.println("3 para mostrar las sedes cuyos ingresos sean superiores a la media.");
            System.out.println("4 para buscar una sede por nombre.");
            System.out.println("5 para anadir una sede.");
            System.out.println("6 para mostrar todas las sedes de manera ordenada.");
            System.out.println("7 para salir del programa.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        anadirCiudad(ciudades);
                        break;

                    case 2:
                        mostrarCiudadesySedes(ciudades);
                        break;

                    case 3:
                        mejoresSedes(ciudades);
                        break;

                    case 4:
                        buscarSede(ciudades);
                        break;

                    case 5:
                        anadirSede(ciudades);
                        break;
                    case 6:
                        ordenarSedes(ciudades);
                        break;

                    case 7:
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

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Ciudad> ciudades = new ArrayList();
        menu(ciudades);
    }

}
