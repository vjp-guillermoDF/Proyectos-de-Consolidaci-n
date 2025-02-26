/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej11.pkg12;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Mueble {

    private float precio;

    private String descripcion;

    public Mueble(float precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Mueble() {
        this.precio = pedirPrecio();
        this.descripcion = pedirDescripcion();

    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float pedirPrecio() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el precio");
        return entrada.nextFloat();

    }

    public String pedirDescripcion() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la descripcion");
        return entrada.next();
    }

    @Override
    public String toString() {
        return "Mueble{" + "precio=" + precio + ", descripcion=" + descripcion + '}';
    }

}
