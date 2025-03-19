/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicat8ej6;

import java.awt.BorderLayout;

/**
 *
 * @author guill
 */
public class PracticaT8ej6 {

    public static final int MAX = 3;

    public static void calcularSalario(Empleado[] empleados) {
        int i = 0;
        float sueldo = 0.0f;
        float sueldoExtra = 0.0f;
        float horasExtra = 0.0f;
        while (i < empleados.length) {
            if (empleados[i].getHoras() <= 40) {
                sueldo = (empleados[i].getTarifas() * empleados[i].getHoras());

            } else {
                horasExtra = (empleados[i].getHoras() - 40);
                sueldoExtra = horasExtra * (empleados[i].getTarifas() * 1.5f);
                sueldo += sueldoExtra;
            }
            System.out.println("El empleado " + empleados[i].getNombre() + " ha trabajado " + empleados[i].getHoras() + " horas.");
            System.out.println("A una tarifa de " + empleados[i].getTarifas() + " euros por hora, su sueldo bruto asciende a " + sueldo);
            i++;
        }

    }

    public static void rellenarEmpleados(Empleado[] empleados) {

        int i = 0;

        while (i < empleados.length) {
            if (empleados[i] == null) {
                empleados[i] = new Empleado();
                System.out.println("Empleado almacenado con exito.");

            } else {
                i++;
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado[] empleados = new Empleado[MAX];
        rellenarEmpleados(empleados);
        calcularSalario(empleados);

    }

}
