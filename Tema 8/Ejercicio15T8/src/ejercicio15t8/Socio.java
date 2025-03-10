/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15t8;

/**
 *
 * @author Quique Pineda
 */
public class Socio {
    private String nombre;
    private float precio;

    public Socio() {
        this.nombre = "";
        this.precio = 0;
    }
    
    public Socio(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public void mostrarSocio(){
        System.out.println("   Nombre: "+this.nombre+" - Dinero abonado: "+this.precio);
    }
    
    
}
