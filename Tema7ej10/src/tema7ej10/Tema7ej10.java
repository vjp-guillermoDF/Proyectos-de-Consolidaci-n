/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej10;

import java.util.Arrays;

/**
 *
 * @author guill
 */
public class Tema7ej10 {

    public static int[] llenarTabla() {
        int[] tabla = new int[10]; // Vector de tamaño 10

        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = (int) (Math.random() * 8) + 1; // Genera un número entre 1 y 8
        }

        return tabla;
    }

    public static void mostrarTabña(int[] tabla) {
        System.out.println(Arrays.toString(tabla));
    }

    public static void cero(int[] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = i + 1; j < tabla.length; j++) {
                if (tabla[i] != 0 && tabla[i] == tabla[j]) {
                    tabla[j] = 0; // Sustituimos el valor repetido por 0
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] numeros = llenarTabla(); // Generamos el vector

        System.out.print("Tabla original: ");
        mostrarTabña(numeros); // Mostramos el vector original

        cero(numeros); // Sustituimos repetidos por 0

        System.out.print("Valores duplicados sustituidos por cero: ");
        mostrarTabña(numeros); // Mostramos el vector modificado
    }

}
