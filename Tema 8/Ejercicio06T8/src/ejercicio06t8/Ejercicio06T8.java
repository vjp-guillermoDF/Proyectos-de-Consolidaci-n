/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06t8;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio06T8 {

    public static void mostrarTrabajadores(Empleado vEmpleados[]){
        int i, horasExtra;
        float sueldo;

        System.out.println("INFO TRABAJADORES ");
        for(i = 0;i < vEmpleados.length;i++){
            System.out.println("TRABAJADOR "+i);
            System.out.println("--------------");
            System.out.println("Nombre: "+vEmpleados[i].getNombre());
            if  (vEmpleados[i].getHoras() <= 40){
                sueldo = vEmpleados[i].getHoras() * vEmpleados[i].getTarifa();
            }
            else{
                horasExtra = vEmpleados[i].getHoras() - 40;
                sueldo = ((horasExtra * (vEmpleados[i].getTarifa() * 1.5f)) + (40 * vEmpleados[i].getTarifa()));
            }
            System.out.println("Sueldo Bruto: "+sueldo);
        }
    }
    
    public static void rellenarVector(Empleado vEmpleados[]){
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoNom = new Scanner(System.in);
        int i;
        String nombre;
        int horas, tarifa;
        for(i = 0;i < vEmpleados.length;i++){
            System.out.println("TRABAJADOR "+i);
            System.out.println("--------------");
            System.out.print("Nombre: ");
            nombre = tecladoNom.nextLine();
            System.out.print("Horas: ");
            horas = teclado.nextInt();
            System.out.print("Tarifa: ");
            tarifa = teclado.nextInt();
            vEmpleados[i] = new Empleado(nombre, horas, tarifa);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado[] vEmpleados = new Empleado[3];
        rellenarVector(vEmpleados);
        mostrarTrabajadores(vEmpleados);
    }    
    
}
