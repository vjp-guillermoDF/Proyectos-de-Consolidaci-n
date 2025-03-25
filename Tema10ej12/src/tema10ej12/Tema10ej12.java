/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej12 {

    /**
     * @param args the command line arguments
     */
    public static void iterarLista(ArrayList<String> lista) {
        Iterator<String> it = lista.iterator();
        int i = 0;
        while (it.hasNext()) {
            String aux = it.next();
            System.out.println(i + ") " + aux);
            i++;
        }

    }

    public static void llenarLista(ArrayList<String> lista) {
        Scanner entrada = new Scanner(System.in);
        String respuesta = "";
        String nombre = "";
        int i = 0;
        boolean cerrar = false;

        System.out.println("Comenzamos a llenar la lista.");
        nombre = entrada.next();

        lista.add(nombre);
        System.out.println("Nombre añadido en la posicion " + i + ".");
        do {
            System.out.println("¿Desea continuar?");
            respuesta = entrada.next();

            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Introduzca otro nombre:");
                lista.add(entrada.next());
                System.out.println("Nombre añadido en la posicion " + i + ".");
            } else if (respuesta.equalsIgnoreCase("No")) {
                cerrar = true;
            } else {
                System.out.println("La respuesta debe ser si o no.");
            }

            i++;
        } while (!cerrar);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> lista = new ArrayList();
        llenarLista(lista);
        iterarLista(lista);

    }

}
