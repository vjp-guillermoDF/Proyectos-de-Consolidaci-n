/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author guill
 */
public class ArmaLargoAlcance extends Arma{
  

 private double velocidad;

    public ArmaLargoAlcance() {
        
        super();
        velocidad = 0;
    }

    public ArmaLargoAlcance(String identificador, int dano, int bala, double velocidad) {
        
        super(identificador, dano, bala);
         this.velocidad = velocidad;
        
    }

    public double obtenerVelocidad() {
        
        return velocidad;
    }

    public void establecerVelocidad(double velocidad) {
        
        this.velocidad = velocidad;
    }
    
    @Override
    public String toString() {
        
        return ". ID arma: " + obtenerIDarma() + ". Dano de arma: " + obtenerDano() + ". Diametro de bala en mm: " + obtenerBala() + ". Velocidad del arma: " + obtenerVelocidad();
    }
    
    
    
    

   
    
 
    
}
