package lankaohjelma.perusluokat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lankaohjelma.perusluokat.Kangas;
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
public class KangasTest {
    
    public KangasTest() {
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
        
        Kangas kangas = new Kangas();
        System.out.println(kangas); 
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {    
        
       new Kangas(10, "Aida");            
    }
}
