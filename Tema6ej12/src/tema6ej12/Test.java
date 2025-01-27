/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6ej12;

/**
 *
 * @author alumno
 */
public class Test {

    public static void mostrarTodo(Contenido objeto) {
        if (objeto instanceof Serie) {
            System.out.println(((Serie) objeto).toString());
            ((Serie) objeto).entregar();
            ((Serie) objeto).valorar();
            System.out.println("Entregado: " + ((Serie) objeto).esEntregado());
            ((Serie) objeto).devolver();
            System.out.println("Entregado: " + ((Serie) objeto).esEntregado());

        } else if (objeto instanceof Videojuego) {
            System.out.println(((Videojuego) objeto).toString());
            ((Videojuego) objeto).entregar();
            ((Videojuego) objeto).valorar();
            System.out.println("Entregado: " + ((Videojuego) objeto).esEntregado());
            ((Videojuego) objeto).devolver();
            System.out.println("Entregado: " + ((Videojuego) objeto).esEntregado());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Contenido serie = new Serie("Matt Groening", "Los Simpson");
        mostrarTodo(serie);
        Estudio estudio = new Estudio("BioWare", "2024");
        Contenido videojuego = new Videojuego(80, estudio, "Dragon Underage: the Gayguard", "Homoaventuras");
        mostrarTodo(videojuego);
    }

}
