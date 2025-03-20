/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej5 {

    public static void mayorParyMenorImpar(ArrayList<Integer> lista) {
        int i = 0;
        int mayorPar = 0;
        int menorimPar = Integer.MAX_VALUE;

        while (i < lista.size()) {
            if (lista.get(i) % 2 == 0 && lista.get(i) > mayorPar) {
                mayorPar = lista.get(i);

            }

            if (lista.get(i) % 2 != 0 && lista.get(i) < menorimPar) {
                menorimPar = lista.get(i);

            }

            i++;
        }

        System.out.println("El mayor número par es " + mayorPar + ".");
        System.out.println("El menor número impar es " + menorimPar + ".");

        lista.set(lista.indexOf(mayorPar), menorimPar);
        lista.set(lista.indexOf(menorimPar), mayorPar);

        System.out.println(lista.toString());

    }

    public static void mostrarLista(ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("\nLa lista esta vacia.");

        } else {

            System.out.println(lista.toString());
        }

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
        mayorParyMenorImpar(lista);
    }

}
