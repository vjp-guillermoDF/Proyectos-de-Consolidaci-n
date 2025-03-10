/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10t8;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Ejercicio10T8 {

    final static int MAX = 10;
    
    public static int generarAleatorio(){
        int aleatorio;
        aleatorio = (int)(Math.random() * 10) + 1; //Aleatorio entre 1 y 10
        return aleatorio;
    }
    
    public static void rellenarVector(int vNum[]){
        int i;
        for(i = 0;i < vNum.length;i++){
            vNum[i] = generarAleatorio();
        }
    }
    
    //Ordena el array de mayor a menor
    public static void ordenarDescendente(int vNum[]){
        int i, j, aux;
        for(i = 0;i < vNum.length-1;i++){
            for(j = 0;j < vNum.length-1;j++){    
                if  (vNum[j] < vNum[j+1]){
                    aux = vNum[j+1];
                    vNum[j+1] = vNum[j];
                    vNum[j] = aux;
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vNum = new int[MAX];
        rellenarVector(vNum);
        System.out.println("Vector desordenado: ");
        System.out.println(Arrays.toString(vNum));
        //Para ordenarlo de menor a mayor Arrays.sort(vNum);
        ordenarDescendente(vNum);
        System.out.println("Vector ordenado: ");
        System.out.println(Arrays.toString(vNum));
    }   
}
