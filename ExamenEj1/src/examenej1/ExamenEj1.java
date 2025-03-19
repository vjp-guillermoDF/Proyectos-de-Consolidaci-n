/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenej1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Guillermo Domínguez de la Fuente
 */
public class ExamenEj1 {

    public static final int MAX = 3;

    public static void diagonales(int[][] matriz) {  //Método para devolver las diagonales (en este caso valores 1, 5 y 9 del array
        int[] diagonales = new int[MAX];        //Vector creado para volcar los valores deseados

        for (int i = 0; i < matriz.length; i++) {    //Aquí no usamos un bucle anidado for sino que recorremos la longitud del array
            diagonales[i] = matriz[i][i];       //Asignamos a la matriz los valores correspondientes a la diagonal pedida

            System.out.println(diagonales[i]);

        }
    }

    public static void concatenarElementos(int[][] matriz) {        //Método para concatenar los elementos
        String arrayConcatenado = "";   //array auxiliar para cocatenar
        String replace = "";            //array auxiliar para reemplazar los valores

        for (int i = 0; i < matriz.length; i++) {       //Recorremos la matriz concatenanco los valores con un espacio
            for (int j = 0; j < matriz[i].length; j++) {
                arrayConcatenado += matriz[i][j] + " ";
                if (arrayConcatenado.contains("3")) {       //Condicion que sustituye los 3 por un tres
                    replace = arrayConcatenado.replace("3", "x");

                }
            }
        }
        System.out.println(replace.substring(0, 9));    //Aplicamos substring al array replace separando los valores indicados para irlos imprimiendo de tres en tres teniendo en cuenta los espacios. 
        System.out.println(replace.substring(9, 18));
        System.out.println(replace.substring(18, 27));

    }

    public static void valorMasAlto(int[][] matriz) {    //Devuelve el valor más alto
        int mayorValor = 0;
        for (int i = 0; i < matriz.length; i++) {    //Recorremos la matriz para encontrar e imprimir el valor más alto sustituyendo el valor auxiliar con cada valor que sea mayor que el anterior
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayorValor) {
                    mayorValor = matriz[i][j];

                }
            }

        }
        System.out.println("El valor mas alto del array es " + mayorValor + ".");
    }

    public static void rellenarMatriz(int[][] matriz) {      //Método para ir rellenando la matriz

        for (int i = 0; i < matriz.length; i++) {   //Se recorre la matriz llenándola con números al azar entre 30 y 50
            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = (int) (Math.random() * 20) + 31;

                System.out.println(matriz[i][j]);       //No he recordado como se evitaban las repeticiones

            }

        }
    }

    public static void menu(int[][] array) {        //Menú switch con su control de excepciones implementado
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        do {
            try {

                System.out.println("1 para rellenar la matriz.");
                System.out.println("2 para mostrar el numero mas alto.");
                System.out.println("3 para concatenar los elementos y sustituir los '3' por 'x'.");
                System.out.println("4 para mostrar los valores de la diagonal principal.");
                System.out.println("5 para salir del programa.");

                switch (entrada.nextInt()) {
                    case 1:
                        rellenarMatriz(array);
                        break;

                    case 2:
                        valorMasAlto(array);
                        break;

                    case 3:
                        concatenarElementos(array);
                        break;

                    case 4:
                        diagonales(array);
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema.");
                        cerrar = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                        entrada.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR. No se deben introducir letras.");
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = new int[MAX][MAX]; //Se crea la matriz con la longitud almacenada en MAX
        menu(matriz);

    }

}
