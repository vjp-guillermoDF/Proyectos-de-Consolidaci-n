/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12t8;

import java.util.Scanner;

/**
 *
 * @author Quique Pineda
 */
public class Ejercicio12T8 {
    
    public static String pedirDescripcion(){
        Scanner teclado = new Scanner(System.in);
        String descrip;
        System.out.print("Descripcion: ");
        descrip = teclado.nextLine();
        return descrip;
    }
    
    public static float pedirPrecio(){
        Scanner teclado = new Scanner(System.in);
        float precio;
        System.out.print("Precio: ");
        precio = teclado.nextFloat();
        return precio;
    }
    
    //Rellena los muebles del vector de muebles
    public static void rellenarMuebles(Mueble[] vMuebles){
        String descrip;
        float precio;
        for(int i = 0;i < vMuebles.length;i++){
            descrip = pedirDescripcion();
            precio = pedirPrecio();
            vMuebles[i] = new Mueble(precio, descrip);
        }
    }
    
    //Muestra las características de los muebles del vector
    public static void mostrarMuebles(Mueble[] vMuebles){
        for(int i = 0;i < vMuebles.length;i++){
            try{
                vMuebles[i].mostrarMueble();
            }
            catch(NullPointerException e){
                System.out.println("Mueble no disponible");
            }
        }
    }
    
    //Muestra las características de los muebles del vector, siempre y cuando el mueble tenga un precio inferior
    //a precioMax
    public static void mostrarMueblesPorPrecio(Mueble[] vMuebles, float precioMax){
        float precioAct;
        for(int i = 0;i < vMuebles.length;i++){
            try{
                precioAct = vMuebles[i].getPrecio();
                if  (precioAct < precioMax){
                    vMuebles[i].mostrarMueble();
                }
            }
            catch(NullPointerException e){
                System.out.println("Mueble no disponible");
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Mueble[] vMuebles = new Mueble[4];
        float precioMax;
        int opc;
        do{
            System.out.println("1. Rellenar muebles");
            System.out.println("2. Mostrar muebles");
            System.out.println("3. Mostrar muebles por precio");
            System.out.println("4. Salir");
            System.out.print("   Opcion: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    rellenarMuebles(vMuebles);
                    break;
                case 2:
                    mostrarMuebles(vMuebles);
                    break;
                case 3:
                    precioMax = pedirPrecio();
                    mostrarMueblesPorPrecio(vMuebles, precioMax);
                    break;
                case 4:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }while(opc != 4);
    }
    
}
