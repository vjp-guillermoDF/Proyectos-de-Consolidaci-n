/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema10ej2 {

    public static void sumaNumeros(ArrayList<Integer> lista) {

        int suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i);
        }

        System.out.println("La suma total de los numeros es " + suma + ".");

    }

    public static void numeroMenor(ArrayList<Integer> lista) {

        int numMenor = Integer.MAX_VALUE;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) < numMenor) {
                numMenor = lista.get(i);
            }

        }

        System.out.println("El numero mas bajo de la lista es " + numMenor + " en la posicion " + lista.indexOf(numMenor) + ".\n");

    }

    public static void numeroMayor(ArrayList<Integer> lista) {

        int numMayor = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) > numMayor) {
                numMayor = lista.get(i);
            }

        }

        System.out.println("\nEl numero mas alto de la lista es " + numMayor + " en la posicion " + lista.indexOf(numMayor) + ".\n");

    }

    public static void mostrarLista(ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("\nLa lista esta vacia.");
        } else {

            for (int i = 0; i < lista.size(); i++) {

                System.out.println("\n" + i + ")" + lista.get(i));
             
            }

        }
    }

    public static void llenarLista(ArrayList<Integer> lista) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int i = 0;

        boolean cerrar = false;
        System.out.println("Introduzca un número para añadirlo a la lista.");
        System.out.println("Introduzca un número negativo para salir de la lista.\n");
        while (!cerrar) {

            numero = entrada.nextInt();
            if (numero >= 0) {
                lista.add(i, numero);
                System.out.println("\nNúmero " + numero + " añadido en la posicion " + i + " de la lista.\n");
                i++;
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
        numeroMayor(lista);
        numeroMenor(lista);
        sumaNumeros(lista);
    }

}
