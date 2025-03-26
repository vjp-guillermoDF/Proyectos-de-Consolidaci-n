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
        this.empleados = new ArrayList();
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
        return "Empresa{" + "nombreEmpresa=" + nombreEmpresa + ", empleados=" + empleados + '}';
    }

    public String pedirNombreEmpresa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la empresa: ");
        setNombreEmpresa(entrada.next());
        return nombreEmpresa;
    }

}
