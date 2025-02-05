/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.personajes;
import recursos.armas.Arma;


/**
 *
 * @author guill
 */
public class Policia extends Personaje {
    
    private int numeroPlaca;
    private String departamento;
    private String permisoArma;
    private String rango;
    
    public Policia () {
        
    super();
    numeroPlaca = generarNumeroPlaca();
    departamento = "";
    permisoArma = "";
    rango = "";
}

    public Policia(int numeroPlaca, String departamento, String permisoArma, String rango, String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, Arma arma) {
        
        super(identificador, nombre, vida, marca, coordenadaX, coordenadaY, arma);
        this.numeroPlaca = numeroPlaca;
        this.departamento = departamento;
        this.permisoArma = permisoArma;
        this.rango = rango;
    }
    
    
    public static int generarNumeroPlaca (){
        
        return (int) (Math.random()*5000+1);
    }
    
    public int obtenerNumeroPlaca (){
        
        return numeroPlaca;
    }
    
    public void generarDepartamento (String departamento){
        
        this.departamento = departamento;
    }
    
    public String obtenerDepartamento (){
        
        return departamento;
    }
    
    public void generarPermisoArma (String permisoArma){
        
        this.permisoArma = permisoArma;
    }
    
    public String obtenerPermisoArma (){
        
        return permisoArma;
    }
    
    public void generarRango (String rango){
        
        this.rango = rango;
    }
    
    public String obtenerRango (){
        return rango;
    }

    @Override
    public String toString() {
        
    return "Numero de placa: " + obtenerNumeroPlaca() + ". Nombre: " + getNombre() + ". Vida: " + getVida() + ". Marca: " + getMarca() + ". Coordenadas X e Y: " + obtenerPosicionX() + ", " + obtenerPosicionY() +  "Numero de Placa: " + obtenerNumeroPlaca() + ". Departamento=" + obtenerDepartamento() + ". Permiso de arma: " + obtenerPermisoArma() + ". Arma: " + obtenerArma() + ". Rango: " + obtenerRango(); 
   
    }
    
    public void mostrarDatos(){
   
    System.out.println("Informacion del personaje tipo policia:  \nNumero de placa: " + obtenerNumeroPlaca() + ". Nombre: " + getNombre() + ". Vida: " + getVida() + ". Marca: " + getMarca() + ". Coordenadas X e Y: " + obtenerPosicionX() + ", " + obtenerPosicionY() + "numeroPlaca=" + obtenerNumeroPlaca() + ", departamento=" + obtenerDepartamento() + ". Permiso de arma: " + obtenerPermisoArma() + ". Arma: " + obtenerArma() + ". Rango: " + obtenerRango());   
}

}