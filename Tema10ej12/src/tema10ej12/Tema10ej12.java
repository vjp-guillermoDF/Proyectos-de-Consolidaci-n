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
        int i = 0;
        boolean cerrar = false;

        System.out.println("Comenzamos a llenar la lista.");
        do {
            lista.add(entrada.next());
            System.out.println("Nombre añadido en la posicion " + i + ".");

            System.out.println("¿Desea continuar?");
            respuesta = entrada.next();

            if (!respuesta.equalsIgnoreCase("Si") || !respuesta.equalsIgnoreCase("No")) {
                System.out.println("La respuesta debe ser sí o no.");
                entrada.next();
            } else if (!respuesta.equalsIgnoreCase("No")) {
                cerrar = true;
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
