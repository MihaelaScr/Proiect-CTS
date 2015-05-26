/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CTS;

import beans.Magazin;
import beans.Produs;
import beans.RandProdus;
import exceptions.MyNullPointerException;
import java.util.ArrayList;
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
public class CompanyManagerTest {
    ArrayList<RandProdus> lista1;
    ArrayList<Produs> lista2;
    ArrayList<Magazin> lista3;
    
    public CompanyManagerTest() {
    }
    
    @Before
    public void setUp() {
        lista1 = new ArrayList<RandProdus>();
        lista2 = new ArrayList<Produs>();
        lista3 = new ArrayList<Magazin>();
    }
    

    /**
     * Test of maxValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMaxValueComandaPositive() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(20, new Produs("ciocolata", 12.4), new Magazin());
        RandProdus p2 = new RandProdus(10, new Produs("bere", 10.5), new Magazin());
        RandProdus p3 = new RandProdus(8, new Produs("covrig", 7.6), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 248.0, cm.maxValueComanda(), 0);
    }
    
    /**
     * Test of maxValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMaxValueComandaNegative() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(-20, new Produs("ciocolata", -12.4), new Magazin());
        RandProdus p2 = new RandProdus(-10, new Produs("bere", -10.5), new Magazin());
        RandProdus p3 = new RandProdus(-8, new Produs("covrig", -7.6), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 0, cm.maxValueComanda(), 0);
    }
    
    /**
     * Test of maxValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMaxValueComandaPosNeg() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(-20, new Produs("ciocolata", -12.4), new Magazin());
        RandProdus p2 = new RandProdus(10, new Produs("bere", -10.5), new Magazin());
        RandProdus p3 = new RandProdus(8, new Produs("covrig", 8), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 64, cm.maxValueComanda(), 0);
    }  
    
    /**
     * Test of maxValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMaxValueComandaEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 0, cm.maxValueComanda(), 0);
    }
    
    /**
     * Test of maxValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMaxValueComandaNullValue() throws MyNullPointerException {
        lista1.add(null); lista1.add(null); lista1.add(null); lista1.add(null);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        try{
            cm.maxValueComanda();
            fail();
        }catch(MyNullPointerException e){
            
        }
    }    

    /**
     * Test of minValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMinValueComandaPositive() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(20, new Produs("ciocolata", 12.4), new Magazin());
        RandProdus p2 = new RandProdus(10, new Produs("bere", 10.5), new Magazin());
        RandProdus p3 = new RandProdus(8, new Produs("covrig", 7.5), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 60, cm.minValueComanda(), 0);
    }
    
    /**
     * Test of minValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMinValueComandaNegative() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(-20, new Produs("ciocolata", -12.4), new Magazin());
        RandProdus p2 = new RandProdus(10, new Produs("bere", -10.5), new Magazin());
        RandProdus p3 = new RandProdus(8, new Produs("covrig", 8), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 0, cm.minValueComanda(), 0);
    }
    
    /**
     * Test of minValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMinValueComandaPosNeg() throws MyNullPointerException {
        RandProdus p1 = new RandProdus(-20, new Produs("ciocolata", -12.4), new Magazin());
        RandProdus p2 = new RandProdus(10, new Produs("bere", -10.5), new Magazin());
        RandProdus p3 = new RandProdus(8, new Produs("covrig", 8), new Magazin());
        lista1.add(p3);
        lista1.add(p1);
        lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 0, cm.minValueComanda(), 0);
    }
    
    /**
     * Test of minValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMinValueComandaEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        assertEquals("testare maxValueComanda", 0, cm.minValueComanda(), 0);
    }
    
    /**
     * Test of minValueComanda method, of class CompanyManager.
     */
    @Test
    public void testMinValueComandaNullValue() throws MyNullPointerException {
        lista1.add(null); lista1.add(null); lista1.add(null); lista1.add(null);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setComenzi(lista1).build();
        try{
            cm.minValueComanda();
            fail();
        }catch(NullPointerException e){
            
        }
    }

