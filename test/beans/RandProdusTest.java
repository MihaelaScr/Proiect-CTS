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
public class RandProdusTest {
    
    public RandProdusTest() {
    }

    /**
     * Test of the constructor of class RandProdus.
     */
    @Test
    public void testConstructorPositive() {
        Produs p = new Produs();
        Magazin m = new Magazin();
        RandProdus rp = new RandProdus(1, p, m);
        assertEquals("testare constructor clasa RandProdus numere pozitive", 1, rp.getCantitate());
    }
    
    @Test
    public void testConstructorNegative() {
        Produs p = new Produs();
        Magazin m = new Magazin();
        RandProdus rp = new RandProdus(-10, p, m);
        assertEquals("testare constructor clasa RandProdus numere negative", 0, rp.getCantitate());
    }
}
