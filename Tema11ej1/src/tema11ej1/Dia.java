/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej1;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Dia {

    private String nombre;

    private int temperatura;

    public Dia(String nombre, int temperatura) {
        this.nombre = nombre;
        this.temperatura = temperatura;
    }

    public Dia() {

        this.nombre = "";
        this.temperatura = 0;

    }

    public Dia(String nombre) {
        this.nombre = nombre;
        this.temperatura = pedirTemperatura();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "La temperatura del dia " + nombre + " es " + temperatura + "º.";
    }

    public int pedirTemperatura() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la temperatura para el dia " + nombre + ":");
        setTemperatura(entrada.nextInt());
        return temperatura;
    }

}
