/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04t08;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Ejercicio04T08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaración del vector
        char[] arrayChar = new char[6];
        
        //Rellenamos el vector 
        Arrays.fill(arrayChar, 0, arrayChar.length/2, 'a');
        Arrays.fill(arrayChar, arrayChar.length/2, arrayChar.length, 'b');
        
        //Mostramos el array
        System.out.println(Arrays.toString(arrayChar));
    }
    
}
