/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import lankaohjelma.perusluokat.Lanka;
import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.Kangas;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lankaohjelma.kokoelmat.KayttajaKokoelma;
import lankaohjelma.kokoelmat.RistipistoTyoKokoelma;
import lankaohjelma.perusluokat.RistipistoTyo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja
 */
public class XmlKasittelyTest {  
    
    /**
     * Tetataan lankaluokan tallennus XML:n
     */
    @Test
    public void TestaaLankaxmlTallennus() {  
  
        Lanka lanka1 = new Lanka(1, 543, "DMC");      
        int paluukoodi = 0;
      
        XmlKasittely wr = new XmlKasittely();       
        String tiedNimi = "src\\testitiedostot\\testilanka.xml";
        wr.KirjoitaLankaXML(lanka1, tiedNimi, paluukoodi);      
    }
    
    /**
    * Tetataan kangasluokan tallennus XML:n
    */
    @Test
    public void TestaaKangasxmlTallennus() {  
    
        try {
            Kangas kangas1 = new Kangas(1, "Aida");          
            
            XmlKasittely wr = new XmlKasittely();
            String tiedNimi = "src\\testitiedostot\\testikangas.xml";      
            
            wr.KirjoitaKangasXML(kangas1, tiedNimi);
            } catch (Exception ex) {
            Logger.getLogger(XmlKasittelyTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     /**
     * Tetataan kayttaja-luokan tallennus XML:n
     */
    @Test
    public void TestaaKayttajaXmlTallennus() throws Exception {  

        Kayttaja kayttaja1 = new Kayttaja(1, "Katja", null, null);
        Kayttaja kayttaja2 = new Kayttaja(2, "Liisa", null, null);    
     
        ArrayList<Kayttaja>kayttajat  = new ArrayList();
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        
        KayttajaKokoelma kayttajakokoelma = new KayttajaKokoelma();
        kayttajakokoelma.setKayttajat(kayttajat);
               
        XmlKasittely wr = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
        wr.KirjoitaKayttajaXml(kayttajakokoelma, tiedNimi);      
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
            assertEquals(1, lueKangasXml.size());
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
        int paluukoodi = 0;
        
        // Lisataan ensin lanka
        Lanka lanka1 = new Lanka(1, 543, "DMC");      
      
        String tiedNimi = "src\\testitiedostot\\testilanka.xml";
        
        kasittely.KirjoitaLankaXML(lanka1, tiedNimi, paluukoodi);             
        
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){     
            ArrayList lueLankaXml = kasittely.LueLankaXml(tiedNimi);        
            assertEquals(1, lueLankaXml.size());
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
            KayttajaKokoelma lueKayttajaXml = kasittely.HaeKaikkiKayttajat(tiedNimi);        
            assertNotEquals(null, lueKayttajaXml);          
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
        
         ArrayList<RistipistoTyo> tyot = new ArrayList<RistipistoTyo>();
         Kangas kangas = new Kangas(1, "Aida");
         Kangas kangas2 = new Kangas(2, "Aidas");
        tyot.add(new RistipistoTyo(1, "testi", null, kangas, 10, 20));
        tyot.add(new RistipistoTyo(2, "testi", null, kangas2, 15, 45));
    
        ArrayList<Lanka> langat = new ArrayList<Lanka>();
        langat.add(new Lanka(1, 456, "DMC"));
        langat.add(new Lanka(2, 678, "Anchor"));
        
        ArrayList<RistipistoTyo> tyot2 = new ArrayList<RistipistoTyo>();
         Kangas kangas3 = new Kangas(1, "Pellava");
         Kangas kangas4 = new Kangas(2, "Aidas");
        tyot2.add(new RistipistoTyo(3, "testi", null, kangas3, 20, 30));
        tyot2.add(new RistipistoTyo(4, "testi", null, kangas4, 30, 50));
        
        // ToDO:Muuta kokoelmaksi
       ArrayList<Lanka> langat2 = new ArrayList<Lanka>();
        langat2.add(new Lanka(1, 456, "DMC"));
        langat2.add(new Lanka(4, 847, "DMC"));
        
        Kayttaja kayttaja1 = new Kayttaja(1, "Katja", tyot, null);
        Kayttaja kayttaja2 = new Kayttaja(2, "Liisa", tyot2, null);    
     
        ArrayList<Kayttaja>kayttajat  = new ArrayList();
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        
        KayttajaKokoelma kayttajaKokoelma = new KayttajaKokoelma();
        kayttajaKokoelma.setKayttajat(kayttajat);
        
        kasittely.KirjoitaKayttajaXml(kayttajaKokoelma, tiedNimi);       
    }    
    
    /**
    * Testataan XML:n lukeminen (Kayttaja)
    */
    @Test
    public void TestaaKayttajaxmlLue2() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";       
           
        if (kasittely.OnkoTiedostoOlemassa(tiedNimi)){     
            KayttajaKokoelma lueKayttajaXml = kasittely.HaeKaikkiKayttajat(tiedNimi);        
            assertNotEquals(null, lueKayttajaXml);              
        } else {
            assertEquals(false, kasittely.OnkoTiedostoOlemassa(tiedNimi));  
        }
    }
    
     /**
    * Testataan XML:n kirjoittaminen (Kayttaja)
    */
    @Test
    public void TestaaRistipistoKokoelmanKirjoitus() throws Exception {  
    
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testiristipistotyokokoelma.xml";
        
        ArrayList<RistipistoTyo> tyot = new ArrayList<RistipistoTyo>();
        Kangas kangas = new Kangas(1, "Aida");
        Kangas kangas2 = new Kangas(2, "Aidas");
        
        TyonLanka tyonLanka = new TyonLanka(45, new Lanka(1,678,"DMC"));
        TyonLanka tyonLanka2 = new TyonLanka(20, new Lanka(2,987,"Anchor"));
         TyonLanka tyonLanka3 = new TyonLanka(15, new Lanka(3,444,"DMC"));
        TyonLanka tyonLanka4 = new TyonLanka(5, new Lanka(4,555,"DMC"));
        ArrayList<TyonLanka> tyonLangat = new ArrayList<TyonLanka>();
        tyonLangat.add(tyonLanka);
        tyonLangat.add(tyonLanka3);
        
        ArrayList<TyonLanka> tyonLangat2 = new ArrayList<TyonLanka>();
        tyonLangat2.add(tyonLanka2);
        tyonLangat2.add(tyonLanka4);
        
        tyot.add(new RistipistoTyo(1, "testi", tyonLangat, kangas, 10, 20));
        tyot.add(new RistipistoTyo(2, "testi", tyonLangat2, kangas2, 15, 75));
        
        RistipistoTyoKokoelma ristipistoKokoelma = new RistipistoTyoKokoelma();
        ristipistoKokoelma.setRistipistoTyot(tyot);
        
        kasittely.KirjoitaRistipistoTyoKokoelmaXml(ristipistoKokoelma, tiedNimi);     
    }  
    
    /**
     * Testataan ristipistokokoelman haku
     * @throws Exception
     */
    @Test
    public void TestaaRistipistoKokoelmaHae() throws Exception{
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testiristipistotyokokoelma.xml";
        
        RistipistoTyoKokoelma haeKaikkiRistipistoTyoKokoelma = kasittely.HaeKaikkiRistipistoTyoKokoelma(tiedNimi);
        
       assertNotEquals(null, haeKaikkiRistipistoTyoKokoelma);        
    }
}
