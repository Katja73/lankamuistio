/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lankaohjelma.kayttoliittyma.LankaKl;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 * Luokka, joka kasittelee kankaan tietoja.
 * @author Katja
 */
public class Kangas implements Serializable {
    private int kangasnro;
    private String kangasMerkki;
    
    /**
     * Oletuskonstruktori
     */
    public Kangas()
    {
        setKangasnro(0);
        setKangasMerkki(null);
    }
    
    /**
     * Kangas -luokan parametrillinen konstruktori
     * @param kangasnro kankaan nro
     * @param kangasmerkki kangasmerkki
     */
    public Kangas(int kangasnro, String kangasmerkki)
    {
        setKangasnro(kangasnro);
        setKangasMerkki(kangasmerkki);
    }

    public int getKangasnro()
    {return kangasnro;}
    
    public void setKangasnro(int kangasnro) {
        this.kangasnro = kangasnro;
    }
    
    public String getKangasMerkki()
    {
        return kangasMerkki;
    }

    public void setKangasMerkki(String kangasMerkki) {
        this.kangasMerkki = kangasMerkki;
    }
    
    /**
     * Tulostetaan merkin tiedot
     * @return merkkinro ja merkki
     */
    @Override
    public String toString()
    {
        return kangasnro + ", " 
                + kangasMerkki;    
    }    

    /**
     * Lisätään kankaat. Kutsutaan luokkaa, joka kirjoittaa xml -tiedoston. 
     * @param lisattavaKangas lisattava kangas
     * @param tiedNimi xml -tiedoston nimi
     */
    public void lisaaKangas(Kangas lisattavaKangas, String tiedNimi) {
                
        XmlKasittely xmlKasittely = new XmlKasittely();
       
        try {        
            xmlKasittely.KirjoitaKangasXML(lisattavaKangas, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(LankaKl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * Etsitään Kangas -luokan tiedot saadulla kangasid:llä
     * @param kangasLista lista kankaista
     * @param etsittava kangas
     * @return kankaan tiedot
     */
    public Kangas etsiKangas(ArrayList<Kangas> kangasLista, int etsittava) {
        // jos listassa on jotakin,
        if (kangasLista.size() > 0) {               

            // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
            for (int i = 0; i < kangasLista.size(); i++) {               
                  if (kangasLista.get(i).getKangasnro()== etsittava) {
                 
                    // palautetaan haluttu lanka
                    return (kangasLista.get(i));                                        
                }
            }        
        }           
        return null;
    }  
}
