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

    public static void rellenarTabla(int[] tablaVacia[]) {

        int i, j;
        int numeroAleatorio;
        for (i = 0; i < tablaVacia.length; i++) {
            numeroAleatorio = (int) (Math.random() * 101) + 100;
                tablaVacia[i][0] = numeroAleatorio;
            for (j = 0; j < tablaVacia[i].length; j++) {
                numeroAleatorio = (int) (Math.random() * 101) + 100;
                tablaVacia[0][j] = numeroAleatorio;
                
            }

        }

    }

    public static void mostrarPares(int[][] tablaLlena) {

        int i, j;

        for (i = 0; i < tablaLlena.length; i++) {
            for (j = 0; j < tablaLlena[i].length; j++) {
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
        mostrarPares(tablaFinal);
    }

}
