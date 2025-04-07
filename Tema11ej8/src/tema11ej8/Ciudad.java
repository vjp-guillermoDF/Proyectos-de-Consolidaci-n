/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej8;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ciudad {

    private String nombre;

    private HashMap<String, Sede> sedes;

    public Ciudad(String nombre, HashMap<String, Sede> sedes) {
        this.nombre = nombre;
        this.sedes = sedes;
    }

    public Ciudad() {
        this.nombre = "";
        this.sedes = new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Sede> getSedes() {
        return sedes;
    }

    public void setSedes(HashMap<String, Sede> sedes) {
        this.sedes = sedes;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre + ". Sedes: " + sedes.toString() + ".";
    }

    public String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la ciudad: ");
        setNombre(entrada.next());
        return this.nombre;
    }

    public HashMap<String, Sede> introducirSedes() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        setSedes(new HashMap());
        Sede aux = new Sede();
        aux.pedirNombre();
        aux.pedirIngresos();

        sedes.put(aux.getNombre(), aux);

        System.out.println("Sede " + aux.getNombre() + " registada con exito.");

        do {
            System.out.println("¿Desea registrar mas sedes?");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("si")) {
                Sede aux2 = new Sede();
                aux2.pedirNombre();
                aux2.pedirIngresos();
                sedes.put(aux2.getNombre(), aux2);
                System.out.println(aux2.toString() + " Registrado con exito.");
            } else if (respuesta.equalsIgnoreCase("no")) {
                System.out.println("Saliendo del sistema.");
                cerrar = true;
            } else {
                System.out.println("La respuesta debe ser si o no.");
            }
        } while (!cerrar);
        return sedes;

    }
}
