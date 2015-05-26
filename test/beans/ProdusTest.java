/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miha
 */
public class ProdusTest {
    
    public ProdusTest() {
    }
    

    /**
     * Test of the constructor of class Produs.
     */
    @Test
    public void testConstructorPositive() {
        Produs p = new Produs("produs1", 12);
        assertEquals("testare constructor clasa Produs numere pozitive", 12, p.getPret(),0);
    }
    
    @Test
    public void testConstructorNegative() {
        Produs p = new Produs("produs1", -12);
        assertEquals("testare constructor clasa Produs numere negative", 0, p.getPret(),0);
    }
}
