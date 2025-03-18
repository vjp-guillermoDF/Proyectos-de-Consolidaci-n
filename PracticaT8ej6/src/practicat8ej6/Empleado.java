/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicat8ej6;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Empleado {
    
    private String nombre;
    
    private int horas;
    
    private float tarifas;

    private Scanner entrada = new Scanner(System.in);
    
    public Empleado(String nombre, int horas, float tarifas) {
        this.nombre = nombre;
        this.horas = horas;
        this.tarifas = tarifas;
    }

    public Empleado() {
        this.nombre = introducirNombre();
        this.horas = introducirHoras();
        this.tarifas = introducirSalario();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float getTarifas() {
        return tarifas;
    }

    public void setTarifas(float tarifas) {
        this.tarifas = tarifas;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", horas=" + horas + ", tarifas=" + tarifas + '}';
    }
    
    public String introducirNombre (){
        System.out.println("Introduzca el nombre del empleado: ");
        setNombre(entrada.next());
        return nombre;
    }
    
    public int introducirHoras(){
        System.out.println("Introduzca las horas trabajadas: ");
        setHoras(entrada.nextInt());
        return horas;
    }
    
    public float introducirSalario(){
        System.out.println("Introduzca el salario por hora: ");
        setTarifas(entrada.nextFloat());
        return tarifas;
    }
    
}
