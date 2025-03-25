/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej10;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
/**
 *
 * @author alumno
 */
public class Asignatura {

    private String nombre;

    private int nota;

    public Asignatura(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.nota = pedirNota();
    }

    public Asignatura() {
        this.nombre = "";
        this.nota = 0;
    }

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

    public int pedirNota() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la nota de la asignatura " + nombre + ": ");
        setNota(entrada.nextInt());
        return nota;
    }

}
