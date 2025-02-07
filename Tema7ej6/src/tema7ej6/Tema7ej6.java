/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7ej6;

/**
 *
 * @author alumno
 */
public class Tema7ej6 {

    public static void crearTabla(int[] tabla) {
        int num = 2;// Comenzamos desde el primer número primo
        int contador = 0;

        while (contador < 80) {
            if (esPrimo(num)) {
                tabla[contador++] = num;
            }
            num++;
        }
        for (int p : tabla) {
            System.out.print(p + " ");
        }
    }

    static boolean esPrimo(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] tabla = new int[80];
        crearTabla(tabla);

    }

}
