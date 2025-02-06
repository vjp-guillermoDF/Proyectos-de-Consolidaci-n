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
        int n = 0;
        int contador = 0;
        do {
            n++;
            if (tabla[n] % 2 != 0) {
                contador++;
                System.out.println(n);
                
            }

        } while (contador != tabla.length);
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
