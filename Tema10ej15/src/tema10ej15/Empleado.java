/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej15;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Empleado {

    private String nombre;

    private int sueldo;

    public Empleado(String nombre, int sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Empleado() {
        this.nombre = pedirNombre();
        this.sueldo = pedirSueldo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nombre de empleado: " + nombre + ". Sueldo: " + sueldo + ".";
    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del empleado: ");
        setNombre(entrada.next());
        return nombre;
    }

    public int pedirSueldo() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el sueldo del empleado " + nombre + ": ");
        setSueldo(entrada.nextInt());
        return sueldo;
    }

}
