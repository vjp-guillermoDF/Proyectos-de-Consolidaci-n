/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13t8;

/**
 *
 * @author Quique Pineda
 */
public class Ejercicio13T8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno al1 = new Alumno();
        Alumno al2 = new Alumno("Carlitos", 23, 8.8F);
        Alumno al3 = new Alumno("Alba", 19, 7.6F);
        
        al1.mostrarAlumno();
        al2.mostrarAlumno();
        al3.mostrarAlumno();
        
        al1.setNombre("Kiko");
        al1.setEdad(25);
        al1.setNotaMedia(4);
        
        al3.setNotaMedia(8);
        
        al1.mostrarAlumno();
        al2.mostrarAlumno();
        al3.mostrarAlumno();
    }
    
}
