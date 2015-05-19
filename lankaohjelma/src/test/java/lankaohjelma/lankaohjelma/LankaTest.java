/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja
 */
public class LankaTest {
    
    public LankaTest() {
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
     * Testataan oletuskonstruktori
     */
    @Test
    public void TestaaOletuskonstruktori() {
    
       Lanka oletusLanka = new Lanka();      
       System.out.println(oletusLanka);    
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {
    
       Lanka lanka = new Lanka(1, 365, "DMC");      
       System.out.println(lanka);    
    }
    
    @Test
    public void TestaaKonstruktoriGetterit()
    {
        Lanka lanka = new Lanka(2, 368, "DMC");
        int lankaid = lanka.getLankaid();
        int lankanro = lanka.getLankanro();
        String lankaMerkki = lanka.getMerkki();
        
        assertEquals(2, lankaid);
        assertEquals(368, lankanro);
        assertEquals("DMC", lankaMerkki);        
    }
}
