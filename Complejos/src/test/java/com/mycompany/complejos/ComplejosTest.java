/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.complejos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alumno
 */
public class ComplejosTest {
    
    public ComplejosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of partereal method, of class Complejos.
     */
    @Test
    public void testPartereal() {
        System.out.println("partereal");
        Complejos instance = null;
        float expResult = 0.0F;
        float result = instance.partereal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parteimaginaria method, of class Complejos.
     */
    @Test
    public void testParteimaginaria() {
        System.out.println("parteimaginaria");
        Complejos instance = null;
        float expResult = 0.0F;
        float result = instance.parteimaginaria();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imaginariopuro method, of class Complejos.
     */
    @Test
    public void testImaginariopuro() {
        System.out.println("imaginariopuro");
        Complejos instance = null;
        boolean expResult = false;
        boolean result = instance.imaginariopuro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realpuro method, of class Complejos.
     */
    @Test
    public void testRealpuro() {
        System.out.println("realpuro");
        Complejos instance = null;
        boolean expResult = false;
        boolean result = instance.realpuro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Escribircomlejo method, of class Complejos.
     */
    @Test
    public void testEscribircomlejo() {
        System.out.println("Escribircomlejo");
        Complejos instance = null;
        instance.Escribircomlejo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modulo method, of class Complejos.
     */
    @Test
    public void testModulo() {
        System.out.println("modulo");
        Complejos instance = null;
        float expResult = 0.0F;
        float result = instance.modulo();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fase method, of class Complejos.
     */
    @Test
    public void testFase() {
        System.out.println("fase");
        Complejos instance = null;
        float expResult = 0.0F;
        float result = instance.fase();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjugado method, of class Complejos.
     */
    @Test
    public void testConjugado() {
        System.out.println("conjugado");
        Complejos instance = null;
        instance.conjugado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Complejos.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Complejos.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
