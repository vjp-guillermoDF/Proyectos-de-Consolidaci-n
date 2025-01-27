/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6ej14;

/**
 *
 * @author guill
 */
public class Libros extends Publicacion implements Prestable {

    private boolean prestado = false;

    public Libros(int codigo, String titulo, String anoDePublicacion) {
        super(codigo, titulo, anoDePublicacion);

    }

    public Libros() {
        super();
        this.prestado = false;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return super.toString() + "Libros{" + "prestado=" + prestado + '}';
    }

    @Override
    public void prestar() {
        prestado = true;
        System.out.println("Prestando libro");
    }

    @Override
    public void devolver() {
        prestado = false;
        System.out.println("Devolviendo libro");
    }

    @Override
    public void mostrarPrestado() {
        if (prestado) {
            System.out.println("El libro está prestado");
        } else if (!prestado) {
            System.out.println("El libro no está prestado");
        }

    }

}
