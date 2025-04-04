/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej3;

/**
 *
 * @author guill
 */
public class Conductor {

    private String DNI;

    private String nombre;

    public Conductor(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public Conductor() {
        this.DNI = "";
        this.nombre = "";
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre del conductor: " + nombre + ". DNI : " + DNI + ".";
    }

}
