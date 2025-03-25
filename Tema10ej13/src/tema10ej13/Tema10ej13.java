/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej13;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema10ej13 {

    public static void mejorMes(ArrayList<Venta> lista, String[] meses) {
        String mejoresMeses = lista.get(0).getNombre();
        float maxVentas = lista.get(0).getVentas();

        for (int i = 1; i < lista.size(); i++) {
            Venta aux = lista.get(i);

            if (aux.getVentas() > maxVentas) {
                maxVentas = aux.getVentas();
                mejoresMeses = aux.getNombre();  // Se reemplaza en lugar de concatenar
            } else if (aux.getVentas() == maxVentas) {
                mejoresMeses += ", " + aux.getNombre();  // Se agregan más meses si hay empate
            }
        }

        System.out.println("El mejor o mejores meses son: " + mejoresMeses + " con ventas de " + maxVentas + " euros.");
    }

    public static void mastrarVantas(ArrayList<Venta> lista) {
        Iterator<Venta> it = lista.iterator();
        int ventasTotales = 0;
        while (it.hasNext()) {
            Venta aux = it.next();
            if (aux.getNombre().contains("A") || aux.getNombre().contains("a")) {
                ventasTotales += aux.getVentas();
            }

        }
        System.out.println("Las ventas totales de los meses con la letra 'A' son " + ventasTotales + ".");

    }

    public static void ventasTotales(ArrayList<Venta> lista) {
        Iterator<Venta> it = lista.iterator();
        int ventasTotales = 0;
        while (it.hasNext()) {
            Venta aux = it.next();
            ventasTotales += aux.getVentas();

        }
        System.out.println("Las ventas totales del año son " + ventasTotales + ".");

    }

    public static void mostrarVentas(ArrayList<Venta> lista) {
        Iterator<Venta> it = lista.iterator();

        while (it.hasNext()) {
            Venta aux = it.next();
            System.out.println(aux.toString());

        }

    }

    public static void introducirVentas(ArrayList<Venta> lista, String[] meses) {
        int i = 0;
        while (i < meses.length) {
            lista.add(new Venta(meses[i]));
            i++;
        }

    }

    public static void menu(ArrayList<Venta> lista, String[] meses) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {
            System.out.println("1 para introducir las ventas.");
            System.out.println("2 para mostrarlas.");
            System.out.println("3 para mostrar la suma total de coches.");
            System.out.println("4 para mostrar la venta de meses que contienen la letra A.");
            System.out.println("5 para mostrar el mes con mas ventas.");
            System.out.println("6 para salir del programa.");

            try {
                switch (entrada.nextInt()) {
                    case 1:
                        introducirVentas(lista, meses);
                        break;
                    case 2:
                        mostrarVentas(lista);
                        break;
                    case 3:
                        ventasTotales(lista);
                        break;
                    case 4:
                        mastrarVantas(lista);
                        break;
                    case 5:
                        mejorMes(lista, meses);
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        cerrar = true;
                        break;
                    default:
                        System.out.println("Opcion no permitida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe introducirse un numero.");
                entrada.next();
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        ArrayList<Venta> lista = new ArrayList();

        menu(lista, meses);

    }

}
