/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej10;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Tema10ej10 {

    /**
     * @param args the command line arguments
     */
    public static int llenarLista(ArrayList<Asignatura> lista, String[] nombres) {

        int notaMax = 0;

        for (int i = 0; i < 6; i++) {

            lista.add(new Asignatura(nombres[i]));

            notaMax += lista.get(i).getNota();

        }

        System.out.println("La nota media es: ");

        return notaMax / lista.size();

    }

    public static void main(String[] args) {
        String[] nombres = {"Programacion", "Marcas", "Datos", "Entornos", "Sistemas", "IPE"};
        ArrayList<Asignatura> lista = new ArrayList();

        System.out.println(llenarLista(lista, nombres));
    }

}
