/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicat8ej1;

/**
 *
 * @author guill
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

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", nota=" + nota + '}';
    }

    public int calcularMedia(Asignatura[] asignaturas) {
        int media = 0;
        int suma = 0;

        for (Asignatura i : asignaturas) {

            suma += i.getNota();

        }
        media = suma / asignaturas.length;
        return media;
    }

}
