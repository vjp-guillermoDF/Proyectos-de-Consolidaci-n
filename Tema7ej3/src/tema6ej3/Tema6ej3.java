/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6ej3;

import java.util.Scanner;

/**
 *
 * @author Don Guillermo Domínguez de la Fuente I de España y Portugal
 */
public class Tema6ej3 {

    public static void crearVector(int vectorVacio[]) {
        int i;
        int numeroAleatorio;
        for (i = 0; i < vectorVacio.length; i++) {
            numeroAleatorio = (int) (Math.random() * 6) + 1;
            vectorVacio[i] = numeroAleatorio;

        }

    }

    public static void mostrarVector(int vectorLleno[]) {
        for (int i = 0; i < vectorLleno.length; i++) {
            System.out.println("El valor de " + i + " es igual a " + vectorLleno[i]);

        }
    }

    public static int longitudVector() {
        int longitud = 0;
        boolean longitudAdecuada = true;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Elija la longitud del vector: \n");

            try {
                longitud = entrada.nextInt();

                if (longitud < 1 || longitud > 10) {

                    System.out.println("La longitud debe ser entre uno y diez, pedazo de mendrugo\n");
                    longitudAdecuada = false;
                } else {
                    longitudAdecuada = true;
                }
            } catch (Exception e) {
                System.out.println("Introduce un numero. DE VERDAD QUE ME DESESPERA lo lerd@ que eres eh??\n");
                entrada.nextLine();
                longitudAdecuada = false;
            }
        } while (!longitudAdecuada);
        return longitud;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] vectorFinal = new int[longitudVector()];
        crearVector(vectorFinal);
        mostrarVector(vectorFinal);
    }

}
