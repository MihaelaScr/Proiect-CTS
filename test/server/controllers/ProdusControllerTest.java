/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controllers;

import beans.Produs;
import exceptions.MyNullPointerException;
import java.io.BufferedReader;
import java.io.FileReader;
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
public class ProdusControllerTest {
    static ProdusController pc = null;
    
    
    public ProdusControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {    
        try {        
            pc = new ProdusController(DriverManager.getConnection("jdbc:mysql://localhost/proiectjava","root",""));
        } catch (Exception ex) {
            Logger.getLogger(ProdusControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        DriverManager.getConnection("jdbc:mysql://localhost/proiectjava","root","").close();
    }

    /**
     * Test of adaugaProdus method, of class ProdusController.
     */
    @Test
    public void testAdaugaProdus() throws SQLException, MyNullPointerException {
            ArrayList<Produs> lista = pc.getProduse();
            Produs p = new Produs("prod2", 5.5);
            pc.adaugaProdus(p.getDenumire(), p.getPret());
            p.setId(pc.getProduse().get(lista.size()).getId());
            lista.add(p);
            assertEquals("testare adaugaProdus", lista, pc.getProduse());
    }
    
    /**
     * Test of adaugaProdus method, of class ProdusController.
     */
    @Test
    public void testAdaugaProdusNegative() throws SQLException, MyNullPointerException {
            ArrayList<Produs> lista = pc.getProduse();
            Produs p = new Produs("prod2", -9.5);
            pc.adaugaProdus(p.getDenumire(), p.getPret());
            p.setId(pc.getProduse().get(lista.size()).getId());
            p.setPret(0);
            lista.add(p);
            assertEquals("testare adaugaProdus", lista, pc.getProduse());
    }
    
    /**
     * Test of adaugaProdus method, of class ProdusController.
     */
    @Test
    public void testAdaugaProdusNull() throws SQLException {
            try{
                pc.adaugaProdus(null, null);
                fail();
            }catch(MyNullPointerException e){
            }
    }
    
    /**
     * Test of stergeProdus method, of class ProdusController.
     */
    @Test
    public void teststergeProdus() throws SQLException, MyNullPointerException{
            ArrayList<Produs> lista = pc.getProduse();
            Produs p = lista.get(lista.size() - 1);
            pc.stergeProdus(p);
            lista.remove(p);
            assertEquals("testare stergeProdus", lista, pc.getProduse());
    }

    /**
     * Test of stergeProdus method, of class ProdusController.
     */
    @Test
    public void teststergeProdusNull() throws SQLException{
        try {
            pc.stergeProdus(null);
            fail();
        } catch (MyNullPointerException ex) {
        }
    }
    
    /**
     * Test of stergeProdus method, of class ProdusController.
     */
    @Test
    public void teststergeProdusNegative() throws SQLException, MyNullPointerException{
            Produs p = new Produs(-2, "prod4", 77);            
            ArrayList<Produs> lista = pc.getProduse();
            pc.stergeProdus(p);
            assertEquals("testare stergeProdus", lista, pc.getProduse());
    }
    
}
