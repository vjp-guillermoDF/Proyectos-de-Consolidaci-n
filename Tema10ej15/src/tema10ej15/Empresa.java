/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10ej15;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Empresa {

    private String nombreEmpresa;

    private ArrayList<Empleado> empleados;

    public Empresa(String nombreEmpresa, ArrayList<Empleado> empleados) {
        this.nombreEmpresa = nombreEmpresa;
        this.empleados = empleados;
    }

    public Empresa() {
        this.nombreEmpresa = pedirNombreEmpresa();
        this.empleados = pedirEmpleados();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Nombre de empresa: " + nombreEmpresa + ". Lista de empleados: " + empleados.toString();
    }

    public String pedirNombreEmpresa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la empresa: ");
        setNombreEmpresa(entrada.next());
        return nombreEmpresa;
    }

    public ArrayList<Empleado> pedirEmpleados() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        setEmpleados(new ArrayList());

        do {

            System.out.println("Registrando empleado...");
            empleados.add(new Empleado());
            System.out.println("Empleado " + empleados.getLast().getNombre() + " registrado con exito.");
            System.out.println("¿Desea continuar?");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Saliendo del registro de empleados.");
                cerrar = true;
            } else if (!respuesta.equalsIgnoreCase("No") || !respuesta.equalsIgnoreCase("Si")) {
                System.out.println("La respuesta debe ser si o no.");
            }

        } while (!cerrar);

        return empleados;

    }

}
