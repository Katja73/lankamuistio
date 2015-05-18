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
public class TyonLankaTest {
    
    public TyonLankaTest() {
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
    
       TyonLanka oletusLanka = new TyonLanka();      
       System.out.println(oletusLanka);    
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {
        
      Lanka lanka = new Lanka();
      lanka.lankaid = 1;
      lanka.setLankanro(365);
      lanka.setMerkki("DMC"); 
    
      TyonLanka tlanka = new TyonLanka(5.2, lanka);      
      System.out.println(tlanka);    
    }
}
