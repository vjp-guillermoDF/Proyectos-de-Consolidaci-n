/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema11ej7 {

    /**
     * @param campania
     */
    public static void mayorDonacion(ArrayList<Campania> campania) {

        Iterator<Campania> it = campania.iterator();
        String mayorDonacion = "";
        Donaciones max = new Donaciones();

        while (it.hasNext()) {
            Campania aux = it.next();

            Iterator<String> it2 = aux.getDonaciones().keySet().iterator();
            while (it2.hasNext()) {
                String clave = it2.next();
                Donaciones aux2 = aux.getDonaciones().get(clave);

                if (aux2.getCantidad() > max.getCantidad()) {
                    max = aux2;
                    mayorDonacion = aux2.toString() + " Campania: " + aux.getNombreCamp() + ". ";
                } else if (aux2.getCantidad() == max.getCantidad()) {
                    mayorDonacion += aux2.toString() + " Campania: " + aux.getNombreCamp() + ".";
                }
            }
        }

        System.out.println("La mayor o mayores donaciones son: " + mayorDonacion);
    }

    public static void totalRecaudado(ArrayList<Campania> campania) {
        Iterator it = campania.iterator();
        int total = 0;
        while (it.hasNext()) {
            Campania aux = (Campania) it.next();
            Iterator it2 = aux.getDonaciones().keySet().iterator();

            while (it2.hasNext()) {
                String clave = (String) it2.next();
                Donaciones aux2 = aux.getDonaciones().get(clave);
                if (aux2 != null) {
                    total += aux2.getCantidad();
                }

            }

        }
        System.out.println("La cantidad total donada es de " + total + " euros.");
    }

    public static void buscarCampania(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = campania.iterator();
        boolean enc = false;
        System.out.println("Introduzca el nombre de la campania");
        String nombre = entrada.next();

        while (!enc && it.hasNext()) {
            Campania aux = (Campania) it.next();

            if (nombre.equalsIgnoreCase(aux.getNombreCamp())) {
                System.out.println(aux.toString());
                enc = true;
            } else if (!enc && !it.hasNext()) {
                System.out.println("No existe la campania con ese nombre.");
            }

        }

    }

    public static void mostrarTodo(ArrayList<Campania> campania) {
        Iterator it = campania.iterator();
        while (it.hasNext()) {
            Campania aux = (Campania) it.next();

            System.out.println("Campania " + aux.getNombreCamp() + aux.getDonaciones().toString());

        }

    }

    public static void hacerDonacion(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = campania.iterator();

        System.out.println("Introduzca el nombre de la campaña en la que desea donar.");
        String nombre = entrada.next();

        while (it.hasNext()) {
            Campania aux = (Campania) it.next();
            if (nombre.equals(aux.getNombreCamp())) {
                aux.setDonaciones(aux.insertarDonaciones());
            }
        }

    }

    public static void anadirCampania(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la campaña.");
        String nombre = entrada.next();
        Campania aux = new Campania();
        aux.setNombreCamp(nombre);
        campania.add(aux);
        System.out.println("Campania " + campania.getLast().getNombreCamp() + " registrada con exito.");

    }

    public static void menu(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para anadir campania.");
            System.out.println("2 para realizar donacion.");
            System.out.println("3 para mostrar campanias y donaciones.");
            System.out.println("4 para mostrar campaña por nombre.");
            System.out.println("5 para mostrar el total recaudado.");
            System.out.println("6 para mostrar la mayor donacion.");
            System.out.println("7 para salir del sistema.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        anadirCampania(campania);
                        break;

                    case 2:
                        hacerDonacion(campania);
                        break;

                    case 3:
                        mostrarTodo(campania);
                        break;

                    case 4:
                        buscarCampania(campania);
                        break;

                    case 5:
                        totalRecaudado(campania);
                        break;

                    case 6:
                        mayorDonacion(campania);
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
        ArrayList<Campania> campania = new ArrayList();
        menu(campania);

    }

}
