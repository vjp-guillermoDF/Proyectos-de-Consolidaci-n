/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej11;

/**
 *
 * @author guill
 */
public class Tema7ej11 {

    public static void rellenarTabla(int[] tablaVacia) {

        int numeroAleatorio;
        for (int i = 0; i < tablaVacia.length; i++) {

            numeroAleatorio = (int) (Math.random() * 8) + 1;
            tablaVacia[i] = numeroAleatorio;

        }

    }

    public static void mostrarTabla(int[]tablaLlena) {

        for (int i = 0; i < tablaLlena.length; i++) {

            System.out.print("[" + tablaLlena[i] + "] ");

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int[] tabla = new int[10];
        rellenarTabla(tabla);
        mostrarTabla(tabla);

    }

}
