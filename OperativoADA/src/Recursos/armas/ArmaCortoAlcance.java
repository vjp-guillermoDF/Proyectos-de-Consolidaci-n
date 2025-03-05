/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.armas;

import Recursos.personajes.Personajes;  //Clase Personajes importada desde el paquete Recursos.personajes.

/**
 *
 * @author guill
 */
public class ArmaCortoAlcance extends Arma { //La subclase hereda de Arma.

    private int alcance;    //Atributo privado de la clase.

    public ArmaCortoAlcance(int alcance, int diametro) {    //Constructor parametrizado.
        super(15, diametro); //El da�o del arma de corto alcance se inicializa siempre en 15 por lo que lo hacemos en el s�per constructor parametrizado.
        this.alcance = alcance;
    }

    public ArmaCortoAlcance() { //Constructor por defecto.
        setDa�o(15); //Tambi�n se inicializa por defecto, para esto llamamos al setter.
        this.alcance = 0;
    }
                                //Getters, setters y toString().
    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return super.toString() + "ArmaCortoAlcance{" + "alcance=" + alcance + '}';
    }

    @Override
    public void disparar(Personajes enemigo) { //M�todo disparar heredado de la superclase.
        if (enemigo.getVida() > getDa�o()) {    //Si la vida supera al da�o, en el setter se le resta el da�o a la vida, llamando al getter
            enemigo.setVida(enemigo.getVida() - getDa�o());
            System.out.println("[" + enemigo.getNombre() + "] | Vida restante: [" + enemigo.getVida() + "].\n");  //Se muestra el mensaje correspondiente con el nombre y la vida restante del personaje.
            System.out.println("Alcance del disparo realizado: [" + alcance + "] metros.\n"); //Se muestra el alcance del disparo.

        } else {    //De lo contrario, es decir, si la vida restante es inferior al da�o, la vida se pone en cero usando el setter para que no pueda dar valores negativos.
            enemigo.setVida(0);
            System.out.println("Enemigo: [" + enemigo.getNombre() + "] abatido.\n");    //Se muestra el mensaje correspondiente con el nombre del enemigo.
        }
    }

}
