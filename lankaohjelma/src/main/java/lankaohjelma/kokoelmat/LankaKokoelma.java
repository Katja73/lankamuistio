/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.kokoelmat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lankaohjelma.kayttoliittyma.LankaKl;
import lankaohjelma.lankaohjelma.OmaLanka;
import lankaohjelma.lankaohjelma.XmlKasittely;
import lankaohjelma.perusluokat.Kayttaja;

/**
 * Kayttajan omat langat
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LankaKokoelma {
    
    ArrayList<OmaLanka> omatLangat;
    Kayttaja kayttaja;
    
    /**
     * Oletuskonstruktori
     */
    public LankaKokoelma()
    {
        setOmatLangat(null);
        setKayttaja(null);
       
    }

    /**
     * Asetetaan lista omista langoista
     * @param omatLangat Omat langat
     */
    public void setOmatLangat(ArrayList<OmaLanka> omatLangat) {
        this.omatLangat = omatLangat;
    }
    
    public void setKayttaja(Kayttaja kayttaja){
        this.kayttaja = kayttaja;
    }
    
     /**
     * Kirjoitetaan lankakokoelma. Kutsutaan xml -tiedoston kirjoittavaa luokkaa
     * @param lankaKokoelma lankakokoelma
     * @throws Exception nostetaan virhe
     */
    public void lisaaLankaKokoelma(LankaKokoelma lankaKokoelma) throws Exception {
    
        XmlKasittely xmlKasittely = new XmlKasittely();
        String tiedNimi = "kayttaja.xml";   
        
        try {        
            xmlKasittely.KirjoitaLankaKokoelmaXml(lankaKokoelma, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(LankaKl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
