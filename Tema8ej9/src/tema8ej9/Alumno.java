/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej9;

/**
 *
 * @author guill
 */
public class Alumno {

    private String nombreAl;

    private Asignatura[] nota;

    public Alumno(String nombreAl, Asignatura[] nota) {
        this.nombreAl = nombreAl;
        this.nota = nota;
    }

    public Alumno() {
        this.nombreAl = "";
        this.nota = new Asignatura[4];

    }

    public String getNombreAl() {
        return nombreAl;
    }

    public void setNombreAl(String nombreAl) {
        this.nombreAl = nombreAl;
    }

    public Asignatura[] getNota() {
        return nota;
    }

    public void setNota(Asignatura[] nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombreAl=" + nombreAl + ", nota=" + nota + '}';
    }

}
