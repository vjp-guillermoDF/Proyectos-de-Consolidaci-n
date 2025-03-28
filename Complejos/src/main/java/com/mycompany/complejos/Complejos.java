/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.complejos;

import java.lang.Math;

/**
 *
 * @author Abel
 */
public class Complejos {

    private float real;
    private float imaginario;

    public Complejos(float a, float b) {
        real = a;
        imaginario = b;
    }

    public float partereal() {
        return this.real;
    }

    public float parteimaginaria() {
        return this.imaginario;
    }

    public boolean imaginariopuro() {
        return (this.imaginario == 0);
    }

    public boolean realpuro() {
        return (this.real == 0);
    }

    public String Escribircomlejo() {
        if (this.real >= 0) {
            System.out.println(this.imaginario + "+" + this.real + "i");
            return (this.imaginario + "+" + this.real + "i");
        } else {
            System.out.println(this.imaginario + "" + this.real + "i");
            return (this.imaginario + "" + this.real + "i");
        }
    }

    public float modulo() {
        float mod = (float) Math.sqrt(this.real * this.real + this.imaginario * this.imaginario);
        return mod;
    }

    public float fase() {
        float arco;
        arco = (float) Math.atan(this.real / (this.imaginario));
        return arco;
    }

    public void conjugado() {
        this.real = (-1) * this.real;
    }

    public static void main(String[] args) {
// TODO code application logic here
        Complejos z1 = new Complejos(-3, 4);
        z1.Escribircomlejo();
    }
}
