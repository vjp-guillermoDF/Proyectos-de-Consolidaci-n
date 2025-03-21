/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej9 {

    public static void mediaTemperaturas(ArrayList<ArrayList<Dia>> lista) {
        int tempMax = 0;
        int tempMedia = 0;
        int dias = 0;

        for (int i = 0; i < lista.size(); i++) {

            for (int j = 0; j < lista.get(i).size(); j++) {

                dias++;
            }

        }
        tempMedia = tempMax / dias;

        System.out.println("La temperatura media del mes es " + tempMedia + ".");
    }

    public static void diasMasCalurosos(ArrayList<ArrayList<Dia>> lista, String[] días) {

        int maxTemp = Integer.MIN_VALUE;
        String maxTemps = "";
        String diaSemana = "";
        int diaMes = 1;

        for (int i = 0; i < lista.size(); i++) {

            for (int j = 0; j < lista.get(i).size(); j++) {

                diaMes++;
            }

        }

        System.out.println("Las temperaturas mas altas son: " + maxTemps + ".");

    }

    public static void mostrarTemperaturas(ArrayList<ArrayList<Dia>> lista) {
        System.out.println(lista.toString());
    }

    public static void llenarTemperaturas(ArrayList<ArrayList<Dia>> lista, String[] días) {
        Scanner entrada = new Scanner(System.in);

        int temperatura = 0;

        int i = 0;
        int j = 0;

        while (i < 4) {

            lista.add(new ArrayList<Dia>());
            i++;
        }

        while (j < lista.size()) {
            int k = 0;
            while (k < días.length) {

                System.out.println("Introduzca la temperatura para el " + días[k] + " de la semana " + (j + 1) + ".");

                lista.get(j).add(new Dia());
                k++;

            }
            j++;
        }
    }

    public static void menu(ArrayList<ArrayList<Dia>> lista, String[] días) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para llenar las temperaturas del mes.");
            System.out.println("2 para mostrarlas.");
            System.out.println("3 para visualizar la temperatura media del mes.");
            System.out.println("4 para mostrar los dias mas calurosos.");
            System.out.println("5  para salir del sistema.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        llenarTemperaturas(lista, días);
                        break;

                    case 2:
                        mostrarTemperaturas(lista);
                        break;

                    case 3:
                        mediaTemperaturas(lista);
                        break;

                    case 4:
                        diasMasCalurosos(lista, días);
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

            }

        } while (!cerrar);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ArrayList<Dia>> lista = new ArrayList<ArrayList<Dia>>();
        String[] días = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        menu(lista, días);
    }

}
