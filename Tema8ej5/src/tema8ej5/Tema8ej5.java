/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej5;

import java.util.Arrays;

/**
 *
 * @author Don Guillermo Domínguez de la Fuente I de España y Portugal
 */
public class Tema8ej5 {

    public static final int[] ARRAYENTEROS = new int[10];

    public static void ordenarArray(int[] arrayEnteros) {

        Arrays.sort(arrayEnteros);

    }

    public static void mostrarArray(int[] arrayEnteros) {

        System.out.println(Arrays.toString(arrayEnteros));

    }

    public static void llenarArray(int[] arrayEnteros) {

        for (int i = 0; i < arrayEnteros.length; i++) {

            arrayEnteros[i] = 9 - i;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        llenarArray(ARRAYENTEROS);
        mostrarArray(ARRAYENTEROS);
        ordenarArray(ARRAYENTEROS);
        mostrarArray(ARRAYENTEROS);

    }

}
