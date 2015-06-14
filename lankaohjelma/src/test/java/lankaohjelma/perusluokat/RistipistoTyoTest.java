/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.perusluokat.RistipistoTyo;
import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.Kangas;
import java.util.ArrayList;
import lankaohjelma.lankaohjelma.TyonLanka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * RistipistoTyo -testit
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
        new RistipistoTyo();

      
    }
    
    /**
     * Testataan parametrikonstruktori antamalla tietoja
     */
    @Test
    public void TestaaparametriKonstruktori() {
        
        // Syötetään testitiedot
        ArrayList<TyonLanka> langat = null;  
        String nimi = "Testi";
        Kangas kangas = new Kangas();       
        int leveys = 10;
        int korkeus = 5;      
        
       new RistipistoTyo(1, nimi, langat, kangas, leveys, korkeus);    
      
    }
    
    /**
     * Testataan, palauttaako parametrikonstruktori oikein
     */
    @Test
   public void PalauttaakoParametriKonstruktoriOikein()
   {
        // Syötetään testitiedot
        ArrayList<TyonLanka> langat = null;          
        Kangas kangas = new Kangas();
        String nimi = "Testi";
        
        int leveys = 30;
        int korkeus = 45;       
        
        RistipistoTyo oletusTyo = new RistipistoTyo(1, nimi, langat, kangas, leveys, korkeus);
        int korkeus1 = oletusTyo.getKorkeus();
        int leveys1 = oletusTyo.getLeveys();
        
        assertEquals(45, korkeus1);
        assertEquals(30, leveys1);      
   }
   
    @Test
    public void TestaaEtsiRistipistoTyoLoytyy(){
        
        // Syötetään testitiedot
        ArrayList<TyonLanka> langat = null;        
        Kangas kangas = new Kangas();       
        int leveys = 10;
        int korkeus = 5;   
        String nimi = "Testi";
        
        RistipistoTyo ristipistoTyo = new RistipistoTyo(1, nimi, langat, kangas, leveys, korkeus);   
        ArrayList<RistipistoTyo> tyot = new ArrayList<RistipistoTyo>();
        tyot.add(ristipistoTyo);
        
        int etsittava;
        etsittava = 1;       
        
        RistipistoTyo etsiTyo = ristipistoTyo.etsiRistipistoTyo(tyot, etsittava);
        assertEquals(10, etsiTyo.getLeveys());       
    }
    
    @Test
    public void TestaaEtsiRistipistoTyoEiLoydy(){
    // Syötetään testitiedot
        ArrayList<TyonLanka> langat = null;        
        Kangas kangas = new Kangas();       
        int leveys = 10;
        int korkeus = 5;      
        String nimi = "Testi";
        
        RistipistoTyo ristipistoTyo = new RistipistoTyo(1, nimi, langat, kangas, leveys, korkeus);   
        ArrayList<RistipistoTyo> tyot = new ArrayList<RistipistoTyo>();
        tyot.add(ristipistoTyo);
        
        int etsittava;
        etsittava = 2;       
        
        RistipistoTyo etsiTyo = ristipistoTyo.etsiRistipistoTyo(tyot, etsittava);
        assertEquals(null, etsiTyo);       
    }    
    
}
