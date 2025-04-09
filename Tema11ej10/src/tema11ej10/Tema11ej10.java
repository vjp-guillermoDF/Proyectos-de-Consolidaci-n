/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author alumno
 */
public class Tema11ej10 {

    /**
     * @param args the command line arguments
     */
    public static void mostrarConjunto(Set<Persona> conjunto) {

        for (Persona i : conjunto) {
            System.out.println(i.toString());
        }

    }

    public static void mostrarLista(List<Persona> lista) {

        for (Persona i : lista) {
            System.out.println(i.toString());
        }
    }

    public static void mostrarMapa(Map<Integer, Persona> mapa) {
        Iterator it = mapa.keySet().iterator();
        while (it.hasNext()) {
            int clave = (int) it.next();

            Persona aux = mapa.get(clave);

            System.out.println(aux.toString());

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        //TREESET
        Set<Persona> conjunto = new TreeSet<Persona>();
        conjunto.add(new Persona("Quique", 38));
        conjunto.add(new Persona("Elena", 26));
        conjunto.add(new Persona("Alba", 33));
        conjunto.add(new Persona("Julian", 45));
        conjunto.add(new Persona("Martin", 7));

        System.out.println("Mostrando TreeSet");
        mostrarConjunto(conjunto);

        //HASHSET
        Set<Persona> conjuntoHash = new HashSet<Persona>();
        conjuntoHash.add(new Persona("Quique", 38));
        conjuntoHash.add(new Persona("Elena", 26));
        conjuntoHash.add(new Persona("Alba", 33));
        conjuntoHash.add(new Persona("Julian", 45));
        conjuntoHash.add(new Persona("Martin", 7));

        System.out.println("Mostrando HashSet");
        mostrarConjunto(conjuntoHash);

        //ARRAYLIST
        List<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona("Quique", 38));
        lista.add(new Persona("Elena", 26));
        lista.add(new Persona("Alba", 33));
        lista.add(new Persona("Julian", 45));
        lista.add(new Persona("Martin", 7));

        Collections.sort(lista);
        System.out.println("Mostrando ArrayList");
        mostrarLista(lista);

        //TREEMAP
        Map<Integer, Persona> mapa = new TreeMap<>();
        mapa.put(1, new Persona("Quique", 38));
        mapa.put(2, new Persona("Elena", 26));
        mapa.put(3, new Persona("Alba", 33));
        mapa.put(4, new Persona("Julian", 45));
        mapa.put(5, new Persona("Martin", 7)); //Se ordenan EN FUNCIÓN DE LA CLAVE, no de la edad

        System.out.println("Mostrando Mapa");
        mostrarMapa(mapa);

    }

}
