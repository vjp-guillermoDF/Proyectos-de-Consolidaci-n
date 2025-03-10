/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14t8;

/**
 *
 * @author Quique Pineda
 */
public class Alumno {
    private String nombre;
    private int edad;
    private float notaMedia;

    public Alumno() {
        this.nombre = "";
        this.edad = 0;
        this.notaMedia = 0;
    }
    
    public Alumno(String nombre, int edad, float notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
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
    
    public void mostrarAlumno(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Edad: "+this.edad);
        System.out.println("Media: "+this.notaMedia);
        System.out.print("\n");  //Línea en blanco
    }
}
