/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej7;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Campania {

    private String nombreCamp;

    private HashMap<String, Donaciones> donaciones;

    public Campania(String nombreCamp, HashMap<String, Donaciones> donaciones) {
        this.nombreCamp = nombreCamp;
        this.donaciones = donaciones;
    }

    public Campania() {
        this.nombreCamp = "";
        this.donaciones = new HashMap();
    }

    public String getNombreCamp() {
        return nombreCamp;
    }

    public void setNombreCamp(String nombreCamp) {
        this.nombreCamp = nombreCamp;

    }

    public HashMap<String, Donaciones> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(HashMap<String, Donaciones> donaciones) {
        this.donaciones = donaciones;
    }

    @Override
    public String toString() {
        return "Campania: " + nombreCamp + ". Donaciones: " + donaciones.toString();
    }

    public String pedirnombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca nombre del donante: ");
        String nombre = entrada.next();
        return nombre;
    }

    public int donar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la cantidad que desea donar: ");
        int donar = entrada.nextInt();
        return donar;
    }

    public HashMap<String, Donaciones> insertarDonaciones() {
        Scanner entrada = new Scanner(System.in);

        Donaciones aux = new Donaciones(pedirnombre(), donar());
        boolean cerrar = false;
        donaciones.put(aux.getNombre(), aux);
        System.out.println(aux.toString() + " Registrado con exito.");
        do {
            System.out.println("¿Desea realizar más donaciones?");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("si")) {
                Donaciones aux2 = new Donaciones(pedirnombre(), donar());
                donaciones.put(aux2.getNombre(), aux2);
                System.out.println(aux2.toString() + " Registrado con exito.");
            } else if (respuesta.equalsIgnoreCase("no")) {
                System.out.println("Saliendo del sistema.");
                cerrar = true;
            } else {
                System.out.println("La respuesta debe ser si o no.");
            }
        } while (!cerrar);

        return donaciones;

    }

}
