/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicat8ej1;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class PracticaT8Ej1 {
    
    public static final int MAX = 6;

    /**
     * @param args the command line arguments
     */
    
    public static void menu (Asignatura[] asignaturas){
        Scanner entrada = new Scanner(System.in);
        String[] nombreAsignaturas = {"Programacion", "Bases de Datos", "Entornos de Desarrollo", "LMGI", "IPE", "Sistemas Informaticos"};
        boolean notNull = false;
        int i = 0;
        
        while(i < asignaturas.length){
            if(asignaturas[i] == null){
                asignaturas[i] = new Asignatura();
                asignaturas[i].setNombre(nombreAsignaturas[i]);
                System.out.println("Introduce la nota para la asignatura " + asignaturas[i].getNombre() + ":");
                asignaturas[i].setNota(entrada.nextInt());
            }else{
                i++;
            }
            
        }
        
        
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Asignatura[] asignaturas = new Asignatura[MAX];
        
        menu(asignaturas);
        int media = 0;
        for (Asignatura i : asignaturas) {
            media = i.calcularMedia(asignaturas);
        }
        System.out.println("La media es " + media + ".");
    }
    
}
