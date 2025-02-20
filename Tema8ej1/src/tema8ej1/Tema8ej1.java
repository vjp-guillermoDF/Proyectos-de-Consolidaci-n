/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej1;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema8ej1 {

    private static final Asignaturas[] tablaAsignaturas = new Asignaturas[6];

    public static float notaMedia(Asignaturas asignaturas[]) {
        float suma = 0.0f;
        float media;
        for (int i = 0; i < asignaturas.length; i++) {

            suma += asignaturas[i].getNota();

        }
        media = suma / asignaturas.length;

        return media;

    }

    public static void crearTablaNota(Asignaturas asignaturas[]) {

        String[] nombres = {"Programacion", "Lenguaje de Marcas", "Bases de Datos", "Entornos de Desarrollo", "Sistemas Informaticos", "IPE"};
        for (int i = 0; i < asignaturas.length; i++) {

            System.out.println("Introduce la nota de " + nombres[i] + ":");
            asignaturas[i] = new Asignaturas(nombres[i], pedirEscaner());

        }

    }

    public static float pedirEscaner() {
        Scanner entrada = new Scanner(System.in);

        return entrada.nextFloat();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        crearTablaNota(tablaAsignaturas);
        System.out.println("La nota media es " + notaMedia(tablaAsignaturas));

    }

}
