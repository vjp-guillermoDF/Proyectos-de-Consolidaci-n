/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej3;

import java.util.Arrays;

/**
 *
 * @author Don Guillermo Domínguez de la Fuente I de España y Portugal
 */
public class Tema8ej3 {
    
    public static final int[] VECTORENTEROS = new int[30];
    
    public static void mostrarVectorEnteros(int[] vectorEnteros) {
        System.out.println(Arrays.toString(vectorEnteros));
        
    }
    
    public static void llenarVectorEnteros(int[] vectorEnteros) {
        
        Arrays.fill(vectorEnteros, 0, 10, 10);
        Arrays.fill(vectorEnteros, 10, 20, 20);
        Arrays.fill(vectorEnteros, 20, 30, 30);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        llenarVectorEnteros(VECTORENTEROS);
        mostrarVectorEnteros(VECTORENTEROS);
    }
    
}
