/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema10ej1 {

    public static void mostrarLista(ArrayList<String> lista) {

        if (lista.isEmpty()) {
            System.out.println("\nLa lista esta vacia.");
        } else {

            for (int i = 0; i < lista.size(); i++) {

                System.out.println((i + 1) + ")" + lista.get(i));
            }

        }
    }

    public static void llenarLista(ArrayList<String> lista) {
        Scanner entrada = new Scanner(System.in);

        boolean cerrar = false;
        String respuesta = "";
        int i = 0;

        System.out.println("Creando lista de nombres.\n");

        while (!cerrar) {

            System.out.println("¿Desea introducir un nombre?\n");
            respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Introduzca nombre: \n");
                lista.add(i, entrada.next());
                System.out.println("\nNombre " + lista.get(i) + " añadido.\n");
                i++;

            } else if (respuesta.equalsIgnoreCase("No")) {
                cerrar = true;
            } else {
                System.out.println("\nOpcion no permitida. Por favor, escriba si o no.\n");
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> lista = new ArrayList();

        llenarLista(lista);
        mostrarLista(lista);

    }

}
