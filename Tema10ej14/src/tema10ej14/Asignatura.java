/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej14;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
class Asignatura {
    
    private String nombreAs;
    
    private float nota;

    public Asignatura(String nombreAs, float nota) {
        this.nombreAs = nombreAs;
        this.nota = nota;
    }

    public Asignatura() {
        this.nombreAs = "";
        this.nota = 0;
    }
    
    public Asignatura(String nombreAs){
        this.nombreAs = nombreAs;
        this.nota = pedirNota();
        
    }    

    public String getNombreAs() {
        return nombreAs;
    }

    public void setNombreAs(String nombreAs) {
        this.nombreAs = nombreAs;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "La nota para la asignatura " + nombreAs + " es igual a: " + nota + ".";
    }
    
    public float pedirNota(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la nota para " + nombreAs + ":");
        setNota(entrada.nextFloat());
        return nota;
    }
    
}
