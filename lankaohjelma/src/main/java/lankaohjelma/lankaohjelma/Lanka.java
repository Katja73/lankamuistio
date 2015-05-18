/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

/**
 * Luokka käsittelee langan tietoja. Langat koostuvat aina nimestä ja
 * numerosta. Esim. DMC 365. Molemmat ovat pakollisia tietoja.
 * @author Katja
 */
public class Lanka {
    
    int lankaid;
    private int merkkinro;
    private String merkki;
    
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
     *
     * 
     * @param lankaid
     * @param lankanro
     * @param merkki
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
    
    public String getMerkki()
    {
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
        return lankaid + ", " 
                + merkki + ", " 
                + merkkinro + ".";    
    }    
    
}
