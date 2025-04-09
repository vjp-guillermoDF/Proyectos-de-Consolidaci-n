/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej10;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Persona implements Comparable<Persona> {

    private String nombre;

    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {
        this.nombre = "";
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ". Edad: " + edad + ".";
    }

    @Override
    public int compareTo(Persona otro) {
        if (this.edad > otro.getEdad()) {
            return 1;
        } else if (this.edad < otro.getEdad()) {
            return -1;
        } else {
            return 0;
        }

    }

    public int pedirEdad() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca edad: ");
        setEdad(entrada.nextInt());
        return this.edad;
    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca nombre: ");
        setNombre(entrada.next());
        return this.nombre;
    }

}
