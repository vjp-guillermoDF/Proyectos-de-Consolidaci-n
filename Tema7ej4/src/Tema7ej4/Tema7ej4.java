/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema7ej4;

/**
 *
 * @author alumno
 */
public class Tema7ej4 {

    public static void rellenarTabla(int[][] tablaVacia) {

        int numeroAleatorio;
        for (int i = 0; i < tablaVacia.length; i++) {
            for (int j = 0; j < tablaVacia[i].length; j++) {
                numeroAleatorio = (int) (Math.random() * 101.0) + 100;
                tablaVacia[i][j] = numeroAleatorio;

            }

        }

    }

    public static void mostrarPares(int[][] tablaLlena) {

        for (int i = 0; i < tablaLlena.length; i++) {
            for (int j = 0; j < tablaLlena[i].length; j++) {
                if (tablaLlena[i][j] % 2 == 0) {
                    System.out.println("Mostrando los numeros pares. El valor " + tablaLlena[i][j] + " tiene asignada la fila " + i + j);

                }

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tablaFinal[][] = new int[4][3];
        rellenarTabla(tablaFinal);
        mostrarPares(tablaFinal);
    }

}
