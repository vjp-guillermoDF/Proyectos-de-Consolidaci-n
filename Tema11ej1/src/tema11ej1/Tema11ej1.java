/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema11ej1 {

    public static void diasMasCalurosos(Map<Integer, Dia> mapa) {
        Iterator it = mapa.keySet().iterator();
        String temperaturas = "";
        Dia diaux;
        if (!mapa.isEmpty()) {
            Dia maxTemp = mapa.get(0);
            while (it.hasNext()) {
                int clave = (int) it.next();
                diaux = (Dia) mapa.get(clave);
                if (diaux.getTemperatura() > maxTemp.getTemperatura()) {
                    maxTemp = diaux;
                    temperaturas = "Dia " + (clave + 1) + ") " + maxTemp.toString() + " ";
                } else if (diaux.getTemperatura() == maxTemp.getTemperatura()) {
                    temperaturas += "Dia " + (clave + 1) + ") " + diaux.toString() + " ";
                }
            }
            System.out.println("Días más calurosos: " + temperaturas);
        } else {
            System.out.println("No hay temperaturas registradas.");
        }
    }

    public static void mediaTemperaturas(Map<Integer, Dia> mapa) {
        Iterator it = mapa.keySet().iterator();
        int tempMax = 0;
        int tempMedia = 0;

        Dia diaux;

        while (it.hasNext()) {
            int clave = (int) it.next();
            diaux = (Dia) mapa.get(clave);
            tempMax += diaux.getTemperatura();

        }

        tempMedia = tempMax / mapa.size();

        System.out.println("La temperatura media del mes es " + tempMedia + "º.");
    }

    public static void mostrarTemperaturas(Map<Integer, Dia> mapa) {
        Iterator it = mapa.keySet().iterator();
        int contador = 0;
        Dia diaux;
        while (it.hasNext()) {
            int clave = (int) it.next();
            diaux = (Dia) mapa.get(clave);
            contador++;

            System.out.println("Dia " + contador + ") " + diaux.toString());
        }

    }

    public static void llenarTemperaturas(Map<Integer, Dia> mapa, String[] días) {
        int i = 0;
        Random rand = new Random();
        int inicio = rand.nextInt(días.length);
        do {
            Dia diaux = new Dia(días[(inicio + i) % días.length]);
            mapa.put(i, diaux);

            i++;
        } while (i < 31);

    }

    public static void menu(Map<Integer, Dia> mapa, String[] días) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para llenar las temperaturas del mes.");
            System.out.println("2 para mostrarlas.");
            System.out.println("3 para visualizar la temperatura media del mes.");
            System.out.println("4 para mostrar los dias mas calurosos.");
            System.out.println("5 para salir del sistema.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        llenarTemperaturas(mapa, días);
                        break;

                    case 2:
                        mostrarTemperaturas(mapa);
                        break;

                    case 3:
                        mediaTemperaturas(mapa);
                        break;

                    case 4:
                        diasMasCalurosos(mapa);
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
        Map<Integer, Dia> mapa = new HashMap<>();
        String[] días = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        menu(mapa, días);
    }

}
