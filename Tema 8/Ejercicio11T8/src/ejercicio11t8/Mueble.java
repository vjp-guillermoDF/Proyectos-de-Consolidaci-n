/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11t8;

/**
 *
 * @author Quique Pineda
 */
public class Mueble {
    private float precio;
    private String descripcion;

    public Mueble() {
        this.precio = 0;
        this.descripcion = "";
    }
    
    public Mueble(float precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
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
    
    public void mostrarMueble(){
        System.out.println("Precio: "+this.precio+" Descripción: "+this.descripcion);
    }
    
}
