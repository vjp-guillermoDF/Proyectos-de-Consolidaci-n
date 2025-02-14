/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej14;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema7ej14 {

    public static final String[] SEMANA = new String[7];

    public static final int[][] TEMPERATURAS = new int[4][SEMANA.length];

    public static void crearTabla(String[] semana, int[][] tablaVacia) {
        semana = SEMANA;
        tablaVacia = TEMPERATURAS;

        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        for (int i = 0; i < tablaVacia.length; i++) {
            for (int j = 0; j < tablaVacia[i].length; j++) {
                semana[j] = dias[j];
                System.out.println("Introduzca la temperatura del dia " + semana[j] + " de la semana " + (i + 1) + ".");

                tablaVacia[i][j] = escaner();

            }

        }
    }

    public static void mostrarTemperaturas(int[][] tablaTemperaturas, String[] semana) {

        for (int i = 0; i < tablaTemperaturas.length; i++) {
            for (int j = 0; j < tablaTemperaturas[i].length; j++) {

                System.out.println("Dia " + semana[j] + " de la semana " + (i + 1) + ": " + tablaTemperaturas[i][j] + "º.");

            }
        }

    }

    public static void temperaturaMaxima(int[][] tablaTemperaturas, String[] semana) {
        int max = tablaTemperaturas[0][0];
        for (int i = 0; i < tablaTemperaturas.length; i++) {
            for (int j = 0; j < tablaTemperaturas[i].length; j++) {
                if (tablaTemperaturas[i][j] > max) {
                    max = tablaTemperaturas[i][j];

                }

            }

        }
        for (int i = 0; i < tablaTemperaturas.length; i++) {
            for (int j = 0; j < tablaTemperaturas[i].length; j++) {
                if (tablaTemperaturas[i][j] == max) {

                    System.out.println("Temperatura maxima: Dia " + semana[j] + " de la semana " + (i + 1) + " con temperatura de: " + tablaTemperaturas[i][j] + "º.");
                }
            }

        }
    }

    public static void temperaturaMedia(int[][] tablaTemperaturas, String[] semana) {
        int suma = 0;
        int elementos = 0;

        for (int i = 0; i < tablaTemperaturas.length; i++) {
            for (int j = 0; j < tablaTemperaturas[i].length; j++) {
                suma += tablaTemperaturas[i][j];
                elementos++;

            }
        }
        System.out.println("La temperatura media es de " + suma / elementos + "º.");

    }

    public static void menu() {
        System.out.println("Pulse 1 para crear una tabla de temperaturas, 2 para mostrarla, 3 para visualizar la temperatura media del mes, 4 para mostrar los dias mas calurosos y 5 para salir del programa.");
        boolean cerrarBucle = false;
        do {
            int var = escaner();
            switch (var) {
                case 1:
                    crearTabla(SEMANA, TEMPERATURAS);
                    System.out.println("Ahora pulse 2 para mostrar las temperaturas, 3 para visualizar la temperatura media del mes, 4 para mostrar los dias mas calurosos o 5 para salir del programa.");
                    System.out.println("(Si pulsa 1 puede repetir esta accion)");
                    break;

                case 2:
                    mostrarTemperaturas(TEMPERATURAS, SEMANA);
                    System.out.println("Ahora pulse 3 para visualizar la temperatura media del mes, 4 para mostrar los dias mas calurosos o 5 para salir del programa.");
                    System.out.println("(Si pulsa 1 puede volver a rellenar la tabla de temperaturas. Si pulsa 2 puede repetir esta accion)");
                    break;

                case 3:
                    temperaturaMedia(TEMPERATURAS, SEMANA);
                    System.out.println("Ahora 4 para mostrar los dias mas calurosos o 5 para salir del programa.");
                    System.out.println("(Si pulsa 1 puede volver a rellenar la tabla de temperaturas. Si pulsa 2 puede volver a mostrar las temperaturas. O puede pulsar 3 para repetir esta accion)");
                    break;

                case 4:
                    temperaturaMaxima(TEMPERATURAS, SEMANA);
                    System.out.println("Ahora 5 para salir del programa o pulse 1 para volver a llenar la tabla de temperatiras, 2 para mostrarla y 3 para calcular la temperatura media del mes..");
                    System.out.println("(Si pulsa 4 puede repetir esta accion)");

                    break;

                case 5:
                    cerrarBucle = true;
                    System.out.println("Ha salido del programa.");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!cerrarBucle);
    }

    public static int escaner() {
        Scanner entrada = new Scanner(System.in);

        return entrada.nextInt();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();

    }
}
