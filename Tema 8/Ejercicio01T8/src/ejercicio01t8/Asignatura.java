/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01t8;

/**
 *
 * @author admin
 */
public class Asignatura {
    
    private String nombre;
    private int nota;

    /* Constructor por defecto */
    public Asignatura() {
        this.nombre = "";
        this.nota = 0;
    }
    
    /* Constructor parametrizado */
    public Asignatura(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    /* Getters y Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    //Método estático porque la nota media pertenece a TODAS las asignaturas, no a ninguna en concreto
    public static float calcularMedia(Asignatura vAsignaturas[]){
        int i, suma = 0;
        for(i = 0;i < vAsignaturas.length;i++){
            suma = suma + vAsignaturas[i].getNota();
        }
        return suma/vAsignaturas.length;
    }
}
