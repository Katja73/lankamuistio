/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.kayttoliittyma.LankaKl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 * Luokka, joka kasittelee langan tietoja. Langat koostuvat aina nimestä ja
 * numerosta. Esim. DMC 365. Molemmat ovat pakollisia tietoja.
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Lanka implements Serializable {
    
    private int lankaid;
    private int merkkinro;
    private String merkki;
    
    private int toimintokoodi;
    
    /**
     * Oletuskonstruktori
     */
    
    public Lanka()
    {
        setLankaid(0);
        setLankanro(0);
        setMerkki(null);
    }
    
    /**
     * Lanka luokan parametrillinen konstruktori
     * 
     * @param lankaid Lankan yksilöivä tunniste
     * @param lankanro Langan nro
     * @param merkki Langan merkki
     */
    public Lanka(int lankaid, int lankanro, String merkki)
    {
        setLankaid(lankaid);
        setLankanro(lankanro);
        setMerkki(merkki);
    }
    
    public int getLankaid()
    {return lankaid;}    

    public void setLankaid(int lankaid) {
        this.lankaid = lankaid;
    }

    public int getLankanro()
    {return merkkinro;}    

    public void setLankanro(int lankanro) {
        this.merkkinro = lankanro;
    }
    
    public String getMerkki() {
        return merkki;
    }

    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
    
    /**
     * Tulostetaan merkin tiedot
     * @return lankaid, merkkinro ja merkki
     */
    @Override
    public String toString()
    {
        return lankaid + ","                 
                + merkkinro + ","
                + merkki;    
    }  

    /**
     * Lisätään lanka. Kutsutaan xml -tiedoston kirjoittavaa metodia
     * @param lisattavaLanka lisattava lanka
     * @param paluukoodi paluukoodi, myohempaa kayttoa varten
     * @throws Exception nostaa virheen
     */
    public void lisaaLanka(Lanka lisattavaLanka, int paluukoodi) throws Exception {
    
        XmlKasittely xmlKasittely = new XmlKasittely();        
        String tiedNimi = "lanka.xml";

        try {        
            xmlKasittely.KirjoitaLankaXML(lisattavaLanka, tiedNimi, paluukoodi); 
            paluukoodi = paluukoodi;
        } catch (Exception ex) {
            Logger.getLogger(LankaKl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * Tulostetaan langat, jotka ovat listalla
     * @param lankaLista lista tulostettavista langoista
     */
    public void tulostaLanka(ArrayList<Lanka> lankaLista)
    {
        // tulostetaan, jos listassa on jotain
        if (lankaLista.size() > 0)
            // loopataan läpi ja tulostetaan
            {
                for (int i = 0; i < lankaLista.size(); i++) {
                    System.out.println(lankaLista.get(i));
            }
        }
        // jos ei ole mitään, tulostetaan
        else    
            System.out.println("Listassa ei ole vielä tuotteita");
    }

    /**
     * Etsitään lanka annetun parametrin perusteella
     * @param lankaLista lista, josta etsitään
     * @param etsittava etittävän tiedon nimi
     * @return Halutun langan
     */
    public Lanka etsiLanka(ArrayList<Lanka> lankaLista, int etsittava) {
        // jos listassa on jotakin,
        if (lankaLista.size() > 0) {               

            // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
            for (int i = 0; i < lankaLista.size(); i++) {               
                  if (lankaLista.get(i).getLankaid() == etsittava) {
                 
                    // palautetaan haluttu lanka
                    return (lankaLista.get(i));
                    // muutetaan boolean todeksi.                    
                }
            }        
    }           
        return null;       
   }
}