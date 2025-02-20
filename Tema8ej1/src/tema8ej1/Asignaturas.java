/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej1;

/**
 *
 * @author guill
 */
public class Asignaturas {

    private String nombre;

    private float nota;

    public Asignaturas(String nombre, float nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Asignaturas() {
        this.nombre = "";
        this.nota = 0.0f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignaturas{" + "nombre=" + nombre + ", nota=" + nota + '}';
    }

}
