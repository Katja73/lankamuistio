/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;
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
public class RistipistoTyoTest {
    
    public RistipistoTyoTest() {
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
        
        // luodaan ristipistotyo oletuskonstruktorilla
        RistipistoTyo oletusTyo = new RistipistoTyo();
        // ja tulostetaan se 
        System.out.println(oletusTyo);
      
    }
    
    /**
     * Testataan parametrikonstruktori antamalla tietoja
     */
   // @Test
    public void TestaaparametriKonstruktori() {
        
        // Syötetään testitiedot
        ArrayList<TyonLanka> langat = null;        
        langat.add(1, null);       
        
        Kangas kangas = new Kangas();
        Kayttaja kayttaja = new Kayttaja();
        int leveys = 10;
        int korkeus = 5;       
        
        RistipistoTyo oletusTyo = new RistipistoTyo(langat, kangas, kayttaja, leveys, korkeus);
        
        // ja tulostetaan se 
        System.out.println(oletusTyo);
      
    }
    
}
