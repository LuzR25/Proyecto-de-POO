/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmccl
 */
public class ControladorClienteTest {

    public ControladorClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of obtCliente method, of class ControladorCliente.
     */
    @Test
    public void testObtCliente() {
        System.out.println("obtCliente");
        ArrayList<Cliente> listaClientes = null;
        Integer id = null;
        ControladorCliente instance = null;
        Cliente expResult = null;
        Cliente result = instance.obtCliente(listaClientes, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarCliente method, of class ControladorCliente.
     */
    @Test
    public void testAgregarCliente() {
        System.out.println("agregarCliente");
        VistaCliente vista = new VistaCliente();
        VistaLibro vistaL = new VistaLibro();
        ControladorLibro Libro = new ControladorLibro(vistaL);
        ControladorCliente instance = new ControladorCliente(vista, Libro);
        Integer expResult = 0;
        Integer result = instance.agregarCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
