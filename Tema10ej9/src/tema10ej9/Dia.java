/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej9;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Dia {

    private String nombreDia;

    private int temperatura;

    public Dia(String nombreDia, int temperatura) {
        this.nombreDia = nombreDia;
        this.temperatura = temperatura;
    }
    
    public Dia(String nombreDia){
        this.nombreDia = nombreDia;
        this.temperatura = pedirTemperatura();
    }
            
    public Dia() {
        this.nombreDia = "";
        this.temperatura = 0;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }



    public int pedirTemperatura() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la temperatura del dia: ");
        setTemperatura(entrada.nextInt());
        return this.temperatura;

    }

    @Override
    public String toString() {
        return "Dia{" + "nombreDia=" + nombreDia + ", temperatura=" + temperatura + '}';
    }

}
