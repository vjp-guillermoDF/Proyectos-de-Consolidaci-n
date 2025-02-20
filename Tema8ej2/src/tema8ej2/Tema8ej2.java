/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej2;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema8ej2 {

    public static final int[] amanteBandido = new int[pedirNumero()];

    /**
     * @param args the command line arguments
     */
    public static void MiguelBose(int[] amanteBandido) {
        System.out.println("He aqui una ristra de numeros entre uno y seis puestos al tuntun: ");
        for (int i : amanteBandido) {
            System.out.print(amanteBandido[i]);

        }

    }

    public static void llenarTabla(int[] amanteBandido) {

        for (int i = 0; i < amanteBandido.length; i++) {

            amanteBandido[i] = ((int) (Math.random() * 6) + 1);

        }

    }

    public static int pedirNumero() {
        boolean unoadiez = true;
        int numero = 0;
        System.out.println("Dale una longitud entre 1 y 10;");
        do {

            try {
                Scanner entrada = new Scanner(System.in);

                numero = entrada.nextInt();

                if (numero < 1 || numero > 10) {
                    unoadiez = false;
                    System.out.println("HE DICHO ENTRE UNO Y DIEZ");
                } else {
                    unoadiez = true;
                }
            } catch (Exception e) {
                unoadiez = false;
                System.out.println("POR EL AMOR DE DIOS");
            }
        } while (!unoadiez);

        return numero;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        llenarTabla(amanteBandido);
        MiguelBose(amanteBandido);

    }
}
