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
 * @author guill
 */
public class OperacionesTest {
    
    public OperacionesTest() {
    }

    
    /**
     * Test of suma method, of class Operaciones.
     */
    @org.junit.jupiter.api.Test
    public void testSuma() {
        System.out.println("suma");
        Complejos a = new Complejos(3,4);
        Complejos b = new Complejos(3,4);
        Operaciones instance = new Operaciones();
        Complejos expResult = new Complejos (6,8);
        Complejos result = instance.suma(a, b);
        assertEquals(expResult.partereal(), result.partereal());
         assertEquals(expResult.parteimaginaria(), result.parteimaginaria());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resta method, of class Operaciones.
     */
    @org.junit.jupiter.api.Test
    public void testResta() {
        System.out.println("resta");
        Complejos a = null;
        Complejos b = null;
        Operaciones instance = new Operaciones();
        Complejos expResult = null;
        Complejos result = instance.resta(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiplicar method, of class Operaciones.
     */
    @org.junit.jupiter.api.Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        Complejos a = null;
        Complejos b = null;
        Operaciones instance = new Operaciones();
        Complejos expResult = null;
        Complejos result = instance.multiplicar(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dividir method, of class Operaciones.
     */
    @org.junit.jupiter.api.Test
    public void testDividir() {
        System.out.println("dividir");
        Complejos a = null;
        Complejos b = null;
        Operaciones instance = new Operaciones();
        Complejos expResult = null;
        Complejos result = instance.dividir(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
