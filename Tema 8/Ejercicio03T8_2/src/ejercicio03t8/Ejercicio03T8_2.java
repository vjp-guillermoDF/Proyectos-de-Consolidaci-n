/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03t8;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Ejercicio03T8_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaración vector de enteros
        int[] vectorEnteros = new int[30];
        
        //Rellenamos el vector
        Arrays.fill(vectorEnteros, 0, 10, 0);
        Arrays.fill(vectorEnteros, 10, 20, 1);
        Arrays.fill(vectorEnteros, 20, 30, 5);
        
        //Mostramos el vector
        System.out.println(Arrays.toString(vectorEnteros));
    }
    
}
