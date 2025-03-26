/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Alumno {

    private String nombre;

    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombre, ArrayList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    public Alumno() {
        this.nombre = pedirNombre();
        this.asignaturas = new ArrayList();
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ". " + asignaturas;
    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del alumno.");
        setNombre(entrada.next());
        System.out.println("Alumno " + nombre + " registrado.");
        return nombre;
    }

    public float media() {
        float notaTotal = 0;
        int i = 0;
        while (i < asignaturas.size()) {
            notaTotal += asignaturas.get(i).getNota();
            i++;
        }
        return notaTotal / asignaturas.size();

    }

}
