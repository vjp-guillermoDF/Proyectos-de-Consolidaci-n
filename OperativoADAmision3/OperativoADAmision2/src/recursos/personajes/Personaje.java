/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.personajes;
import java.util.UUID;
import recursos.armas.Arma;
import recursos.armas.ArmaCortoAlcance;

/**
 *
 * @author guill
 */
public class Personaje {
    
    private String identificador;
    private String nombre;
    private int vida = 100;
    private char marca;
    private int coordenadaX;
    private int coordenadaY;
    private Arma arma;
    
    public Personaje (){
        
    identificador = generarID();
    nombre = "";
    marca = '\0';
    coordenadaX = 0;
    coordenadaY = 0;
}
    public Personaje (String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, Arma arma){
        
        this.identificador = identificador;
        this.nombre = nombre;
        this.vida = vida;
        this.marca = marca;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.arma = arma;
    }
    
    public void setNombre (String nombre){
        
        this.nombre = nombre;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public int getVida(){
        
        return vida;
    }
    
    public void setMarca (char marca){
        
        this.marca = marca;
    }

    public void setVida(int vida) {
        
        this.vida = vida;
    }
       
    public char getMarca (){
        
        return marca;
    }
    
    public static String generarID (){
        
        return UUID.randomUUID().toString();
    }

    public String obtenerID() {
        
        return identificador;
    }
    
    public void actualizarPosicion (int coordenadaX, int coordenadaY){
        
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    public int obtenerPosicionX (){
        
        return coordenadaX;
    }
    
    public int obtenerPosicionY (){
        
        return coordenadaY;
    }

    public void generarArma(Arma arma) {
        
        this.arma = arma;
    }

    public Arma obtenerArma() {
        
        return arma;
    }
    
}
