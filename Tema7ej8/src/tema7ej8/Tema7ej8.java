/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema7ej8 {

    public static int pedirNumero() {
        Scanner entrada = new Scanner(System.in);
        int numero;
        boolean cincoCifras;
        System.out.println("Introduzca un numero de cinco cifras:");
        do {
            numero = entrada.nextInt();
            if (numero / 10000 != 0 && numero / 100000 == 0) {
                cincoCifras = true;

            } else {
                cincoCifras = false;
                System.out.println("HE DICHO CINCO CIFRAS");
            }

        } while (!cincoCifras);
        return numero;

    }

    public static int[] dividirNumero(int numero) {
        int cifras = String.valueOf(numero).length();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero = pedirNumero();
        int[] cifras = dividirNumero(numero);
        int[] invertido = yarrA(cifras);

        System.out.println("Array original: " + Arrays.toString(cifras));
        System.out.println("Array invertido: " + Arrays.toString(invertido));
    }

}
