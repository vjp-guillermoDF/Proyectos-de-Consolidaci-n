/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej6 {

    public static void mejorMes(String[] meses, ArrayList<Integer> lista) {
        int i = 0;
        int maxVentas = 0;
        String mejorMes = "";

        while (i < lista.size()) {
            if (lista.get(i) > maxVentas) {
                maxVentas = lista.get(i);
                mejorMes = meses[i];
            }
            i++;
        }
        System.out.println("El mes con mas ventas es " + mejorMes + " con ventas de " + maxVentas + " euros.");

    }

    public static void ventasDeMesesConA(String[] meses, ArrayList<Integer> lista) {

        int ventasTotales = 0;
        int i = 0;

        while (i < lista.size()) {

            if (meses[i].contains("a") || meses[i].contains("A")) {
                ventasTotales += lista.get(i);

            }
            i++;
        }

        System.out.println("Las ventas totales de los meses con la letra a ascienden a " + ventasTotales + " euros.");

    }

    public static void ventasTotales(ArrayList<Integer> lista) {

        int ventasTotales = 0;
        int i = 0;

        while (i < lista.size()) {

            ventasTotales += lista.get(i);
            i++;
        }

        System.out.println("Las ventas totales del año ascienden a " + ventasTotales + " euros.");

    }

    public static void satneVrartsom(String[] meses, ArrayList<Integer> lista) {

        for (int i = lista.size() - 1; i >= 0; i--) {

            System.out.println("Mes: " + meses[i] + " Ventas: " + lista.get(i) + " euros.");

        }

    }

    public static void mostrarVentas(ArrayList<Integer> lista, String[] meses) {

        for (int i = 0; i < lista.size(); i++) {

            System.out.println("Mes: " + meses[i] + " Ventas: " + lista.get(i) + " euros.");

        }

    }

    public static void rellenarVentas(ArrayList<Integer> lista, String[] meses) {
        Scanner entrada = new Scanner(System.in);
        int ventas = 0;
        int i = 0;

        while (i < meses.length) {
            System.out.println("Introduzca las ventas para el mes de " + meses[i] + ":");
            try {
                ventas = entrada.nextInt();
                if (ventas >= 0) {

                    lista.add(ventas);
                    i++;
                } else {
                    System.out.println("El numero debe ser mayor que cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un valor numerico.");
                entrada.next();
            }
        }
    }

    public static void menu(ArrayList<Integer> lista, String[] meses) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para llenar las ventas del año.");
            System.out.println("2 para mostrar las ventas.");
            System.out.println(".satnev sal rartsom arap 3");
            System.out.println("4 para mostrar las ventas totales del año.");
            System.out.println("5 para mostrar las ventas de los meses con la letra 'a' (Sí, has leído bien)");
            System.out.println("6 para mostrar el mes con más ventas.");
            System.out.println("7 para salir del sistema.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        rellenarVentas(lista, meses);
                        break;

                    case 2:
                        mostrarVentas(lista, meses);
                        break;

                    case 3:
                        satneVrartsom(meses, lista);
                        break;

                    case 4:
                        ventasTotales(lista);
                        break;

                    case 5:
                        ventasDeMesesConA(meses, lista);
                        break;

                    case 6:
                        mejorMes(meses, lista);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> lista = new ArrayList();
        String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        menu(lista, meses);
    }

}
