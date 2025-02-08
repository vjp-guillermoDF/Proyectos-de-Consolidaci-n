/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej9;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema7ej9 {

    /**
     * @return
     */
    public static int pedirNumero() {
        Scanner entrada = new Scanner(System.in);
        int numero;

        System.out.println("Introduzca un numero:");

        numero = entrada.nextInt();

        return numero;

    }

    public static int calcularCifras(int numero) {
        int contador = 0;
        do {
            numero /= 10;
            contador++;
        } while (numero > 0);

        System.out.println("El numero tiene " + contador + " cifras.");
        return contador;
    }

    public static int[] dividirNumero(int numero) {
        int cifras = calcularCifras(numero);
        int[] arrayNumero = new int[cifras];

        for (int i = arrayNumero.length - 1; i >= 0; i--) {
            arrayNumero[i] = numero % 10;
            numero /= 10;

        }

        return arrayNumero;

    }

    public static int[] yarrA(int[] numero) {
        int[] invertido = new int[numero.length];
        for (int i = numero.length - 1; i >= 0; i--) {
            invertido[i] = numero[numero.length - 1 - i];
        }
        return invertido;

    }

    public static void main(String[] args) {
        // TODO code application logic here
        int numero = pedirNumero();
        int[] cifras = dividirNumero(numero);
        int[] invertido = yarrA(cifras);

        System.out.println("Array original: " + Arrays.toString(cifras));
        System.out.println("Array invertido: " + Arrays.toString(invertido));
    }

}
