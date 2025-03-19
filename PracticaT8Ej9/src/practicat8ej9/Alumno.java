/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicat8ej9;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Alumno {

    private String nombreAlumno;

    private Asignatura[] nota;

    private final int max = 4;

    public Alumno(String nombreAlumno, Asignatura[] nota) {
        this.nombreAlumno = nombreAlumno;
        this.nota = nota;
        for (int i = 0; i < nota.length; i++) {
            nota[i] = new Asignatura();
        }
    }

    public Alumno() {

        this.nombreAlumno = "";
        this.nota = new Asignatura[max];
        for (int i = 0; i < this.nota.length; i++) {
            this.nota[i] = new Asignatura();
        }

    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Asignatura[] getNota() {
        return nota;
    }

    public void setNota(Asignatura[] nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombreAlumno=" + nombreAlumno + ", nota=" + nota + ", max=" + max + '}';
    }

    public void establecerNota() {
        Scanner entrada = new Scanner(System.in);
        boolean repetir = false;
        String[] asignaturas = {"Lengua", "Mates", "Historia", "Fisica"};
        System.out.println("Introduzca el nombre del alumno: ");
        setNombreAlumno(entrada.next());
        for (int i = 0; i < nota.length; i++) {
            nota[i].setNombreAsignatura(asignaturas[i]);

            System.out.println("Introduzca la nota del alumno " + nombreAlumno + " para la asignatura " + nota[i].getNombreAsignatura() + ".");
            do {
                nota[i].setNota(entrada.nextFloat());
                if (nota[i].getNotaAsignatura() < 0.0 || nota[i].getNotaAsignatura() > 10) {
                    repetir = true;
                    System.out.println("La nota introducida debe ser entre 0 y 10.");

                } else {
                    repetir = false;
                }

            } while (repetir);

        }
    }

    public void mostrarNota() {

        for (Asignatura i : nota) {
            System.out.println("La nota del alumno " + nombreAlumno + " en la asignatura " + i.getNombreAsignatura() + " es " + i.getNotaAsignatura());
        }

    }

    public float obtenerMedia() {
        float notaMedia = 0.0f;
        for (Asignatura i : nota) {
            notaMedia += i.getNotaAsignatura();
        }
        notaMedia /= nota.length;
        return notaMedia;

    }

    public int numeroSuspensos() {
        int suspensos = 0;

        for (Asignatura i : nota) {
            if (i.getNotaAsignatura() < 5.0f) {
                suspensos++;

            }
        }

        return suspensos;

    }

    public float asignaturaPosicion(int posicion) {

        return this.nota[posicion].getNotaAsignatura();

    }

}