    /**
     * Test of maxProduct method, of class CompanyManager.
     */
    @Test
    public void testMaxProductPositive() throws MyNullPointerException {
        Produs p1 = new Produs("produs1", 21);
        Produs p2 = new Produs("produs2", 12);
        Produs p3 = new Produs("produs3", 2342);
        Produs p4 = new Produs("produs4", 6);
        lista2.add(p1); lista2.add(p2); lista2.add(p3); lista2.add(p4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setProduse(lista2).build();
        assertEquals("testare maxProduct", 2342, cm.maxProduct(), 0);
    }
    
    /**
     * Test of maxProduct method, of class CompanyManager.
     */
    @Test
    public void testMaxProductNegative() throws MyNullPointerException {
        Produs p1 = new Produs("produs1", -21);
        Produs p2 = new Produs("produs2", -12);
        Produs p3 = new Produs("produs3", -2342);
        Produs p4 = new Produs("produs4", -6);
        lista2.add(p1); lista2.add(p2); lista2.add(p3); lista2.add(p4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setProduse(lista2).build();
        assertEquals("testare maxProduct", 0, cm.maxProduct(), 0);
    }
    
    /**
     * Test of maxProduct method, of class CompanyManager.
     */
    @Test
    public void testMaxProductPosNeg() throws MyNullPointerException {
        Produs p1 = new Produs("produs1", -21);
        Produs p2 = new Produs("produs2", 12);
        Produs p3 = new Produs("produs3", -2342);
        Produs p4 = new Produs("produs4", 6);
        lista2.add(p1); lista2.add(p2); lista2.add(p3); lista2.add(p4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setProduse(lista2).build();
        assertEquals("testare maxProduct", 12, cm.maxProduct(), 0);
    }
    
    /**
     * Test of maxProduct method, of class CompanyManager.
     */
    @Test
    public void testMaxProductEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setProduse(lista2).build();
        assertEquals("testare maxProduct", 0, cm.maxProduct(), 0);
    }
    
    /**
     * Test of maxProduct method, of class CompanyManager.
     */
    @Test
    public void testMaxProductNullValue() throws MyNullPointerException {
        lista2.add(null); lista2.add(null); lista2.add(null); lista2.add(null);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setProduse(lista2).build();
        try{
            cm.maxProduct();
            fail();
        }catch(NullPointerException e){
            
        }
    }
    
    /**
     * Test of getMagazinWithA method, of class CompanyManager.
     */
    @Test
    public void testGetMagazinWithAExist() throws MyNullPointerException{
        Magazin m1 = new Magazin("magazin1", "adresa1");
        Magazin m2 = new Magazin("amagazin2", "adresa2");
        Magazin m3 = new Magazin("Amagazin3", "adresa3");
        Magazin m4 = new Magazin("Amagazin4", "adresa4");
        lista3.add(m1); lista3.add(m2); lista3.add(m3); lista3.add(m4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        ArrayList<Magazin> vectorNou = new ArrayList<Magazin>();
        vectorNou.add(m3); vectorNou.add(m4);
        assertEquals("testare GetMagazinWithA", vectorNou, cm.getMagazinWithA());
    }
    
    /**
     * Test of getMagazinWithA method, of class CompanyManager.
     */
    @Test
    public void testGetMagazinWithANotExist() throws MyNullPointerException {
        Magazin m1 = new Magazin("magazin1", "adresa1");
        Magazin m2 = new Magazin("amagazin2", "adresa2");
        Magazin m3 = new Magazin("Bmagazin3", "adresa3");
        Magazin m4 = new Magazin("Cmagazin4", "adresa4");
        lista3.add(m1); lista3.add(m2); lista3.add(m3); lista3.add(m4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        assertEquals("testare GetMagazinWithA", new ArrayList<Magazin>(), cm.getMagazinWithA());
    }
    
    /**
     * Test of getMagazinWithA method, of class CompanyManager.
     */
    @Test
    public void testGetMagazinWithAEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        assertEquals("testare GetMagazinWithA", new ArrayList<Magazin>(), cm.getMagazinWithA());
    }
    
    /**
     * Test of getMagazinWithA method, of class CompanyManager.
     */
    @Test
    public void testGetMagazinWithANullValues() throws MyNullPointerException {
        lista3.add(null); lista3.add(null); lista3.add(null);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        try{
            cm.getMagazinWithA();
            fail();
        }catch(NullPointerException e){
            
        }
    }
}
