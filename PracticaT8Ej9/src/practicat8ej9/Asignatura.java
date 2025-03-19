/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicat8ej9;

/**
 *
 * @author guill
 */
public class Asignatura {

    private String nombreAsignatura;

    private float notaAsignatura;

    public Asignatura(String nombreAsignatura, float nota) {
        this.nombreAsignatura = nombreAsignatura;
        this.notaAsignatura = nota;
    }

    public Asignatura() {

        this.nombreAsignatura = "";
        this.notaAsignatura = 0.0f;

    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public float getNotaAsignatura() {
        return notaAsignatura;
    }

    public void setNota(float nota) {
        this.notaAsignatura = nota;
        
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAsignatura=" + nombreAsignatura + ", nota=" + notaAsignatura + '}';
    }

 
    
}
