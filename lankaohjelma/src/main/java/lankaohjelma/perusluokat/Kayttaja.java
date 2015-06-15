/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.kokoelmat.KayttajaKokoelma;
import lankaohjelma.kokoelmat.LankaKokoelma;
import lankaohjelma.kayttoliittyma.LankaKl;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 * Luokka, joka kasittelee kayttajan tietoja.
 * @author Katja
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Kayttaja {
    private int nro;    
    private String etunimi;
    private ArrayList<RistipistoTyo> ristipistotyot;
    private LankaKokoelma lankaKokoelma;  
    
    /**
     * Oletuskonstruktori
     */
    public Kayttaja()
    {
        setNro(0);
        setEtunimi(null);
        setRistipistotyot(null);
        setLankaKokoelma(null);      
    }
    
    /**
     * Parametrit vastaanottava konstruktori
     * @param nro Kayttajan nro
     * @param etunimi Kayttajan etunimi
     * @param ristipistotyot Lista kayttajan ristipistotoista
     * @param lankaKokoelma Kayttakan lankakokoelma
     */    
    public Kayttaja(int nro, String etunimi, ArrayList<RistipistoTyo> ristipistotyot, LankaKokoelma lankaKokoelma)
    {
        setNro(nro);
        setEtunimi(etunimi);
        setRistipistotyot(ristipistotyot);
        setLankaKokoelma(lankaKokoelma);      
    }      
   
    public int getNro()  {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

     public String getEtunimi()  {
        return etunimi;
    }
 
    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public ArrayList getRistipistotyot()  {
        return ristipistotyot;
    }

    public void setRistipistotyot(ArrayList<RistipistoTyo> ristipistotyot) {
        this.ristipistotyot = ristipistotyot;
    }
    
    public LankaKokoelma getLankaKokoelma()  {
        return lankaKokoelma;
    }
    
    public void setLankaKokoelma(LankaKokoelma lankaKokoelma) {
        this.lankaKokoelma = lankaKokoelma;
    }
    
     /**
     * Tulostetaan Kayttajan tiedot
     */
    @Override
    public String toString()
    {
        return nro + ", " 
                + etunimi + ", "
                + lankaKokoelma + ", "
                + ristipistotyot + ".";               
    } 
   
    /**
     * Lisataan kayttajat. Kutsutaan xml-tiedostoa kirjoittavaa luokkaa
     * @param kayttajaKokoelma kayttajakokoelma
     * @throws Exception nostaa virheen
     */
    public void lisaaKayttaja(KayttajaKokoelma kayttajaKokoelma) throws Exception {
    
        XmlKasittely xmlKasittely = new XmlKasittely();
        String tiedNimi = "kayttaja.xml";   
        
        try {        
            xmlKasittely.KirjoitaKayttajaXml(kayttajaKokoelma, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(LankaKl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }         
}
