/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema6ej14;

/**
 *
 * @author guill
 */
public class Test {

    public static void mostrarTodo(Publicacion objeto) {
        if (objeto instanceof Libros) {
            System.out.println(objeto.toString());
            ((Libros) objeto).prestar();
            ((Libros) objeto).mostrarPrestado();
            ((Libros) objeto).devolver();
            ((Libros) objeto).mostrarPrestado();
        } else if (objeto instanceof Revistas) {
            System.out.println(objeto.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Revistas revista = new Revistas(7777, "Las figuritas de mazapan y tu", "2025", 7);
        Libros libro = new Libros(5665, "Ojala encuentres un pinguino aqui", "2025");
        Publicacion revista2 = new Revistas(6763, "Mujeres atractivas totalmente cubiertas con armadura medieval", "2025", 15);
        Prestable libro2 = new Libros(0204, "Como cocinar para 40 humanos", "2025");
        mostrarTodo(revista);
        mostrarTodo(libro);
        mostrarTodo(revista2);
        libro2.mostrarPrestado();
        libro2.prestar();
        libro2.mostrarPrestado();
        libro2.devolver();

    }

}
