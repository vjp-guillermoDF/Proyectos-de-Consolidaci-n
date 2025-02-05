/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.personajes;
import recursos.armas.ArmaCortoAlcance;

/**
 *
 * @author alumno
 */
public class cyborg extends Personaje {
    
    private String habilidad;
    private String paisdeorigen;
    
    public cyborg (){
        
        super();
        habilidad = "";
        paisdeorigen = "";
    }

    public cyborg(String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, ArmaCortoAlcance arma, String habilidad, String paisdeorigen) {
        
        super(identificador, nombre, vida, marca, coordenadaX, coordenadaY, arma);
        this.habilidad = habilidad;
        this.paisdeorigen = paisdeorigen;
    }
    
    public void generarHabilidad (String habilidad){
        
        this.habilidad = habilidad;
    }
    
    public String obtenerHabilidad (){
        return habilidad;
    }
    
    public void generarPaisdeOrigen (String paisdeorigen){
        
        this.paisdeorigen = paisdeorigen;
    }
    
    public String obtenerPaisdeOrigen (){
        
        return paisdeorigen;
    }

    public void mostrarDatos(){
        
        System.out.println("Informacion del personaje tipo cyborg: \nIdentificador: " + obtenerID() + ". Nombre: " + getNombre() + ". Vida: " + getVida() + ". Marca: " + getMarca() + ". Coordenadas X e Y: " + obtenerPosicionX() + ", " + obtenerPosicionY() + obtenerArma() + ". Habilidad: " + obtenerHabilidad() + ". Pais de origen: " + obtenerPaisdeOrigen() + "\n");
    }
    
    
    
}


