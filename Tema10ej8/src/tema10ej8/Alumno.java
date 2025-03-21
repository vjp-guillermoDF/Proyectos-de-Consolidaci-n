/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej8;

/**
 *
 * @author alumno
 */
public class Alumno {

    private String nombre;
    private int curso;

    public Alumno(String nombre, int curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public Alumno() {
        this.nombre = "";
        this.curso = 0;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", curso=" + curso + '}';
    }

}
