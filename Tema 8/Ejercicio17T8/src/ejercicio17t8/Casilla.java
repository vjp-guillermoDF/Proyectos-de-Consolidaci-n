/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio17t8;

/**
 *
 * @author admin
 */
public class Casilla {
    private String ficha;  //Dos posibles valores: "O" o "X"
    private boolean ocupada;
    
    public Casilla(){
        this.ficha = "";
        this.ocupada = false;
    }

    public Casilla(String ficha, boolean ocupada) {
        this.ficha = ficha;
        this.ocupada = ocupada;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Casilla{" + "ficha=" + ficha + ", ocupada=" + ocupada + '}';
    }
}
