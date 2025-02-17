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
public class Cyborg extends Personajes implements Jugable { //La subclase hereda de Personajes e implementa la interfaz Jugable del paquete General.

    private String habilidad;   //Atributos de la clase.

    private String paisDeOrigen;

    public Cyborg(String habilidad, String paisDeOrigen, String nombre, char marca, int coordenadaX, int coordenadaY, Arma arma) { //Constructor parametrizado.
        super(nombre, marca, coordenadaX, coordenadaY, arma);
        this.habilidad = habilidad;
        this.paisDeOrigen = paisDeOrigen;
    }

    public Cyborg() {   //Constructor por defecto.
        super();
        this.habilidad = "";
        this.paisDeOrigen = "";
    }
                                     //Getters, setters y toString().
    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    @Override
    public String toString() {
        return super.toString() + "Cyborg{" + "habilidad=" + habilidad + ", paisDeOrigen=" + paisDeOrigen + '}';
    }

    @Override
    public void atacar(Personajes enemigo) {    //El método atacar, heredado de la interfaz Jugable.
        System.out.println("Cyborg atacando...");
    }

    @Override
    public void esquivar() {    //Método esquivar, heredado de la interfaz Jugable.
        int movimiento = (int) (Math.random() * 3) - 1; //Almacenamos en la variable Movimiento un número al azar calculado entre -1, 0 y 1.
        int coordenadaYold = (getCoordenadaY());    //Almacenamos el valor de las coordenadas anteriores en una variable. Esto no es necesario, basta con usar el getter. Pero lo hacemos por cuestiones estéticas.
        int coordenadaYnew = (coordenadaYold + movimiento); //Almacenamos el valor de las coordenadas nuevas en una variable que suma el número calculado a las anteriores.
        if (movimiento != 0) {  //Si el valor movimiento no es cero, se llama al método actualizarPosicion, el cual llama a los dos setters coordenadaX y coordenadaY en sus parámetros.
            actualizarPosicion(getCoordenadaX(), coordenadaYnew);   //Actualizamos con la nueva información.
            System.out.println("Cyborg: [" + getNombre() + "] se mueve en Y de [" + coordenadaYold + "] a [" + coordenadaYnew + "].\n");    //Mostramos la nueva información.

        } else {
            System.out.println("Cyborg: [" + getNombre() + "] mantiene su posicion en Y.\n");   //De lo contrario (es decir, si el movimiento es 0), se muestra este mensaje.
        }
    }

    @Override
    public void defender() {    //El método defender, heredado de la interfaz Jugable.
        int escudo = (int) (Math.random() * (30 - 10) + 10);    //Se almacena en la variable escudo un número al azar entre 10 y 30.
        if ((getVida() + escudo) <= 100) {  //Si la vida del personaje sumada al escudo es menor o igual a cien, se llama al setter, dentro del cual se suma el valor del escudo al getter.
            setVida(getVida() + escudo);

        } else {    //De lo contrario (es decir, si la suma es mayor a 100), actualizamos la vida en el setter a 100, puesto que 100 debe ser el máximo.
            setVida(100);
        }
        System.out.println("Cyborg: [" + getNombre() + "] con escudo calculado de [" + escudo + "] | Vida: [" + getVida() + "].");  //Imprimimos la información.
    }

}
