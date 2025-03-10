/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03t8;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Ejercicio03T8 {

    public static void mostrarArray(int vectorEnteros[]){
        for(int n: vectorEnteros){
            System.out.print("["+n+"]");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vectorEnteros = new int[30];
        Arrays.fill(vectorEnteros, 0, 10, 0); //De la posición 0 a la 9 añado 0's
        Arrays.fill(vectorEnteros, 10, 20, 1); //De la posición 10 a la 19 añado 1's
        Arrays.fill(vectorEnteros, 20, 30, 5); //De la posición 20 a la 29 añado 5's
        mostrarArray(vectorEnteros);
    }
    
}
