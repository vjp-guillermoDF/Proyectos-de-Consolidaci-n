/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.complejos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alumno
 */
public class ComplejosTest {

    /**
     * Test of partereal method, of class Complejos.
     */
    @Test
    void testPartereal() {
        //fail("Not yet implemented");

        // Crear un objeto complejo
        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        float esperado = 3.0F;
        float obtenido = C1.partereal();

        assertEquals(esperado, obtenido, 0);

    }

    /**
     * Test of parteimaginaria method, of class Complejos.
     */
    @Test
    void testParteimaginaria() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        float esperado = 4.0F;
        float obtenido = C1.parteimaginaria();

        assertEquals(esperado, obtenido, 0);

    }

    /**
     * Test of imaginariopuro method, of class Complejos.
     */
    @Test
    void testImaginariopuro() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        boolean esperado = false;
        boolean obtenido = C1.imaginariopuro();

        assertEquals(esperado, obtenido);

    }

    /**
     * Test of realpuro method, of class Complejos.
     */
    @Test
    void testRealpuro() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        boolean esperado = false;
        boolean obtenido = C1.realpuro();

        assertEquals(esperado, obtenido);

    }

    @Test
    void testEscribircomplejo() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        String esperado = "4.0+3.0i";
        String obtenido = C1.Escribircomlejo();

        assertEquals(esperado, obtenido);

    }

    @Test
    void testModulo() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        float esperado = 5.0F;
        float obtenido = C1.modulo();

        assertEquals(esperado, obtenido, 0);

    }

    @Test
    void testFase() {
        //fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        //Valor esperado y valor obtenido
        float esperado = 0.6435011F;
        float obtenido = C1.fase();

        assertEquals(esperado, obtenido, 0);

    }

    @Test
    void testConjugado() {
        //	fail("Not yet implemented");

        Complejos C1 = new Complejos(3, 4);

        C1.conjugado();

        float esperado = 4;
        float obtenido = C1.parteimaginaria();

        assertEquals(esperado, obtenido, 0);

    }

}
