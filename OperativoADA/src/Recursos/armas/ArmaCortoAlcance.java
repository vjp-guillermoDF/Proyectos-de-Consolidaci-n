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
        super(15, diametro); //El daño del arma de corto alcance se inicializa siempre en 15 por lo que lo hacemos en el súper constructor parametrizado.
        this.alcance = alcance;
    }

    public ArmaCortoAlcance() { //Constructor por defecto.
        setDaño(15); //También se inicializa por defecto, para esto llamamos al setter.
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
    public void disparar(Personajes enemigo) { //Método disparar heredado de la superclase.
        if (enemigo.getVida() > getDaño()) {    //Si la vida supera al daño, en el setter se le resta el daño a la vida, llamando al getter
            enemigo.setVida(enemigo.getVida() - getDaño());
            System.out.println("[" + enemigo.getNombre() + "] | Vida restante: [" + enemigo.getVida() + "].\n");  //Se muestra el mensaje correspondiente con el nombre y la vida restante del personaje.
            System.out.println("Alcance del disparo realizado: [" + alcance + "] metros.\n"); //Se muestra el alcance del disparo.

        } else {    //De lo contrario, es decir, si la vida restante es inferior al daño, la vida se pone en cero usando el setter para que no pueda dar valores negativos.
            enemigo.setVida(0);
            System.out.println("Enemigo: [" + enemigo.getNombre() + "] abatido.\n");    //Se muestra el mensaje correspondiente con el nombre del enemigo.
        }
    }

}
