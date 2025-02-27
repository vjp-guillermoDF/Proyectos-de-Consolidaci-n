/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej13.pkg14;

/**
 *
 * @author alumno
 */
public class Alumno {

    private String nombre;

    private int edad;

    private float notaMedia;

    public Alumno(String nombre, int edad, float notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    public Alumno() {
        this.nombre = "";
        this.edad = 0;
        this.notaMedia = 0;
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

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "El alumno " + nombre + " de edad " + edad + " tiene una media de " + notaMedia;
    }
    

}
