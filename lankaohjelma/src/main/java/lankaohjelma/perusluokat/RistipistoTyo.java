/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.Kangas;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lankaohjelma.kayttoliittyma.LankaKl;
import lankaohjelma.lankaohjelma.TyonLanka;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 *
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RistipistoTyo {
    
    public int tyoId;    
    public ArrayList<TyonLanka> tyonLangat;
    public Kangas tyonKangas;  
    public int leveys;
    public int korkeus;
    
    /**
     * Oletuskonstruktori
     */
    public RistipistoTyo()
    {
        setTyoId(0);
        setLangat(null);
        setKangas(null);       
        setLeveys(0);
        setKorkeus(0);
    }
    
    /**
     * Kaikki parametrit vastaanottava konstruktori
     * @param tyonLangat
     * @param kangas    
     * @param leveys
     * @param korkeus
     */
    public RistipistoTyo(int tyoId, ArrayList<TyonLanka> tyonLangat, Kangas kangas, int leveys, int korkeus)
    {
        setTyoId(tyoId);
        setLangat(tyonLangat);
        setKangas(kangas);      
        setLeveys(leveys);
        setKorkeus(korkeus);
    }
    
    public void LisaaLanka(TyonLanka uusiLanka){}    
    public void LisaaKangas (Kangas uusiKangas){}
    
    public ArrayList getLangat()  {
        return tyonLangat;
    }
    
    public void setLangat(ArrayList<TyonLanka> tyonLangat) {
        this.tyonLangat = tyonLangat;
    }
    
    public Kangas getKangas() {
        return tyonKangas;
    }

    public void setKangas(Kangas kangas) {
        this.tyonKangas = kangas;
    }   
    
    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }
    
    public int getTyoId() {
        return tyoId;
    }

    public void setTyoId(int tyoId) {
        this.tyoId = tyoId;
    }
    
    /**
     * Tulostetaan
     */
    @Override
    public String toString()
    {
        return tyoId + ","
                + tyonLangat + ", " 
                + tyonKangas + ", "               
                + leveys + " pistoa ,"
                + korkeus + " pistoa.";    
    } 
    
//        /**
//     * Lisätään ristipistotyö 
//     * @param lisattavaTyo
//     * @throws Exception
//     */
//    public void lisaaRistipistotyo(RistipistoTyo lisattavaTyo) throws Exception {
//    
//        XmlKasittely xmlKasittely = new XmlKasittely();
//        String tiedNimi = "src\\testitiedostot\\ristipistotyo.xml";
//
//        try {        
//            xmlKasittely.KirjoitaRistipistoTyoXML(lisattavaTyo, tiedNimi);           
//        } catch (Exception ex) {
//            Logger.getLogger(LankaKl.class.getName()).log(Level.SEVERE, null, ex);
//        }        
//    }
}