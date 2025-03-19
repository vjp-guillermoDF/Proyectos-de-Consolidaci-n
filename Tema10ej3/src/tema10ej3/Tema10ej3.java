/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema10ej3 {

    public static String intercambiar2y4(ArrayList<Integer> lista) {

        int[] num2y4 = new int[2];

        num2y4[0] = lista.get(1);
        num2y4[1] = lista.get(3);

        lista.set(1, num2y4[1]);
        lista.set(3, num2y4[0]);

        return "La posicion " + lista.indexOf(lista.get(1)) + " y la posicion " + lista.indexOf(lista.get(3)) + " son " + lista.get(1) + " y " + lista.get(3) + " respectivamente.";

    }

    public static void mostrarLista(ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("\nLa lista esta vacia.");
        } else if (lista.size() >= 4) {

            for (int i = 0; i < lista.size(); i++) {

                System.out.println("\n" + i + ")" + lista.get(i));

            }
            System.out.println(intercambiar2y4(lista));
        } else {

            for (int i = 0; i < lista.size(); i++) {

                System.out.println("\n" + i + ")" + lista.get(i));
            }
        }

    }

    public static void llenarLista(ArrayList<Integer> lista) {
        Scanner entrada = new Scanner(System.in);

        boolean cerrar = false;
        String respuesta = "";

        int i = 0;

        System.out.println("Creando lista de nombres.\n");

        while (!cerrar) {

            System.out.println("¿Desea introducir un numero?\n");
            respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Introduzca numero: \n");
                try {
                    lista.add(i, entrada.nextInt());
                    System.out.println("\nNumero " + lista.get(i) + " añadido.\n");
                    i++;

                } catch (InputMismatchException e) {
                    System.out.println("Debe introducir un numero.");
                }
            } else if (respuesta.equalsIgnoreCase("No")) {
                cerrar = true;
            } if (!respuesta.equalsIgnoreCase("No") || !respuesta.equalsIgnoreCase("Si")) {
                System.out.println("\nOpcion no permitida. Por favor, escriba si o no.\n");
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> lista = new ArrayList();
        llenarLista(lista);
        mostrarLista(lista);

    }

}
