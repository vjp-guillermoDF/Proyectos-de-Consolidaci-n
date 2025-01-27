/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6ej14;

/**
 *
 * @author guill
 */
public class Publicacion {

    private int codigo;

    private String titulo;

    private String anoDePublicacion;

    public Publicacion(int codigo, String titulo, String anoDePublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoDePublicacion = anoDePublicacion;
    }

    public Publicacion() {
        this.codigo = 0;
        this.titulo = "";
        this.anoDePublicacion = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoDePublicacion() {
        return anoDePublicacion;
    }

    public void setAnoDePublicacion(String anoDePublicacion) {
        this.anoDePublicacion = anoDePublicacion;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "codigo =" + codigo + ", titulo =" + titulo + ", anoDePublicacion = " + anoDePublicacion + '}';
    }

}
