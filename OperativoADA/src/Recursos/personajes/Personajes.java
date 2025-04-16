/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.personajes;

import Recursos.armas.Arma; //Clase Arma importada desde el paquete Recursos.
import Recursos.armas.ArmaCortoAlcance; //Clase ArmaCortoAlcance importada desde el paquete Recursos.
import java.util.UUID; //Útil UUID importado.

/**
 *
 * @author guill
 */
public class Personajes { //Atributos privados de la clase.

    private String identificador;

    private String nombre;

    private int vida;

    private char marca;

    private int coordenadaX;

    private int coordenadaY;

    private Arma arma;

    public Personajes(String nombre, char marca, int coordenadaX, int coordenadaY, Arma arma) { //Constructor parametrizado.
        this.identificador = generarID(); //Este atributo se inicializa siempre llamando al método generarID(), por lo que no se mete en los parámetros.
        this.nombre = nombre;
        this.vida = 100; //Este atributo se inicializa siempre en 100, por lo que no entra en los parámetros.
        this.marca = marca;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.arma = arma;
    }

    public Personajes() {   //Constructor por defecto.
        this.identificador = generarID(); //Se inicializa por defecto llamando al método generarID().
        this.nombre = "";
        this.vida = 100; //Se inicializa por defecto en 100.
        this.marca = ' ';
        this.coordenadaX = 0;
        this.coordenadaY = 0;
        this.arma = new ArmaCortoAlcance(); //Se inicializa por defecto como ArmaCortoAlcance.

    }
                                        //Getters, setters y toString().
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public char getMarca() {
        return marca;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Personajes{" + "identificador=" + identificador + ", nombre=" + nombre + ", vida=" + vida + ", marca=" + marca + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", arma=" + arma + '}';
    }

    public static String generarID() { //Método que utiliza UUID para generar un ID al azar y lo devuelve.
        String identificador = UUID.randomUUID().toString();
        return identificador;
    }

    public void actualizarPosicion(int X, int Y) { //Método que llama a los setter de coordenadaX y coordenadaY para actualizarlos.
        System.out.println("Actualizando las coordenadas X e Y:\n");
        setCoordenadaX(X);
        setCoordenadaY(Y);

    }

}
