/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6ej12;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Contenido implements ValoracionContenido {

    private String titulo;

    private boolean entregado;

    private String genero;

    public Contenido(String titulo, boolean entregado, String genero) {
        this.titulo = titulo;
        this.entregado = entregado;
        this.genero = genero;
    }

    public Contenido(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        entregado = false;
    }

    public Contenido(String titulo) {
        this.titulo = titulo;
        this.entregado = false;
        this.genero = "";

    }

    public Contenido(boolean entregado) {
        this.titulo = "";
        this.entregado = entregado;
        this.genero = "";
    }

    public Contenido() {
        this.titulo = "";
        this.entregado = false;
        this.genero = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Contenido{" + "titulo=" + titulo + ", entregado=" + entregado + ", genero=" + genero + '}';
    }

    public int scanner() {
        Scanner entrada = new Scanner(System.in);

        return entrada.nextInt();

    }

    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean esEntregado() {
        return entregado;
    }

}
