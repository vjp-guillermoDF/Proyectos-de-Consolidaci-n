/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6ej2;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema6ej2 {

    public static void crearVector(int[] vectorVacio) {
        Scanner entrada = new Scanner(System.in);
        int i;

        for (i = 0; i < vectorVacio.length; i++) {
            System.out.println("Asigne un valor a " + i);
            vectorVacio[i] = entrada.nextInt();

        }
    }

    public static void mostrarVector(int[] vectorLleno) {

        for (int i = 0; i < vectorLleno.length; i++) {
            System.out.println("\nEl valor de " + i + " es " + vectorLleno[i]);
        }
    }

    public static void intercambiarVector(int[] vectorIntercambiar) {
        int aux = 0;
        aux = vectorIntercambiar[2];
        vectorIntercambiar[2] = vectorIntercambiar[4];
        vectorIntercambiar[4] = aux;
        System.out.println("\nEl valor asignado a 2 ahora es " + vectorIntercambiar[2] + " y el valor asignado a 4 es " + vectorIntercambiar[4]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int vectoriaSecret[] = new int[5];
        crearVector(vectoriaSecret);
        mostrarVector(vectoriaSecret);
        intercambiarVector(vectoriaSecret);
    }

}
