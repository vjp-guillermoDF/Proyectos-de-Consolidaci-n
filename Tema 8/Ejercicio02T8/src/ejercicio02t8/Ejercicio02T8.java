/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio02t8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio02T8 {

    public static void rellenarVector(int vector[]){
        Scanner teclado = new Scanner(System.in);
        int i;
        for(i = 0;i < vector.length;i++){
            System.out.print("Celda "+(i+1)+": ");
            vector[i] = teclado.nextInt();
        }
        Arrays.sort(vector);
    }
    
    public static void mostrarVector(int vector[]){
        for(int n:vector){
            System.out.print("["+n+"]");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vector = new int[6];
        rellenarVector(vector);
        mostrarVector(vector);
    }
    
}
