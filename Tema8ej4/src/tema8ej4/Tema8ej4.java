/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej4;

import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class Tema8ej4 {
    
    public static final char[] ARRAYA = new char[3];
    
    public static final char[] ARRAYB = new char[3];
    
    public static final char[] ARRAYCHAR = new char[ARRAYA.length + ARRAYB.length];
    
    public static void mostrarArray(char[] arrayChar) {
        
        System.out.println(Arrays.toString(arrayChar));
        
    }
    
    public static void llenarArrays(char[] arrayA, char[] arrayB, char[] arrayChar) {
        
        Arrays.fill(arrayA, 'a');        
        Arrays.fill(arrayB, 'b');
        
        for (char i : arrayA) {
            Arrays.fill(arrayChar, i);
            
        }
        
        for (char i : arrayB) {
            Arrays.fill(arrayChar, arrayA.length, arrayChar.length, i);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        llenarArrays(ARRAYA, ARRAYB, ARRAYCHAR);
        mostrarArray(ARRAYCHAR);
    }
    
}
