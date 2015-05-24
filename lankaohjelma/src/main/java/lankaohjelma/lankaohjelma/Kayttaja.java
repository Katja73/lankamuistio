/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;

/**
 * Kayttajaluokka, joka sisältää käyttäjän tiedot
 * @author Katja
 */
public class Kayttaja {
    
    private int nro;
    private String etunimi;
    private ArrayList<RistipistoTyo> ristipistotyot;
    private ArrayList<LankaKokoelma> omatLangat;  
    
    /**
     * Oletuskonstruktori
     */
    public Kayttaja()
    {
        setNro(0);
        setEtunimi(null);
        setRistipistotyot(null);
        setOmatLangat(null);      
    }
    
    /**
     * Parametrit vastaanottava konstruktori
     * @param nro
     * @param etunimi
     * @param ristipistotyot
     * @param omatLangat
     */    
    public Kayttaja(int nro, String etunimi, ArrayList<RistipistoTyo> ristipistotyot, ArrayList<LankaKokoelma> omatLangat)
    {
        setNro(nro);
        setEtunimi(etunimi);
        setRistipistotyot(ristipistotyot);
        setOmatLangat(omatLangat);      
    }      
   
    public int getNro()  {
        return nro;
    }
    
    private void setNro(int nro) {
        this.nro = nro;
    }

     public String getEtunimi()  {
        return etunimi;
    }
     
    private void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public ArrayList getRistipistotyot()  {
        return ristipistotyot;
    }
    
    private void setRistipistotyot(ArrayList<RistipistoTyo> ristipistotyot) {
        this.ristipistotyot = ristipistotyot;
    }
    
    public ArrayList getOmatLangat()  {
        return omatLangat;
    }

    private void setOmatLangat(ArrayList<LankaKokoelma> omatLangat) {
        this.omatLangat = omatLangat;
    }
    
     /**
     * Tulostetaan Kayttajan tiedot
     */
    @Override
    public String toString()
    {
        return nro + ", " 
                + etunimi + ", "
                + omatLangat + ", "
                + ristipistotyot + ".";               
    }     
}
