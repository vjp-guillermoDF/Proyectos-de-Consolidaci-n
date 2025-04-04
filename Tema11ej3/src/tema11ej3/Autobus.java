/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej3;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Autobus {

    private String matricula;

    private HashMap<String, Conductor> conductor;

    public Autobus(String matricula, HashMap<String, Conductor> conductor) {
        this.matricula = matricula;
        this.conductor = conductor;
    }

    public Autobus() {
        this.matricula = "";
        this.conductor = new HashMap();
    }

    public Autobus(String matricula) {
        this.matricula = matricula;
        this.conductor = introducirConductor();

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public HashMap<String, Conductor> getConductor() {
        return conductor;
    }

    public void setConductor(HashMap<String, Conductor> conductor) {
        this.conductor = conductor;
    }

    @Override
    public String toString() {

        return "Matricula del autobus: " + matricula + ". " + conductor.toString();
    }

    public HashMap<String, Conductor> introducirConductor() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        conductor = new HashMap();

        Conductor conductoraux = new Conductor(pedirDNI(), pedirNombre());
        conductor.put(conductoraux.getDNI(), conductoraux);
        do {
            System.out.println("¿Quieres registrar otro conductor?");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("no")) {
                cerrar = true;
            } else if (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si")) {
                System.out.println("La respuesta debe ser si o no.");

            } else {
                Conductor conductoraux2 = new Conductor(pedirDNI(), pedirNombre());
                conductor.put(conductoraux2.getDNI(), conductoraux2);
            }

        } while (!cerrar);

        return conductor;

    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del conductor: ");
        String nombre = entrada.next();
        return nombre;

    }

    public String pedirDNI() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el DNI del conductor: ");
        String DNI = entrada.next();
        return DNI;

    }

}
