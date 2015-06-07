/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.kokoelmat.KayttajaKokoelma;
import lankaohjelma.kokoelmat.LankaKokoelma;
import lankaohjelma.perusluokat.Kayttaja;
import java.util.ArrayList;
import lankaohjelma.lankaohjelma.OmaLanka;
import lankaohjelma.lankaohjelma.XmlKasittely;
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
public class KayttajaTest {
    
    public KayttajaTest() {
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
        
        Kayttaja kayttaja = new Kayttaja();
        System.out.println(kayttaja); 
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {    
        
       new Kayttaja(1, "Katja", null, null );       
    }   
    
     /**
     * Testataan käyttäjäm lisäys
     */
    @Test
    public void TestaaLisaaKayttaja() throws Exception {  
    
        Kayttaja kayttaja = new Kayttaja();
        
        // Lisätään ristipistot
        ArrayList<RistipistoTyo> tyot = new ArrayList<RistipistoTyo>();
        Kangas kangas = new Kangas(1, "Aida");
        Kangas kangas2 = new Kangas(2, "Aidas");
        
        tyot.add(new RistipistoTyo(1, null, kangas, 10, 20));
        tyot.add(new RistipistoTyo(2, null, kangas2, 15, 45));
           
        ArrayList<OmaLanka> omatLangat = new ArrayList<OmaLanka>();
        Lanka lanka = new Lanka(1, 567, "DMC");
        Lanka lanka2 = new Lanka(2, 789, "Anchor");
        OmaLanka omaLanka1 = new OmaLanka(lanka, 4, true);
        OmaLanka omaLanka2 = new OmaLanka(lanka2, 7, false);
       
        omatLangat.add(omaLanka1);
        omatLangat.add(omaLanka2);
        
        LankaKokoelma lankaKokoelma = new LankaKokoelma();
        lankaKokoelma.setOmatLangat(omatLangat);       
        
        // Lisätään toinen työ
        ArrayList<RistipistoTyo> tyot2 = new ArrayList<RistipistoTyo>();
        Kangas kangas3 = new Kangas(1, "Pellava");
        Kangas kangas4 = new Kangas(2, "Aidas");
        tyot2.add(new RistipistoTyo(3, null, kangas3, 20, 30));
        tyot2.add(new RistipistoTyo(4, null, kangas4, 30, 50));
        
        // Lisätään toiselle työlle langat
        ArrayList<Lanka> langat2 = new ArrayList<Lanka>();
        langat2.add(new Lanka(1, 456, "DMC"));
        langat2.add(new Lanka(4, 847, "DMC"));
        
        // Lisätään kayttajat
        Kayttaja kayttaja1 = new Kayttaja(1, "Katja", tyot, lankaKokoelma);
        Kayttaja kayttaja2 = new Kayttaja(2, "Liisa", tyot2, lankaKokoelma);    
     
        ArrayList<Kayttaja>kayttajat  = new ArrayList();
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2); 
        
        KayttajaKokoelma kayttajaKokoelma = new KayttajaKokoelma();
        kayttajaKokoelma.setKayttajat(kayttajat);       
        
        kayttaja.lisaaKayttaja(kayttajaKokoelma);       
    }    
    
      /**
     * Testataan oman langan lisäys
     */
    @Test
    public void TestaaLisaaLankaKokoelma() throws Exception {  
        LankaKokoelma lankaKokoelma = new LankaKokoelma();
        Lanka lanka = new Lanka(1, 456, "DMC");        
        OmaLanka omaLanka = new OmaLanka(lanka, 4, true);
        ArrayList<OmaLanka> omatLangat = new ArrayList<OmaLanka>();
        omatLangat.add(omaLanka);
        
        lankaKokoelma.setOmatLangat(omatLangat);        
    }    
}
