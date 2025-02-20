/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej6;

/**
 *
 * @author alumno
 */
public class Empleado {

    private String nombre;

    private int horasTrabajadas;

    private float tarifa;

    public Empleado(String nombre, int horasTrabajadas, float tarifa) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifa = tarifa;
    }

    public Empleado() {
        this.nombre = "";
        this.horasTrabajadas = 0;
        this.tarifa = 0.0f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", horasTrabajadas=" + horasTrabajadas + ", tarifa=" + tarifa + '}';
    }

}
