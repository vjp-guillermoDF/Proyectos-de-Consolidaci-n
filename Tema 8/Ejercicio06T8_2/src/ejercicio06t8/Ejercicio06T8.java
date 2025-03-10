/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06t8;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio06T8 {

    //Retorna el número de empleados (longitud del vector) introducidos por el usuario
    public static int pedirLongitud(){
        Scanner teclado = new Scanner(System.in);
        int tam;
        System.out.println("¿Cuántos empleados desea introducir?");
        tam = teclado.nextInt();
        return tam;
    }
    
    //Retorna el nombre introducido por el usuario
    public static String pedirNombre(){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.print("Introduzca el nombre del empleado: ");
        nombre = teclado.nextLine();
        return nombre;
    }
    
    //Retorna las horas introducidas por el usuario
    public static int pedirHoras(){
        Scanner teclado = new Scanner(System.in);
        int horas;
        System.out.print("¿Cuántas horas trabajó este mes? ");
        horas = teclado.nextInt();
        return horas;
    }
    
    //Retorna la tarifa introducida por el usuario
    public static int pedirTarifa(){
        Scanner teclado = new Scanner(System.in);
        int tarifa;
        System.out.print("¿Cuál es su tarifa por hora de trabajo? ");
        tarifa = teclado.nextInt();
        return tarifa;
    }
    
    //Rellena el vector de empleados
    public static void rellenarEmpleados(Empleado[] vEmpleados){
        String nombre;
        int horas, tarifa;
        int i;
        for(i = 0;i < vEmpleados.length;i++){
            System.out.println("- EMPLEADO "+(i+1)+" -");
            nombre = pedirNombre();
            horas = pedirHoras();
            tarifa = pedirTarifa();
            vEmpleados[i] = new Empleado(nombre, horas, tarifa);
            System.out.println("EMPLEADO "+(i+1)+" ALMACENADO CON ÉXITO");
            //Introducimos una línea en blanco
            System.out.println("");
        }
    }

    //Calcula el sueldo bruto del empleado recibido por pantalla
    public static int calcularSueldo(Empleado emp){
        int horasExtra, sueldoBruto;
        
        /* Si ha trabajado más de 40 horas, debemos calcular el sueldo teniendo en cuenta las
           horas extra*/
        if  (emp.getHoras() > 40){
            horasExtra = emp.getHoras() - 40;
            //sueldoBruto = (40 horas * tarifa normal) + (horasExtra * tarifa y media)
            sueldoBruto = (int)((40*emp.getTarifa()) + (horasExtra * (emp.getTarifa()*1.5f)));
        }
        else{  //Si no ha echado horas extra
            sueldoBruto = emp.getHoras() * emp.getTarifa();
        }
        return sueldoBruto;
    }
    
    public static void mostrarSueldosBrutos(Empleado[] vEmpleados){
        String nombre;
        int horas, tarifa, sueldoBruto;
        int i;
        System.out.println("SUELDO BRUTO DE LOS EMPLEADOS");
        for(i = 0;i < vEmpleados.length;i++){
            //Obtenemos los valores del empleado
            nombre = vEmpleados[i].getNombre();
            horas = vEmpleados[i].getHoras();
            tarifa = vEmpleados[i].getTarifa();
            //Calculamos su sueldo
            sueldoBruto = calcularSueldo(vEmpleados[i]);
            System.out.println(nombre+" trabajó "+horas+" horas, cobra "+tarifa+" la hora por lo que le corresponde un sueldo de "+sueldoBruto+" euros.");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tam = pedirLongitud();
        Empleado[] vEmpleados = new Empleado[tam];
        rellenarEmpleados(vEmpleados);
        mostrarSueldosBrutos(vEmpleados);
    }
    
}
