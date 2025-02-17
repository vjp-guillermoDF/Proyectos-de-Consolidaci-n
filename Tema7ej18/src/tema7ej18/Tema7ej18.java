/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej18;

/**
 *
 * @author guill
 */
public class Tema7ej18 {

    private static final int[] CHUMBAWAMBA = new int[5];

    private static final int[] TUBTHUMPING = new int[5];

    private static final int[] CHUMBAWAMBATUBTHUMPING = new int[CHUMBAWAMBA.length + TUBTHUMPING.length];

    /**
     * @param chumbawamba
     * @param tubthumping
     * @param chumbawambaTubthumping
     */
    public static void mostrarCosas(int[] chumbawamba, int[] tubthumping, int[] chumbawambaTubthumping) {

        System.out.print("Array chumbawamba ordenado: [ ");
        for (int num : chumbawamba) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        System.out.print("Array tubthumping ordenado: [ ");
        for (int num : tubthumping) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        System.out.print("Array combinado y ordenado: [ ");
        for (int i = 0; i < chumbawambaTubthumping.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println("]");

    }

    public static int[] juntarCosas(int[] chumbawamba, int[] tubthumping, int[] chumbawambaTubthumping) {

        for (int i = 0; i < chumbawamba.length; i++) {

            chumbawambaTubthumping[i] = chumbawamba[i];
        }

        for (int i = 0; i < tubthumping.length; i++) {
            chumbawambaTubthumping[chumbawamba.length + i] = tubthumping[i];
        }

        for (int i = 0; i < chumbawambaTubthumping.length; i++) {
            for (int j = 0; j < chumbawambaTubthumping.length - 1; j++) {
                if (chumbawambaTubthumping[j] > chumbawambaTubthumping[j + 1]) {

                    int aux = chumbawambaTubthumping[j];
                    chumbawambaTubthumping[j] = chumbawambaTubthumping[j + 1];
                    chumbawambaTubthumping[j + 1] = aux;
                }
            }
        }
        return chumbawambaTubthumping;

    }

    public static void ordenarCosas(int[] chumbawamba, int[] tubthumping) {

        for (int i = 0; i < chumbawamba.length; i++) {
            for (int j = 0; j < chumbawamba.length - 1; j++) {

                if (chumbawamba[j] > chumbawamba[j + 1]) {
                    int aux = chumbawamba[j];
                    chumbawamba[j] = chumbawamba[j + 1];
                    chumbawamba[j + 1] = aux;
                }

                if (tubthumping[j] > tubthumping[j + 1]) {
                    int aux2 = tubthumping[j];
                    tubthumping[j] = tubthumping[j + 1];
                    tubthumping[j + 1] = aux2;
                }
            }

        }

    }

    public static void crearCosas(int[] chumbawamba, int[] tubthumping) {
        for (int i = 0; i < chumbawamba.length; i++) {
            chumbawamba[i] = (int) (Math.random() * 11);
            tubthumping[i] = (int) (Math.random() * 11);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        crearCosas(CHUMBAWAMBA, TUBTHUMPING);
        ordenarCosas(CHUMBAWAMBA, TUBTHUMPING);
        juntarCosas(CHUMBAWAMBA, TUBTHUMPING, CHUMBAWAMBATUBTHUMPING);
        mostrarCosas(CHUMBAWAMBA, TUBTHUMPING, CHUMBAWAMBATUBTHUMPING);

    }
}
