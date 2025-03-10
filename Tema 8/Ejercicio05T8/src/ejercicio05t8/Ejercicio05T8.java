/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05t8;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Ejercicio05T8 {

    public static void mostrarArray(int vNum[]){
        int i;
        for (i = 0;i < vNum.length;i++){
            System.out.print("["+vNum[i]+"]");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arrayEnteros = new int[10];
        int i;
        for (i = 0;i < arrayEnteros.length;i++){
            arrayEnteros[i] = (arrayEnteros.length - i) - 1;
        }
        System.out.println("\nDESCENDENTE");
        mostrarArray(arrayEnteros);
        //Ordena el array de forma ascendente
        Arrays.sort(arrayEnteros, 0, arrayEnteros.length);
        System.out.println("\nASCENDENTE");
        mostrarArray(arrayEnteros);
    }
    
}
