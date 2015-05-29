/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja
 */
public class XMLKasittelyTest {  
   
    @Test
    public void TestaaKayttajaxml() {  
        RistipistoTyo tyo = new RistipistoTyo();
        ArrayList<RistipistoTyo> tyot= new ArrayList();
        tyo.setTyoId(1);        
        tyot.add(tyo);
        
        LankaKokoelma kokoelma = new LankaKokoelma();
        ArrayList<LankaKokoelma> kokoelmat = new ArrayList();
        kokoelma.setKokoelmaId(1);
        kokoelmat.add(kokoelma);
        
        Kayttaja kayttaja = new Kayttaja(1, "Katja", tyot, kokoelmat);
     
        ArrayList<Kayttaja> kayttajat = new ArrayList();
        kayttajat.add(kayttaja);
        
        XMLKasittely wr = new XMLKasittely();
        wr.KirjoitaKayttajaXML(kayttajat);      
    }
    
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
        
        XMLKasittely wr = new XMLKasittely();
        String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testilanka.xml";
        wr.KirjoitaLankaXML(langat, tiedNimi);      
    }
    
    /**
    * Tetataan kangasluokan tallennus XML:n
    */
    @Test
    public void TestaaKangasxmlTallennus() {  
    
        Kangas kangas1 = new Kangas(1, "Aida");
        Kangas kangas2 = new Kangas(2, "Pellava");
           
        ArrayList<Kangas> kankaat = new ArrayList();
        kankaat.add(kangas1);
        kankaat.add(kangas2);        
        
        XMLKasittely wr = new XMLKasittely();
        String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testikangas.xml";
        wr.KirjoitaKangasXML(kankaat, tiedNimi);      
    }
    
    /**
    * Testataan XML:n lukeminen (Kangas)
    */
    @Test
    public void TestaaKangasxmlLue() throws Exception {  
    
        XMLKasittely kasittely = new XMLKasittely();
        ArrayList lueKangasXml = kasittely.LueKangasXml();        
        
        assertEquals(2, lueKangasXml.size());
    }
    
    /**
    * Testataan XML:n lukeminen (Lanka)
    */
    @Test
    public void TestaaLankaxmlLue() throws Exception {  
    
        XMLKasittely kasittely = new XMLKasittely();
        String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testilanka.xml";
        ArrayList lueLankaXml = kasittely.LueLankaXml(tiedNimi);        
        
        assertNotEquals(1, lueLankaXml.size());
    }
}
