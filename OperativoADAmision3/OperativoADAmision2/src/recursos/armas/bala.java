/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author alumno
 */
public class bala {
    
    private int diametro;
    
    public bala (){
        diametro = 0;
    }

    public bala(int diametro) {
        this.diametro = diametro;
    }
    
    public void generarDiametro(int diametro){
        this.diametro = diametro;
    } 
    
    public int obtenerDiametro (){
        return diametro;
    }
    
}
