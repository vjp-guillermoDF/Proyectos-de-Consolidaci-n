/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author guill
 */
public class ArmaCortoAlcance extends Arma{
    
    private int alcance;

    public ArmaCortoAlcance() {
        
        super();
    }

    public ArmaCortoAlcance(String identificador, int dano, int bala, int alcance) {
        
        super(identificador, dano, bala);
        this.alcance = alcance;
    }

    public void generarAlcance(int alcance) {
        
        this.alcance = alcance;
    }

    public int obtenerAlcance() {
        
        return alcance;
    }

    @Override
    public String toString() {
        
        return ". ID arma: " + obtenerIDarma() + ". Dano de arma: " + obtenerDano() + ". Diametro de bala en mm: " + obtenerBala() + ". Alcance del arma: " + obtenerAlcance();
    }
    
   }         
   
