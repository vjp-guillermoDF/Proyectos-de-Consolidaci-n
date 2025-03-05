/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.armas;

/**
 *
 * @author guill
 */
public class Bala {

    private int diametro;   //Atributo privado de la clase.
    

    public Bala(int diametro) { //Constructor parametrizado.
        this.diametro = diametro;
    }

    public Bala() { //Constructor por defecto.
        this.diametro = 0;
    }
                                //Getters, setters y toString().
    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return "Bala{" + "diametro=" + diametro + '}';
    }

}
