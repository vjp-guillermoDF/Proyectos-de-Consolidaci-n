/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej6;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema8ej6 {

    public static final Empleado[] ListaEmpleado = new Empleado[pedirLongitud()];

    public static void mostrarSueldos(Empleado[] listaEmpleado) {
        float sueldo;
        int horaExtra;
        double sueldoExtra;
        for (int i = 0; i < listaEmpleado.length; i++) {
            sueldo = listaEmpleado[i].getTarifa() * listaEmpleado[i].getHorasTrabajadas();

            if (listaEmpleado[i].getHorasTrabajadas() <= 40) {
                System.out.println(listaEmpleado[i].getNombre() + " ha trabajado " + listaEmpleado[i].getHorasTrabajadas() + " horas esta semana y cobra " + listaEmpleado[i].getTarifa() + " euros a la hora, por tanto le corresponden " + sueldo + " euros.");
            } else if (listaEmpleado[i].getHorasTrabajadas() > 40) {
                horaExtra = listaEmpleado[i].getHorasTrabajadas() - 40;
                sueldoExtra = horaExtra * 1.5;
                sueldo += sueldoExtra;
                System.out.println(listaEmpleado[i].getNombre() + " ha trabajado " + listaEmpleado[i].getHorasTrabajadas() + " horas esta semana y cobra " + listaEmpleado[i].getTarifa() + " euros a la hora, por tanto le corresponden " + sueldo + " euros.");

            }

        }

    }

    public static void crearLista(Empleado listaEmpleado[]) {

        for (int i = 0; i < listaEmpleado.length; i++) {

            listaEmpleado[i] = new Empleado(pedirNombre(), horasTrabajadas(), tarifa());

        }

    }

    public static int pedirLongitud() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el numero de empleados que desee: ");

        return entrada.nextInt();
    }

    public static String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el nombre del empleado: ");

        return entrada.next();
    }

    public static int horasTrabajadas() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cuantas horas ha trabajado este mes?");
        return entrada.nextInt();
    }

    public static float tarifa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cual es la tarifa?");
        return entrada.nextFloat();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        crearLista(ListaEmpleado);
        mostrarSueldos(ListaEmpleado);

    }

}
