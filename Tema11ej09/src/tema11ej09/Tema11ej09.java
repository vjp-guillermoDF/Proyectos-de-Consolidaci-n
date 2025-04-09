/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej09;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author alumno
 */
public class Tema11ej09 {

    public static void repetirSorteo(Map<LocalDate, Sorteo> sorteos) {
        boolean enc = false;
        Iterator it = sorteos.keySet().iterator();
        Sorteo aux = new Sorteo();
        aux.introducirGanadores();

        sorteos.replace(aux.getSorteo(), aux);

    }

    public static void nuevoSorteo(Map<LocalDate, Sorteo> sorteos) {

        Sorteo aux = new Sorteo();
        aux.introducirGanadores();

        sorteos.put(aux.getSorteo(), aux);

        System.out.println("Registrado con exito.");
        System.out.println(aux.toString());

    }

    /**
     * @param sorteos
     */
    public static void menu(Map<LocalDate, Sorteo> sorteos) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para realizar sorteo.");
            System.out.println("2 para repetir sorteo.");
            System.out.println("3 para mostrar los sorteos del mes actual.");
            System.out.println("4 para mostrar los sorteos en funcion de una fecha.");
            System.out.println("5 para realizar un sorteo en una fecha elegida.");
            System.out.println("6 para salir.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        nuevoSorteo(sorteos);
                        break;

                    case 2:
                        repetirSorteo(sorteos);
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:

                        break;

                    case 6:
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
        Map<LocalDate, Sorteo> sorteos = new TreeMap();
        menu(sorteos);

    }

}
