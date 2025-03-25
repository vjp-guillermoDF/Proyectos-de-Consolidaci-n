/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej13;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Venta {

    private String nombre;

    private float ventas;

    public Venta(String nombre, float ventas) {
        this.nombre = nombre;
        this.ventas = ventas;
    }

    public Venta(String nombre) {
        this.nombre = nombre;
        this.ventas = pedirVentas();
    }

    public Venta() {
        this.nombre = "";
        this.ventas = 0.0f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getVentas() {
        return ventas;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Ventas del mes de " + nombre + ": " + ventas + " euros.";
    }

    public float pedirVentas() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca las ventas del mes de " + nombre + ":");
        setVentas(entrada.nextFloat());
        return ventas;
    }

}
