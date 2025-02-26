/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej11.pkg12;

/**
 *
 * @author alumno
 */
public class Tema8ej1112 {

    public static final Mueble[] MUEBLES = new Mueble[4];

    /**
     * @param args the command line arguments
     */
    public static void mostrarPrecio(Mueble[] muebles) {
        for (Mueble i : muebles) {
            System.out.println("El precio de " + i + " es " + i.getPrecio() + " euros.");
        }
    }

    public static void mostrarLista(Mueble[] muebles) {
        for (Mueble i : muebles) {
            System.out.println(i.toString());
        }
    }

    public static void crearLista(Mueble[] muebles) {

        for (int i = 0; i < muebles.length; i++) {

            muebles[i] = new Mueble();

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Mueble taburete = new Mueble(25, "delicioso");
        Mueble sofa = new Mueble(35, "riconudo");
        Mueble beanbag = new Mueble();
        Mueble mesa = new Mueble();
        
        crearLista(MUEBLES);
        mostrarLista(MUEBLES);
        mostrarPrecio(MUEBLES);

    }

}
