/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;

/**
 *
 * @author Katja
 */
public class RistipistoTyo {
    
    private ArrayList<TyonLanka> tyonLangat;
    private Kangas tyonKangas;
    public Kayttaja tyonTekija;
    public int leveys;
    public int korkeus;
    
    /**
     * Oletuskonstruktori
     */
    public RistipistoTyo()
    {
        setLangat(null);
        setKangas(null);
        setKayttaja(null);
        setLeveys(0);
        setKorkeus(0);
    }
    
    /**
     * Kaikki parametrit vastaanottava konstruktori
     * @param tyonLangat
     * @param kangas
     * @param kayttaja
     * @param leveys
     * @param korkeus
     */
    public RistipistoTyo(ArrayList<TyonLanka> tyonLangat, Kangas kangas, Kayttaja kayttaja, int leveys, int korkeus)
    {
        setLangat(tyonLangat);
        setKangas(kangas);
        setKayttaja(kayttaja);
        setLeveys(leveys);
        setKorkeus(korkeus);
    }
    
    public void LisaaLanka(TyonLanka uusiLanka){}
    
    public void LisaaKayttaja (Kayttaja uusiKayttaja) {}
    
    public void LisaaKangas (Kangas uusiKangas){}
    
    public ArrayList getLangat()  {
        return tyonLangat;
    }
    
    private void setLangat(ArrayList<TyonLanka> tyonLangat) {
        this.tyonLangat = tyonLangat;
    }
    
    public Kangas getKangas() {
        return tyonKangas;
    }

    private void setKangas(Kangas kangas) {
        this.tyonKangas = kangas;
    }
    
    public Kayttaja getKayttaja() {
        return tyonTekija;
    }

    private void setKayttaja(Kayttaja kayttaja) {
        this.tyonTekija = kayttaja;
    }
    
    public int getLeveys() {
        return leveys;
    }

    private void setLeveys(int leveys) {
        this.leveys = leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    private void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }
    
    public String toString()
    {
        return tyonLangat + "," 
                + tyonKangas + ","
                + tyonTekija + ","
                + leveys + "pistoa ,"
                + korkeus + "pistoa.";    
    }    
}