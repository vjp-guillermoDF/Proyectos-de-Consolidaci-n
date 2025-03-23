/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej9 {

    public static void mediaTemperaturas(ArrayList<Dia> lista) {
        int tempMax = 0;
        int tempMedia = 0;

        for (int i = 0; i < lista.size(); i++) {

            tempMax += lista.get(i).getTemperatura();

        }
        tempMedia = tempMax / lista.size();

        System.out.println("La temperatura media del mes es " + tempMedia + ".");
    }

    public static void diasMasCalurosos(ArrayList<Dia> lista, String[] días) {
        int maxTemp = Integer.MIN_VALUE;
        String maxTemps = "";
        String diaSemana = "";

        for (int i = 0; i < lista.size(); i++) {

            int currentTemp = lista.get(i).getTemperatura();

            if (currentTemp > maxTemp) {
                maxTemp = currentTemp;
                maxTemps = maxTemp + " del " + lista.get(i).getNombreDia() + " dia " + (i + 1) + ". ";

            } else if (currentTemp == maxTemp) {
                maxTemps += maxTemp + " del " + lista.get(i).getNombreDia() + " dia " + (i + 1) + ". ";
            }

        }

        System.out.println("Las temperaturas mas altas son: " + maxTemps + ".");

    }

    public static void mostrarTemperaturas(ArrayList<Dia> lista, String[] días) {
        int indice = 0;
        for (Dia i : lista) {

            System.out.println("Dia " + (indice + 1) + " " + i.getNombreDia() + " y temperatura " + i.getTemperatura() + ".");
            indice++;
        }

    }

    public static void llenarTemperaturas(ArrayList<Dia> lista, String[] días) {
        Scanner entrada = new Scanner(System.in);
        Random rand = new Random();
        int indiceInicio = rand.nextInt(días.length);

        for (int i = 0; i < 31; i++) {
            int indiceDia = (indiceInicio + i) % días.length;
            String diaSemana = días[indiceDia];
            System.out.println("Día " + diaSemana + " " + (i + 1) + " del mes:");
            lista.add(new Dia(diaSemana));

        }

    }

    public static void menu(ArrayList<Dia> lista, String[] días) {
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
                        mostrarTemperaturas(lista, días);

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
        ArrayList<Dia> lista = new ArrayList();
        String[] días = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        menu(lista, días);
    }

}
