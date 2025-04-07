/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej11;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Alumno implements Comparable<Alumno> {

    private String dni;

    private int expediente;

    private float notaMedia;

    public Alumno(String dni, int expediente, float notaMedia) {
        this.dni = dni;
        this.expediente = expediente;
        this.notaMedia = notaMedia;
    }

    public Alumno() {
        this.dni = "";
        this.expediente = 0;
        this.notaMedia = 0.0f;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "DNI de alumno: " + dni + ". Nº de expediente: " + expediente + ". Nota media: " + notaMedia + ".";
    }

    public String pedirDni() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el DNI del alumno: ");
        String respuesta = entrada.next();
        setDni(respuesta);
        return dni;
    }

    public int pedirExpediente() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el numero de expediente del alumno: ");
        int respuesta = entrada.nextInt();
        setExpediente(respuesta);
        return expediente;
    }

    public float pedirnNotaMedia() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la nota media del alumno: ");
        float respuesta = entrada.nextFloat();
        setNotaMedia(respuesta);
        return notaMedia;
    }

    @Override
    public int compareTo(Alumno otro) {
        return Integer.compare(this.expediente, otro.getExpediente());
    }
    
    

}
