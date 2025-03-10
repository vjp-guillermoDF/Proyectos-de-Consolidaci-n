/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01t8;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio01T8 {

    public static final int MAX = 6;
    
    /* Rellena el vector de Asignaturas. Los nombres d elas asignaturas los obtiene del 
       vector vNombres */
    public static void rellenarNotas(Asignatura vAsignaturas[], String vNombres[]){
        Scanner teclado = new Scanner(System.in);
        int i, nota;
        for(i = 0;i < vAsignaturas.length;i++){
            System.out.print("Introduzca nota "+vNombres[i]+": ");
            nota = teclado.nextInt();
            vAsignaturas[i] = new Asignatura(vNombres[i], nota);
        }
    }
    
    /* Muestra todas las asignaturas del vector */
    public static void mostrarNotas(Asignatura vAsignaturas[]){
        int i;
        for(i = 0;i < vAsignaturas.length;i++){
            System.out.println("Nota "+vAsignaturas[i].getNombre()+": "+vAsignaturas[i].getNota());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos vector de asignaturas (en cada celda guardamos una asignatura)
        Asignatura[] vAsignaturas = new Asignatura[MAX];
        //Vector que almacena los nombres de las asignaturas del ciclo
        String[] vNombres = {"Programación", "Lenguaje de Marcas", "BBDD", "Entornos Desarrollo", "Sistemas Informáticos", "FOL"};
        rellenarNotas(vAsignaturas, vNombres);
        mostrarNotas(vAsignaturas);
        System.out.println("Nota media: "+Asignatura.calcularMedia(vAsignaturas));
    }
    
}
