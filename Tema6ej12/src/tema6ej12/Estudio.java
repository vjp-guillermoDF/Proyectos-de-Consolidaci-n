/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6ej12;

/**
 *
 * @author guill
 */
public class Estudio {

    private String nombre;

    private String ultimoLanzamiento;

    public Estudio(String nombre, String ultimoLanzamiento) {
        this.nombre = nombre;
        this.ultimoLanzamiento = ultimoLanzamiento;
    }

    public Estudio() {
        this.nombre = "";
        this.ultimoLanzamiento = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUltimoLanzamiento() {
        return ultimoLanzamiento;
    }

    public void setUltimoLanzamiento(String ultimoLanzamiento) {
        this.ultimoLanzamiento = ultimoLanzamiento;
    }

    @Override
    public String toString() {
        return nombre + ", ultimoLanzamiento = " + ultimoLanzamiento + '}';
    }

}
