/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej19;

/**
 *
 * @author guill
 */
public class Tema7ej19 {

    private static final int[] THEODENKING = new int[100];

    /**
     * @param theodenKing
     */
    public static void mediaCosas(int[] theodenKing) {
        int suma = 0;
        int media = 0;
        for (int i = 0; i < theodenKing.length - 1; i++) {
            suma += theodenKing[i];
            media = suma / theodenKing.length;
        }

        System.out.println("La media es " + media + ".");
    }

    public static void cosasRepetidas(int[] theodenKing) {

        int maxRepeticiones = 0;
        int numeroMasRepetido = theodenKing[0];

        for (int i = 0; i < theodenKing.length; i++) {
            int actualRepeticiones = 0;

            for (int j = 0; j < theodenKing.length; j++) {
                if (theodenKing[i] == theodenKing[j]) {
                    actualRepeticiones++;
                }
            }

            if (actualRepeticiones > maxRepeticiones) {
                maxRepeticiones = actualRepeticiones;
                numeroMasRepetido = theodenKing[i];
            }
        }

        System.out.println("\nEl número que más se repite es " + numeroMasRepetido + ", con " + maxRepeticiones + " repeticiones.\n");
    }

    public static void cosaMenor(int[] theodenKing) {
        int min = 80;
        for (int i = 0; i < theodenKing.length; i++) {
            if (theodenKing[i] < min) {
                min = theodenKing[i];

            }

        }
        System.out.println("\nEl valor minimo es el de " + min + ".");
    }

    public static void cosaMayor(int[] theodenKing) {
        int max = 0;
        for (int i = 0; i < theodenKing.length; i++) {
            if (theodenKing[i] > max) {
                max = theodenKing[i];

            }

        }
        System.out.println("\nEl valor maximo es el de " + max + ".");
    }

    public static void mostrarCosas(int[] theodenKing) {
        for (int i = 0; i < theodenKing.length; i++) {
            System.out.print("[" + theodenKing[i] + "]");
        }
        System.out.println();
    }

    public static void crearCosas(int[] theodenKing) {

        for (int i = 0; i < theodenKing.length; i++) {
            theodenKing[i] = (int) Math.floor(Math.random() * 71) + 10;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        crearCosas(THEODENKING);
        mostrarCosas(THEODENKING);
        cosaMayor(THEODENKING);
        cosaMenor(THEODENKING);
        cosasRepetidas(THEODENKING);
        mediaCosas(THEODENKING);
    }

}
