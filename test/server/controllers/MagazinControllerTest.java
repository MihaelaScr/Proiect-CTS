/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controllers;

import beans.Magazin;
import beans.Produs;
import exceptions.MyNullPointerException;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class MagazinControllerTest {
    static MagazinController mc = null;
    
    public MagazinControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            mc = new MagazinController(DriverManager.getConnection("jdbc:mysql://localhost/proiectjava","root",""));
        } catch (SQLException ex) {
            Logger.getLogger(ProdusControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        DriverManager.getConnection("jdbc:mysql://localhost/proiectjava","root","").close();
    }

    /**
     * Test of adaugaMagazin method, of class MagazinController.
     */
    @Test
    public void testAdaugaMagazin() throws SQLException, MyNullPointerException { //!!!!!!!!!!!!!!!
            ArrayList<Magazin> lista = mc.getMagazin();
            Magazin m = new Magazin("mag13", "adr13");
            mc.adaugaMagazin(m.getNume(), m.getAdresa());
            m.setId(mc.getMagazin().get(lista.size()).getId());
            lista.add(m);
            assertEquals("testare adaugaMagazin", lista, mc.getMagazin());
    }
    
    /**
     * Test of adaugaMagazin method, of class MagazinController.
     */
    @Test
    public void testAdaugaMagazinNull() throws SQLException, MyNullPointerException {
        try{
            mc.adaugaMagazin(null, null);
            fail();
        }catch(MyNullPointerException e){
        }
    }

    /**
     * Test of getMagazinByNume method, of class MagazinController.
     */
    @Test
    public void testGetMagazinByNumeAdresa() throws MyNullPointerException{
        ArrayList<Magazin> lista = mc.getMagazin();
        Magazin m = null;
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getNume().equals("mag1") && lista.get(i).getAdresa().equals("adr1")){
                m = lista.get(i);
            }
        }
        assertEquals("testare getMagazinByNumeAdresa", m, mc.getMagazinByNumeAdresa("mag1", "adr1"));
    }
    
    /**
     * Test of getMagazinByNume method, of class MagazinController.
     */
    @Test
    public void testGetMagazinByNumeAdresaNull() {
        try{
            mc.getMagazinByNumeAdresa(null, null);
            fail();
        }catch(MyNullPointerException e){
        }
    }
    
    /**
     * Test of modificaMagazin method, of class MagazinController.
     */
    @Test
    public void testModificaMagazin() throws SQLException, MyNullPointerException {  //!!!!!!!!!!!!!!!
            Magazin mag = mc.getMagazinByNumeAdresa("ceva", "ceva2");
            mc.modificaMagazin(mag.getId(), "cevaModificat", "ceva2Modificat");
            mag.setAdresa("ceva2Modificat");
            mag.setNume("cevaModificat");
            assertEquals("testare modificaMagazin", mag, mc.getMagazinByNumeAdresa("cevaModificat", "ceva2Modificat"));
    }
    
    /**
     * Test of modificaMagazin method, of class MagazinController.
     */
    @Test
    public void testModificaMagazinNull() throws SQLException, MyNullPointerException {
            Magazin mag = mc.getMagazinByNumeAdresa("mag1", "adr1");
            try{
                mc.modificaMagazin(mag.getId(), null, null);
                fail();
            }catch(MyNullPointerException e){
            }
    }
    
    /**
     * Test of stergeMagazin method, of class MagazinController.
     */
    @Test
    public void teststergeMagazin() throws SQLException, MyNullPointerException {  //!!!!!!!!!!!!!!!
            ArrayList<Magazin> lista = mc.getMagazin();
            Magazin m = lista.get(lista.size() - 1);
            mc.stergeMagazin(m.getNume(), m.getAdresa());
            lista.remove(m);
            assertEquals("testare stergeMagazin", lista, mc.getMagazin());
    }
    
    /**
     * Test of stergeMagazin method, of class MagazinController.
     */
    @Test
    public void teststergeMagazinNull() throws SQLException, MyNullPointerException { 
        try{
            mc.stergeMagazin(null, null);
            fail();
        }catch(MyNullPointerException e){
        }
    }
    
    /**
     * Test of getMagazinByNume method, of class MagazinController.
     */
    @Test
    public void testGetMagazinById() throws MyNullPointerException{
        ArrayList<Magazin> lista = mc.getMagazin();
        Magazin m = null;
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getId() == 1) {
                m = lista.get(i);
            }
        }
        assertEquals("testare getMagazinById", m, mc.getMagazin(1));
    }
    
    /**
     * Test of getMagazinByNume method, of class MagazinController.
     */
    @Test
    public void testGetMagazinByIdNegative() throws MyNullPointerException{
        assertEquals("testare getMagazinById", null, mc.getMagazin(-6));
    }
}
