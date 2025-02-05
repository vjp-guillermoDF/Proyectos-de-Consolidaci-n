/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;
import java.util.UUID;


/**
 *
 * @author guill
 */
public class Arma {
    
    private String identificador;
    private int dano;
    private int bala;
    
    public Arma (){
        
        identificador = generarIDarma();
        dano = 0;
        bala = 0;
    }
    
    public Arma (String identificador, int dano, int bala){
        
        this.identificador = identificador;
        this.dano = dano;
        this.bala = bala;
    }
    
     public static String generarIDarma (){
         
        return UUID.randomUUID().toString();
    }
    
     public String obtenerIDarma (){
         
         return identificador;
     }
     
     public void generarDano (int dano){
         
         this.dano = dano;
     }
     
     public int obtenerDano (){
         
         return dano;
     }
     
     public void generarBala (int bala){
         
         this.bala = bala;
     }
     
     public int obtenerBala (){
         
         return bala;
     }


}
