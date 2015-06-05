/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import lankaohjelma.perusluokat.Lanka;
import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.Kangas;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lankaohjelma.perusluokat.KayttajaKokoelma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja
 */
public class XmlKasittelyTest {  
   
//    @Test
//    public void TestaaKayttajaxml() {  
//        RistipistoTyo tyo = new RistipistoTyo();
//        ArrayList<RistipistoTyo> tyot= new ArrayList();
//        tyo.setTyoId(1);        
//        tyot.add(tyo);
//        
//        LankaKokoelma kokoelma = new LankaKokoelma();
//        ArrayList<LankaKokoelma> kokoelmat = new ArrayList();
//        kokoelma.setKokoelmaId(1);
//        kokoelmat.add(kokoelma);
//        
//        Kayttaja kayttaja = new Kayttaja(1, "Katja", tyot, kokoelmat);
//     
//        ArrayList<Kayttaja> kayttajat = new ArrayList();
//        kayttajat.add(kayttaja);
//        
//        XmlKasittely wr = new XmlKasittely();
//        wr.KirjoitaKayttajaXML(kayttajat);      
//    }
    
    /**
     * Tetataan lankaluokan tallennus XML:n
     */
    @Test
    public void TestaaLankaxmlTallennus() {  
  
        Lanka lanka1 = new Lanka(1, 543, "DMC");
        Lanka lanka2 = new Lanka(2, 444, "DMC");
        Lanka lanka3 = new Lanka(3, 333, "Anchor");
     
        ArrayList<Lanka> langat = new ArrayList();
        langat.add(lanka1);
        langat.add(lanka2);
        langat.add(lanka3);
        
        XmlKasittely wr = new XmlKasittely();
        //String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testilanka.xml";
        String tiedNimi = "src\\testitiedostot\\testilanka.xml";
        wr.KirjoitaLankaXML(langat, tiedNimi);      
    }
    
    /**
    * Tetataan kangasluokan tallennus XML:n
    */
    @Test
    public void TestaaKangasxmlTallennus() {  
    
        try {
            Kangas kangas1 = new Kangas(1, "Aida");
            Kangas kangas2 = new Kangas(2, "Pellava");
            
            ArrayList<Kangas> kankaat = new ArrayList();
            kankaat.add(kangas1);
            kankaat.add(kangas2);
            
            XmlKasittely wr = new XmlKasittely();
            String tiedNimi = "src\\testitiedostot\\testikangas.xml";      
            
            wr.KirjoitaKangasXML(kankaat, tiedNimi);
            } catch (Exception ex) {
            Logger.getLogger(XmlKasittelyTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     /**
     * Tetataan kayttaja-luokan tallennus XML:n
     */
    @Test
    public void TestaaKayttajaXmlTallennus() throws Exception {  
  
        ArrayList<Integer> tyot = new ArrayList<Integer>();
        tyot.add(1);
        tyot.add(2);
        tyot.add(3);
        
        ArrayList<Integer> langat = new ArrayList<Integer>();
        langat.add(10);
        langat.add(20);
        langat.add(30);
        
        ArrayList<Integer> tyot2 = new ArrayList<Integer>();
        tyot2.add(5);
        tyot2.add(6);
        tyot2.add(7);
        
        ArrayList<Integer> langat2 = new ArrayList<Integer>();
        langat2.add(11);
        langat2.add(21);
        langat2.add(31);
        
//        Kayttaja kayttaja1 = new Kayttaja(1, "Katja", tyot, langat);
//        Kayttaja kayttaja2 = new Kayttaja(2, "Liisa", tyot2, langat2);    
//     
//        ArrayList<Kayttaja>kayttajat  = new ArrayList();
//        kayttajat.add(kayttaja1);
//        kayttajat.add(kayttaja2);
//               
//        XmlKasittely wr = new XmlKasittely();
//        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
//        wr.KirjoitaKayttajaXML(kayttajat, tiedNimi);      
    }
    
    /**
    * Testataan XML:n lukeminen (Kangas)
    */
    @Test
    public void TestaaKangasxmlLue() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikangas.xml";
        
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){   
            ArrayList lueKangasXml = kasittely.LueKangasXml(tiedNimi);                
            assertEquals(2, lueKangasXml.size());
        } else {
             assertEquals(false, kasittely.OnkoTiedostoOlemassa(tiedNimi));             
        }
    }
    
    /**
    * Testataan XML:n lukeminen (Lanka)
    */
    @Test
    public void TestaaLankaxmlLue() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testilanka.xml";
        
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){     
            ArrayList lueLankaXml = kasittely.LueLankaXml(tiedNimi);        
            assertNotEquals(1, lueLankaXml.size());
        } else {
            assertEquals(false, kasittely.OnkoTiedostoOlemassa(tiedNimi));  
        }
    }
    
    /**
    * Testataan XML:n lukeminen (Kayttaja)
    */
    @Test
    public void TestaaKayttajaxmlLue() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
        
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){     
            ArrayList lueKayttajaXml = kasittely.LueKayttajaXml(tiedNimi);        
            assertEquals(0, lueKayttajaXml.size());          
        } else {
            assertEquals(false, kasittely.OnkoTiedostoOlemassa(tiedNimi));  
        }
    }
    
    /**
    * Testataan XML:n kirjoittaminen (Kayttaja)
    */
    @Test
    public void TestaaKayttajaxmlKirjoita2() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
        
         ArrayList<Integer> tyot = new ArrayList<Integer>();
        tyot.add(1);
        tyot.add(2);
        tyot.add(3);
        
        ArrayList<Lanka> langat = new ArrayList<Lanka>();
        langat.add(new Lanka(1, 456, "DMC"));
        langat.add(new Lanka(2, 678, "Anchor"));
        
        ArrayList<Integer> tyot2 = new ArrayList<Integer>();
        tyot2.add(5);
        tyot2.add(6);
        tyot2.add(7);
        
       ArrayList<Lanka> langat2 = new ArrayList<Lanka>();
        langat2.add(new Lanka(1, 456, "DMC"));
        langat2.add(new Lanka(4, 847, "DMC"));
        
        Kayttaja kayttaja1 = new Kayttaja(1, "Katja", tyot, langat);
        Kayttaja kayttaja2 = new Kayttaja(2, "Liisa", tyot2, langat2);    
     
        ArrayList<Kayttaja>kayttajat  = new ArrayList();
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        
        KayttajaKokoelma kayttajaKokoelma = new KayttajaKokoelma();
        kayttajaKokoelma.setKayttajat(kayttajat);
        
        kasittely.kirjoitaKayttajaXml3(kayttajaKokoelma, tiedNimi);     
       
    }
    
    
    /**
    * Testataan XML:n lukeminen (Kayttaja)
    */
    @Test
    public void TestaaKayttajaxmlLue2() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
        
           
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){     
            ArrayList lueKayttajaXml = kasittely.haeKaikkiKayttajat2(tiedNimi);        
            assertEquals(1, lueKayttajaXml.size());   
            System.out.println("lkm343434343: "+lueKayttajaXml);
        } else {
            assertEquals(false, kasittely.OnkoTiedostoOlemassa(tiedNimi));  
        }
    }
}
