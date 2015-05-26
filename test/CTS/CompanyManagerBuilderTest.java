/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CTS;

import beans.Magazin;
import beans.Produs;
import beans.RandProdus;
import exceptions.MyNullPointerException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CompanyManagerBuilderTest {
    ArrayList<RandProdus> lista1;
    ArrayList<Produs> lista2;
    ArrayList<Magazin> lista3;
    
    static FileReader reader;
    static BufferedReader bf;
    
    public CompanyManagerBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            reader = new FileReader("dateDeTest.txt");
            bf = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompanyManagerBuilderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        bf.close();
	reader.close();
    }
    
    @Before
    public void setUp() {
        lista1 = new ArrayList<RandProdus>();
        lista2 = new ArrayList<Produs>();
        lista3 = new ArrayList<Magazin>();
    }

    /**
     * Test of setComenzi method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetComenziNormal() throws MyNullPointerException {
        try{
            String linie = null;
            int i = 0;
            RandProdus p = null;
            while((linie = bf.readLine()) != null && linie.length() != 0 && i < 3){
                    i++;                    
                    p = new RandProdus(Integer.valueOf(linie.split(" ")[0]), 
                            new Produs(linie.split(" ")[1], Double.valueOf(linie.split(" ")[2])), new Magazin());
                    lista1.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
		e.printStackTrace();
	}
        
//        RandProdus p1 = new RandProdus(-20, new Produs("ciocolata", -12.4), new Magazin());
//        RandProdus p2 = new RandProdus(10, new Produs("bere", -10.5), new Magazin());
//        RandProdus p3 = new RandProdus(8, new Produs("covrig", 8), new Magazin());
//        lista1.add(p3); lista1.add(p1); lista1.add(p2);
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setComenzi(lista1).build();
        assertEquals("testare SetComenzi", lista1, cm.getListaComenzi());
    }
    
    /**
     * Test of setComenzi method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetComenziEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setComenzi(lista1).build();
        assertEquals("testare SetComenzi", lista1, cm.getListaComenzi());
    }
    
    /**
     * Test of setComenzi method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetComenziNullValue() throws MyNullPointerException {
        lista1.add(null); lista1.add(null); lista1.add(null);
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setComenzi(lista1).build();
        assertEquals("testare SetComenzi", lista1, cm.getListaComenzi());
    }
    
    /**
     * Test of setComenzi method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetComenziNull() {
        CompanyManagerBuilder cm = new CompanyManagerBuilder("nicoleta", 11);
        try{
            cm.setComenzi(null);
            fail();
        }catch(MyNullPointerException e){
            
        }
    }

    /**
     * Test of setProduse method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetProduseNormal() throws MyNullPointerException {     
        Produs p1 = new Produs("produs1", -21);
        Produs p2 = new Produs("produs2", 12);
        Produs p3 = new Produs("produs3", -2342);
        Produs p4 = new Produs("produs4", 6);
        lista2.add(p1); lista2.add(p2); lista2.add(p3); lista2.add(p4);
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setProduse(lista2).build();
        assertEquals("testare SetProduse", lista2, cm.getListaProduse());
    }
    
    /**
     * Test of setProduse method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetProduseEmpty() throws MyNullPointerException {  
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setProduse(lista2).build();
        assertEquals("testare SetProduse", lista2, cm.getListaProduse());
    }
    
    /**
     * Test of setProduse method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetProduseNullValue() throws MyNullPointerException {  
        lista2.add(null); lista2.add(null); lista2.add(null);
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setProduse(lista2).build();
        assertEquals("testare SetProduse", lista2, cm.getListaProduse());
    }
    
    /**
     * Test of setProduse method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetProduseNull() {        
        CompanyManagerBuilder cm = new CompanyManagerBuilder("nicoleta", 11);
        try{
            cm.setProduse(null);
            fail();
        }catch(MyNullPointerException e){
            
        }
    }

    /**
     * Test of setMagazine method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetMagazineNormal() throws MyNullPointerException {
        
        Magazin m1 = new Magazin("magazin1", "adresa1");
        Magazin m2 = new Magazin("amagazin2", "adresa2");
        Magazin m3 = new Magazin("Amagazin3", "adresa3");
        Magazin m4 = new Magazin("Amagazin4", "adresa4");
        lista3.add(m1); lista3.add(m2); lista3.add(m3); lista3.add(m4);
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        assertEquals("testare SetProduse", lista3, cm.getListaMagazine());
    }
    
    /**
     * Test of setMagazine method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetMagazineEmpty() throws MyNullPointerException {
        CompanyManager cm = new CompanyManagerBuilder("manager1", 3).setMagazine(lista3).build();
        assertEquals("testare SetProduse", lista3, cm.getListaMagazine());
    }
    
    /**
     * Test of setMagazine method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetMagazineNullValues() throws MyNullPointerException {
        lista3.add(null); lista3.add(null); lista3.add(null);
        CompanyManager cm = new CompanyManagerBuilder("nicoleta", 11).setMagazine(lista3).build();
        assertEquals("testare SetProduse", lista3, cm.getListaMagazine());
    }
    
    /**
     * Test of setMagazine method, of class CompanyManagerBuilder.
     */
    @Test
    public void testSetMagazineNull() {
        CompanyManagerBuilder cm = new CompanyManagerBuilder("nicoleta", 11);
        try{
            cm.setMagazine(null);
            fail();
        }catch(MyNullPointerException e){
            
        }
    }
}
