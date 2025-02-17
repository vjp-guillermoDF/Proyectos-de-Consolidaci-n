/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.personajes;

import General.Jugable; //Interfaz Jugable importada del paquete General.
import Recursos.armas.Arma; //Clase Arma importada del paquete Recursos.armas.

/**
 *
 * @author guill
 */
public class Policia extends Personajes implements Jugable { //La subclase hereda de Peronajes e implementa la interfaz Jugable del paquete General.

    private int numeroPlaca;  //Atributos de la clase.

    private String departamento;

    private String permisoArma;

    private String rango;

    public Policia(String departamento, String permisoArma, String rango, String nombre, char marca, int coordenadaX, int coordenadaY, Arma arma) { //Constructor parametrizado.
        super(nombre, marca, coordenadaX, coordenadaY, arma);
        this.numeroPlaca = generarNumeroPlaca(); //Este valor se inicializa siempre llamando al método generarNumeroPlaca(), por lo que no lo ponemos en los parámetros.
        this.departamento = departamento;
        this.permisoArma = permisoArma;
        this.rango = rango;
    }

    public Policia() { //Constructor por defecto.
        super();
        this.numeroPlaca = generarNumeroPlaca(); //Este valor se inicializa por defecto llamando al método generarNumeroPlaca().
        this.departamento = "";
        this.permisoArma = "";
        this.rango = "";
    }
                                     //Getters, setters y toString().
    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(int numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPermisoArma() {
        return permisoArma;
    }

    public void setPermisoArma(String permisoArma) {
        this.permisoArma = permisoArma;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return super.toString() + "Policia{" + "numeroPlaca=" + numeroPlaca + ", departamento=" + departamento + ", permisoArma=" + permisoArma + ", rango=" + rango + '}';
    }

    public static int generarNumeroPlaca() { //Método que genera un número de Placa al azar entre 0 y 5000 y lo devuelve.
        int numeroPlaca = (int) (Math.random() * 5001);
        return numeroPlaca;
    }

    @Override
    public void atacar(Personajes enemigo) { //El método atacar, heredado de la interfaz Jugable.
        System.out.println("Policia atacando...");
    }

    @Override
    public void esquivar() {    //Método esquivar, heredado de la interfaz Jugable.
        int movimiento = (int) (Math.random() * 3) - 1; //Almacenamos en la variable Movimiento un número al azar calculado entre -1, 0 y 1.
        int coordenadaXold = (getCoordenadaX());    //Almacenamos el valor de las coordenadas anteriores en una variable. Esto no es necesario, basta con usar el getter. Pero lo hacemos por cuestiones estéticas.
        int coordenadaXnew = (coordenadaXold + movimiento); //Almacenamos el valor de las coordenadas nuevas en una variable que suma el número calculado a las anteriores.
        if (movimiento != 0) {  //Si el valor movimiento no es cero, se llama al método actualizarPosicion, el cual llama a los dos setters coordenadaX y coordenadaY en sus parámetros.
            actualizarPosicion(coordenadaXnew, getCoordenadaY()); //Actualizamos con la nueva información.
            System.out.println("Policia: [" + getNombre() + "] se mueve en X de [" + coordenadaXold + "] a [" + coordenadaXnew + "]."); //Mostramos la nueva información.

        } else {
            System.out.println("Policia: [" + getNombre() + "] mantiene su posicion en X.");    //De lo contrario (es decir, si el movimiento es 0), se muestra este mensaje.
        }
    }

    @Override
    public void defender() { //El método defender, heredado de la interfaz Jugable.
        int escudo = (int) (Math.random() * (15 - 5) + 5); //Se almacena en la variable escudo un número al azar entre 5 y 15.
        if ((getVida() + escudo) <= 100) { //Si la vida del personaje sumada al escudo es menor o igual a cien, se llama al setter, dentro del cual se suma el valor del escudo al getter.
            setVida(getVida() + escudo);

        } else { //De lo contrario (es decir, si la suma es mayor a 100), actualizamos la vida en el setter a 100, puesto que 100 debe ser el máximo.
            setVida(100);
        }
        System.out.println("\nPolicia: [" + getNombre() + "] con escudo calculado de [" + escudo + "] | Vida: [" + getVida() + "].\n"); //Imprimimos la información.
    }

}
