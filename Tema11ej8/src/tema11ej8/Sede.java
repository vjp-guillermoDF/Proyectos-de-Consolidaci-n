/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej8;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Sede {

    private String nombre;

    private float ingresoAnual;

    public Sede(String nombre, float ingresoAnual) {
        this.nombre = nombre;
        this.ingresoAnual = ingresoAnual;
    }

    public Sede() {
        this.nombre = "";
        this.ingresoAnual = 0.0f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getIngresoAnual() {
        return ingresoAnual;
    }

    public void setIngresoAnual(float ingresoAnual) {
        this.ingresoAnual = ingresoAnual;
    }

    @Override
    public String toString() {
        return "Nombre de la sede: " + nombre + ". Ingreso anual: " + ingresoAnual + " euros.";
    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la sede: ");
        setNombre(entrada.next());
        return this.nombre;
    }

    public float pedirIngresos() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca los ingresos anuales: ");
        setIngresoAnual(entrada.nextFloat());
        return this.ingresoAnual;
    }

}
