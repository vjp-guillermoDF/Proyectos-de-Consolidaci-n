/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej5;

import java.util.Scanner;

/**
 *
 * @author Don Guillermo Domínguez de la Fuente I de España y Portugal
 */
public class Tema7ej5 {

    public static void crearTabla(int[][] tabla) {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.println("Asigna valor a [" + i + j + "]");
                tabla[i][j] = entrada.nextInt();
            }
        }

    }

    public static void mostrarTabla(int[] tablaLlena[]) {
        crearTabla(tablaLlena);
        System.out.println("\nValores asignados:");
        for (int i = 0; i < tablaLlena.length; i++) {
            for (int j = 0; j < tablaLlena[i].length; j++) {
                System.out.print("\n [" + i + j + "] --> " + tablaLlena[i][j]);
            }

        }
    }

    public static void mostrarMayor(int tablaLlena[][]) {
        mostrarTabla(tablaLlena);
        int max = tablaLlena[0][0]; //Inicializa una variable max como el array en [0][0]
        for (int i = 0; i < tablaLlena.length; i++) {
            for (int j = 0; j < tablaLlena[i].length; j++) { //El segundo bucle for va actualizando lo que ocurre en el if de abajo
                if (tablaLlena[i][j] > max) { //Este if convierte el número que sea mayor que la variable max [0][0] en max 
                    max = tablaLlena[i][j];
                }

            }

        }
        System.out.println("\n\nEl valor máximo en la tabla es: " + max); //La razón por la que no se muestran todos los números mayores a la variable max es porque el segundo bucle los va actualizando
    }

    public static void mostrarMenor(int tablaLlena[][]) { //Misma lógica que con el método anterior pero para restar
        mostrarMayor(tablaLlena);
        int min = tablaLlena[0][0];
        for (int i = 0; i < tablaLlena.length; i++) {
            for (int j = 0; j < tablaLlena[i].length; j++) {
                if (tablaLlena[i][j] < min) {
                    min = tablaLlena[i][j];
                }

            }

        }
        System.out.println("\nEl valor mínimo en la tabla es: " + min);
    }

    public static void sumarTodo(int tablaLlena[][]) {
        mostrarMenor(tablaLlena);
        int suma = 0; //Se inicializa en 0
        for (int i = 0; i < tablaLlena.length; i++) {
            for (int j = 0; j < tablaLlena[i].length; j++) {
                suma += tablaLlena[i][j]; //Se van sumando los valores que hemos asignado gracias al segundo bucle for
                System.out.println("\n[" + i + j + "] => " + suma);

            }

        }
        System.out.println("\nLa suma de los valores es: " + suma);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] tablaFinal = new int[4][2];
        sumarTodo(tablaFinal);
    }

}
