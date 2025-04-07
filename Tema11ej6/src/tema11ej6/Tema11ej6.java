/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema11ej6 {

    /**
     * @param campania
     * @param args the command line arguments
     */
    public static void ordenarDonaciones(ArrayList<Campania> campania) {
        Iterator it = campania.iterator();
        ArrayList<Donaciones> listaux = new ArrayList();
        while (it.hasNext()) {
            Campania aux = (Campania) it.next();
            Iterator it2 = aux.getDonaciones().keySet().iterator();

            while (it2.hasNext()) {
                String clave = (String) it2.next();
                Donaciones aux2 = aux.getDonaciones().get(clave);
                if (aux2 != null) {
                    listaux.add(aux2);
                }

            }

        }

        listaux.sort((donacion1, donacion2) -> Integer.compare(donacion1.getCantidad(), donacion2.getCantidad()));
        

        System.out.println("De menor a mayor: " + listaux.toString());
    }

    public static void totalDonado(ArrayList<Campania> campania) {
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

    public static void numeroDonaciones(ArrayList<Campania> campania) {
        Iterator it = campania.iterator();
        int contador = 0;
        while (it.hasNext()) {
            Campania aux = (Campania) it.next();
            Iterator it2 = aux.getDonaciones().keySet().iterator();

            while (it2.hasNext()) {
                if (it2.next() != null) {
                    contador++;
                }

            }
        }
        System.out.println("La cantidad de donaciones realizadas es de " + contador + ".");

    }

    public static void buscarDonaciones(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        Iterator it = campania.iterator();
        boolean enc = false;

        System.out.println("Introduzca el nombre del donante.");
        String nombre = entrada.next();

        while (!enc && it.hasNext()) {
            Campania aux = (Campania) it.next();
            Iterator it2 = aux.getDonaciones().keySet().iterator();

            while (it2.hasNext()) {

                String clave = (String) it2.next();
                Donaciones aux2 = aux.getDonaciones().get(clave);
                if (nombre.equalsIgnoreCase(aux2.getNombre())) {
                    System.out.println(aux2.toString() + " Campania: " + aux.getNombreCamp() + ".");
                    enc = true;

                }else if(!enc && !it2.hasNext()){
                    System.out.println("No se encuentra a ese donante.");
                }

            }

        }

    }

    public static void mostrarDonaciones(ArrayList<Campania> campania) {
        Iterator it = campania.iterator();
        while (it.hasNext()) {
            Campania aux = (Campania) it.next();

            System.out.println(aux.getDonaciones().toString());

        }

    }

    public static void hacerDonacion(ArrayList<Campania> campania) {
        Scanner entrada = new Scanner(System.in);
        campania.getLast().insertarDonaciones();

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

            System.out.println("1 para hacer una donacion.");
            System.out.println("2 para mostrar las donaciones realizadas.");
            System.out.println("3 para buscar una donacion.");
            System.out.println("4 para mostrar el numero de donaciones.");
            System.out.println("5 para mostrar el total recaudado.");
            System.out.println("6 para ordenar las donaciones en funcion del importe.");
            System.out.println("7 para salir del sistema.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        hacerDonacion(campania);
                        break;

                    case 2:
                        mostrarDonaciones(campania);
                        break;

                    case 3:
                        buscarDonaciones(campania);
                        break;

                    case 4:
                        numeroDonaciones(campania);
                        break;

                    case 5:
                        totalDonado(campania);
                        break;

                    case 6:
                        ordenarDonaciones(campania);
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
        anadirCampania(campania);
        menu(campania);

    }

}
