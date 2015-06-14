/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lankaohjelma.lankaohjelma.TyonLanka;

/**
 * Luokka, joka kasittelee ristipistotyon tietoja.
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RistipistoTyo {
    
    public int tyoId;    
    public String tyoNimi;
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
        setNimi(null);
        setLangat(null);
        setKangas(null);       
        setLeveys(0);
        setKorkeus(0);
    }
    
    /**
     * Kaikki parametrit vastaanottava konstruktori
     * @param tyoId Tyon yksiloiva tunniste
     * @param nimi Tyon nimi
     * @param tyonLangat Tyohon tarvittavat langat
     * @param kangas Tyohon tarvittava kangas
     * @param leveys Tyon leveys
     * @param korkeus Tyon korkeus
     */
    public RistipistoTyo(int tyoId, String nimi, ArrayList<TyonLanka> tyonLangat, Kangas kangas, int leveys, int korkeus)
    {
        setTyoId(tyoId);
        setNimi(nimi);
        setLangat(tyonLangat);
        setKangas(kangas);      
        setLeveys(leveys);
        setKorkeus(korkeus);
    }
    
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
    
    public String getNimi() {
        return tyoNimi;
    }

    public void setNimi(String nimi) {
        this.tyoNimi = nimi;
    }
    
    /**
     * Tulostetaan tyo
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
    
    /**
     * Haetaan haluttu ristipistotyö listasta
     * @param tyoLista Lista ristipistotöistä
     * @param etsittava hakuparametri (työn id)
     * @return Ristipistotyö -luokan
     */
    public RistipistoTyo etsiRistipistoTyo(ArrayList<RistipistoTyo> tyoLista, int etsittava) {
        // jos listassa on jotakin,
        if (tyoLista.size() > 0) {               

            // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
            for (int i = 0; i < tyoLista.size(); i++) {               
                  if (tyoLista.get(i).getTyoId() == etsittava) {
                 
                    // palautetaan haluttu lanka
                    return (tyoLista.get(i));
                              
                }
            }        
    }           
        return null;
   }
}