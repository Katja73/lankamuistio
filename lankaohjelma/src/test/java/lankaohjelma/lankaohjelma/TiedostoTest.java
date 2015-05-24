/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

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
 * @author Katja
 */
public class TiedostoTest {
    
    public TiedostoTest() {
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
     * Testataan tiedostoon tallennus
     */
    @Test
    public void TestaaTiedostonTallennus()
    { Tiedosto tiedosto = new Tiedosto();
    String tiedostonNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testi.txt";
    ArrayList lista = new ArrayList();
    lista.add("testi1");
    lista.add("testi2");
    
        try {
            tiedosto.Tallenna(tiedostonNimi, lista);
        } catch (Exception ex) {
            Logger.getLogger(TiedostoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * Testataan tiedostoon tallennus siten, että Arraylistillä on useita tiedostoja
     */
    @Test
    public void TestaaTiedostonTallennusUsempi()
    { Tiedosto tiedosto = new Tiedosto();
    String tiedostonNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testi2.txt";
    ArrayList<Lanka> lista = new ArrayList();
    lista.add(new Lanka(1, 555, "DMC"));
    lista.add(new Lanka(2, 365, "DMC"));
    lista.add(new Lanka(3, 444, "Anchor"));
    
        try {
            tiedosto.Tallenna(tiedostonNimi, lista);
        } catch (Exception ex) {
            Logger.getLogger(TiedostoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 @Test
 public void TestaaTiedostonLataus()
 {
     Tiedosto tiedosto = new Tiedosto();
     
     String tiedostonNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testi2.txt";
    
     
        try {
         ArrayList ladattuTiedosto = tiedosto.LataaTiedosto(tiedostonNimi);
          System.out.println("Testilista: "+ladattuTiedosto);
          
        } catch (Exception ex) {
            Logger.getLogger(TiedostoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
                
 }
}
