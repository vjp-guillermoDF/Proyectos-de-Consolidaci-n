/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej7;

import java.util.Arrays;

/**
 *
 * @author guill
 */
public class Tema7ej7 {

    public static void crearTabla(int[] tabla) {

        for (int i = 0; i < tabla.length; i++) {

            tabla[i] = (int) (Math.random() * 50) + 1;

        }
        Arrays.sort(tabla);

        System.out.println("Numeros generados: " + Arrays.toString(tabla));
        System.out.print("Los 10 números más grandes: ");
        for (int i = 14; i >= 5; i--) {
            System.out.print(tabla[i] + " ");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] tablaFinal = new int[15];
        crearTabla(tablaFinal);
    }

}
