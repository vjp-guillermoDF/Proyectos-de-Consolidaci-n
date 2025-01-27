/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6ej14;

/**
 *
 * @author guill
 */
public class Revistas extends Publicacion {

    private int numero;

    public Revistas(int codigo, String titulo, String anoDePublicacion, int numero) {
        super(codigo, titulo, anoDePublicacion);
        this.numero = numero;
    }

    public Revistas() {
        super();
        numero = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + "Revista" + numero;
    }

}
