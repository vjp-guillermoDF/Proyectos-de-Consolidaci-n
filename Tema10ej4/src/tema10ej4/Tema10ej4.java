/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema10ej4 {

    public static void mostrarLista(ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("\nLa lista esta vacia.");

        } else {

            System.out.println(lista.toString());
        }

        System.out.println(sustituirRepetidos(lista));

    }

    public static String sustituirRepetidos(ArrayList<Integer> lista) {
        int i = 0;

        while (i < lista.size()) {
            int j = i + 1;

            while (j < lista.size()) {
                if (lista.get(i).equals(lista.get(j)) && lista.get(i) != 0) {
                    int duplicado = lista.get(i);
                    int k = 0;
                    while (k < lista.size()) {
                        if (lista.get(k) == duplicado) {
                            lista.set(k, 0);
                        }
                        k++;
                    }

                }

                j++;

            }

            i++;
        }

        return lista.toString();

    }

    public static void llenarLista(ArrayList<Integer> lista) {
        Scanner entrada = new Scanner(System.in);

        int numero = 0;
        int i = 0;

        boolean cerrar = false;
        System.out.println("Introduzca un número mayor que cero para añadirlo a la lista.");
        System.out.println("Introduzca un número negativo para salir de la lista.\n");
        while (!cerrar) {

            numero = entrada.nextInt();
            if (numero > 0) {
                lista.add(i, numero);
                System.out.println("\nNúmero " + numero + " añadido en la posicion " + i + " de la lista.\n");
                i++;
            } else if (numero == 0) {
                System.out.println("El numero debe ser mayor que cero.");

            } else {
                cerrar = true;
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
