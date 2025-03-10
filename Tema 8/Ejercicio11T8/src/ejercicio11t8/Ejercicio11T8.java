/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11t8;

/**
 *
 * @author Quique Pineda
 */
public class Ejercicio11T8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mueble m1 = new Mueble();
        Mueble m2 = new Mueble(109.95F, "Sillón");
        
        m1.mostrarMueble();
        m2.mostrarMueble();
        
        m1.setDescripcion("Mueble nuevo");
        m1.setPrecio(280);
        
        m2.setPrecio(95);
        
        m1.mostrarMueble();
        m2.mostrarMueble();
        
    }
    
}
