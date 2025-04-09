/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema11ej09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Sorteo {

    private LocalDate sorteo;

    private int[] ganadores;

    public Sorteo(LocalDate sorteo, int[] ganadores) {
        this.sorteo = sorteo;
        this.ganadores = ganadores;
    }

    public Sorteo() {
        this.sorteo = LocalDate.now();
        this.ganadores = new int[4];

    }

    public LocalDate getSorteo() {
        return sorteo;
    }

    public void setSorteo(LocalDate sorteo) {
        this.sorteo = sorteo;
    }

    public int[] getGanadores() {
        return ganadores;
    }

    public void setGanadores(int[] ganadores) {
        this.ganadores = ganadores;
    }

    @Override
    public String toString() {

        String gan = "";

        for (int i = 0; i < ganadores.length; i++) {

            gan += " " + ganadores[i];

        }

        return "Sorteo: " + sorteo + ". Ganadores: " + gan + ".";
    }

    public int[] introducirGanadores() {
        
        int[] aux = new int[ganadores.length];

        for (int i = 0; i < aux.length; i++) {
            int aleatorio = (int) (Math.random() * 100) + 1;
            aux[i] = aleatorio;
        }

        setGanadores(aux);
        return ganadores;

    }

    public LocalDate asignarFechaPorUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce la fecha del sorteo (formato yyyy-MM-dd): ");
        String respuesta = entrada.nextLine();
        setSorteo(LocalDate.parse(respuesta, DateTimeFormatter.ISO_LOCAL_DATE));
        return this.sorteo;

    }

}
