package testSuite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import server.controllers.MagazinControllerTest;
import server.controllers.ProdusControllerTest;

/**
 *
 * @author Miha
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    MagazinControllerTest.class,
    ProdusControllerTest.class
})
public class NewTestSuite {

}
