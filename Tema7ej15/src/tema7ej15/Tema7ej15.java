/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej15;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema7ej15 {

    private static final Scanner entrada = new Scanner(System.in);

    public static final String[] YEAR = new String[12];

    public static final int[] VENTAS = new int[YEAR.length];

    public static void crearTabla(String[] year, int[] ventas) {
        year = YEAR;
        ventas = VENTAS;

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        for (int i = 0; i < ventas.length; i++) {
            year[i] = meses[i];

            ventas[i] = (int) Math.floor((Math.random() * 91) + 10);

        }

    }

    public static void mostrarTabla(String[] year, int[] ventas) {

        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Las ventas del mes " + year[i] + " son " + ventas[i] + " euros de Filipinas.\n");

        }
    }

    public static void satneV(String[] year, int[] ventas) {

        for (int i = ventas.length - 1; i >= 0; i--) {
            System.out.println("Las ventas del mes " + year[i] + " son " + ventas[i] + " euros de Filipinas.\n");
        }

    }

    public static void totalVentas(String[] year, int[] ventas) {
        int suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            suma += ventas[i];
        }
        System.out.println("La suma de ventas totales del año es: " + suma + ".\n");
    }

    public static void totalVentasPares(String[] year, int[] ventas) {
        int suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            if (i % 2 != 0) {
                System.out.println("Las ventas del mes " + year[i] + " son " + ventas[i] + " euros de Filipinas.\n");
                suma += ventas[i];

            }

        }
        System.out.println("La suma total de ventas en estos meses es de " + suma + ".\n");
    }

    public static int mejorMes(String[] year, int[] ventas) {
        int max = ventas[0];
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] > max) {
                max = ventas[i];
            }
        }
        return max;

    }

    public static void mostrarMejorMes(String[] year, int[] ventas) {
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] == mejorMes(year, ventas)) {
                System.out.println("El mes con mejores ventas es " + year[i] + " con ventas de " + ventas[i] + " euros de Filipinas.\n");

            }
        }
    }

    public static void menu() {

        System.out.println("Pulse 1 para crear una tabla de ventas, 2 para mostrarla, 3 para mostrarlas en orden inverso, 4 para obtener el total de ventas anual, 5 para ver las ventas de los meses pares, 6 para ver los meses con mas ventas y 7 para salir del programa.");
        boolean cerrarBucle = false;
        do {
            int var = escaner();
            switch (var) {
                case 1:
                    crearTabla(YEAR, VENTAS);
                    System.out.println("La tabla ha sido generada. Pulse  2 para mostrarla, 3 para mostrarlas en orden inverso, 4 para obtener el total de ventas anual, 5 para ver las ventas de los meses pares, 6 para ver los meses con mas ventas y 7 para salir del programa.");
                    System.out.println("(Si pulsa 1 puede volver a generar otra)");
                    break;

                case 2:
                    mostrarTabla(YEAR, VENTAS);
                    System.out.println("Pulse 3 para mostrarlas en orden inverso, 4 para obtener el total de ventas anual, 5 para ver las ventas de los meses pares, 6 para ver los meses con mas ventas y 7 para salir del programa.");
                    System.out.println("(Si pulsa 2 puede repetir esta accion, o puede pulsar 1 para generar otra tabla)");
                    break;
                case 3:
                    satneV(YEAR, VENTAS);
                    System.out.println("Pulse 4 para obtener el total de ventas anual, 5 para ver las ventas de los meses pares, 6 para ver los meses con mas ventas y 7 para salir del programa.");
                    System.out.println("Si pulsa 3 puede repetir esta accion. Tambien puede pulsar 1 para generar otra tabla y 2 para mostrarla)");
                    break;
                case 4:
                    totalVentas(YEAR, VENTAS);
                    System.out.println("Pulse 5 para ver las ventas de los meses pares, 6 para ver los meses con mas ventas y 7 para salir del programa.");
                    System.out.println("Si pulsa 4 puede repetir esta accion. Tambien puede pulsar 1 para generar otra tabla, 2 para mostrarla o 3 para mostrarla en orden inverso.");
                    break;
                case 5:
                    totalVentasPares(YEAR, VENTAS);
                    System.out.println("Pulse 6 para ver los meses con mas ventas y 7 para salir del programa.");
                    System.out.println("(Puede repetir esta accion pulsando 5");
                    break;

                case 6:
                    mejorMes(YEAR, VENTAS);
                    mostrarMejorMes(YEAR, VENTAS);
                    System.out.println("Pulse 7 para salir del programa.");
                    System.out.println("Puede pulsar 6 para repetir esta accion. Si pulsa 1 puede volver a generar otra tabla, si pulsa 2 puede mostrarla, 3 para mostrarla en orden inverso, 4 para mostrar el total de ventas anuales o 5 para mostrar el total de ventas de los meses pares.");
                    break;
                case 7:
                    cerrarBucle = true;
                    System.out.println("Ha salido del programa. Tambien puede pulsar 1 para generar otra tabla, 2 para mostrarla, 3 para mostrarla en orden inverso o 4 para ver el total anual de ventas.");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!cerrarBucle);
    }

    public static int escaner() {

        while (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            int nextInt = entrada.nextInt();
        }
        return entrada.nextInt();
    }

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

}
