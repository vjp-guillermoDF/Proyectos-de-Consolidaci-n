/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.complejos;

/**
 *
 * @author alumno
 */
public class Operaciones {
    
    public Complejos suma(Complejos a, Complejos b) {
        float r;
        float im;

        r = a.partereal() + b.partereal();
        im = a.parteimaginaria() + b.parteimaginaria();
        Complejos c = new Complejos(r, im);

        return c;
    }

    public Complejos resta(Complejos a, Complejos b) {
        float r;
        float im;

        r = a.partereal() - b.partereal();
        im = a.parteimaginaria() - b.parteimaginaria();

        Complejos c = new Complejos(r, im);

        return c;
    }

    public Complejos multiplicar(Complejos a, Complejos b) {
        float r;
        float im;

        r = a.partereal() * b.partereal() - a.parteimaginaria() * b.parteimaginaria();
        im = a.partereal() * b.parteimaginaria() - b.partereal() * a.parteimaginaria();

        Complejos c = new Complejos(r, im);

        return c;
    }

    public Complejos dividir(Complejos a, Complejos b) {
        float r;
        float im;
        float d = b.partereal() * b.partereal() + b.parteimaginaria() * b.parteimaginaria();

        r = a.partereal() * b.partereal() + a.parteimaginaria() * b.parteimaginaria();
        im = a.partereal() * b.parteimaginaria() - b.partereal() * a.parteimaginaria();
        r = r / d;
        im = im / d;

        Complejos c = new Complejos(r, im);

        return c;
    }
    
}
