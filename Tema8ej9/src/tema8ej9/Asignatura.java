/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema8ej9;

/**
 *
 * @author guill
 */
public class Asignatura {

    private String nombreAs;

    private int nota;

    public Asignatura(String nombreAs, int nota) {
        this.nombreAs = nombreAs;
        this.nota = nota;
    }

    public Asignatura() {
        this.nombreAs = "";
        this.nota = 0;
    }

    public String getNombreAs() {
        return nombreAs;
    }

    public void setNombreAs(String nombreAs) {
        this.nombreAs = nombreAs;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAs=" + nombreAs + ", nota=" + nota + '}';
    }

}
