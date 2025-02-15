/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej17;

/**
 *
 * @author guill
 */
public class Tema7ej17 {

    private static final int[] CHUMBAWAMBA = new int[10];

    public static void mostrarCosaAgain(int[] chumbawamba) {

        for (int i = 0; i < chumbawamba.length; i++) {
            System.out.print("[" + chumbawamba[i] + "] ");
        }
    }

    public static void ordenarCosa(int[] chumbawamba) {
        int max = 0;
        for (int i = 0; i < chumbawamba.length - 1; i++) {
            for (int j = 0; j < chumbawamba.length - 1 - i; j++) {
                if (chumbawamba[j] < chumbawamba[j + 1]) {
                    int temp = chumbawamba[j];
                    chumbawamba[j] = chumbawamba[j + 1];
                    chumbawamba[j + 1] = temp;

                }
            }

        }

    }

    public static void mostrarCosa(int[] chumbawamba) {
        for (int i = 0; i < chumbawamba.length; i++) {
            System.out.print("[" + chumbawamba[i] + "] ");
        }
        System.out.println("");
    }

    public static void llenarCosa(int[] chumbawamba) {
        chumbawamba = CHUMBAWAMBA;

        for (int i = 0; i < chumbawamba.length; i++) {
            chumbawamba[i] = (int) Math.floor(Math.random() * 10);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        llenarCosa(CHUMBAWAMBA);
        mostrarCosa(CHUMBAWAMBA);
        ordenarCosa(CHUMBAWAMBA);
        mostrarCosaAgain(CHUMBAWAMBA);
    }

}
