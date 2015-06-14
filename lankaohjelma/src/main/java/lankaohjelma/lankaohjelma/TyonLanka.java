/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lankaohjelma.perusluokat.Lanka;

/**
 * TyonLanka -luokka
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TyonLanka {
    
    private double maara;
    private Lanka lankamerkki;
    
    
     /**
     * Oletuskonstruktori
     */
    public TyonLanka()
    {
        setMaara(0);
        setLankamerkki(null);        
    }
    
    /**
     * Parametrit vastaanottava konstruktori
     * @param maara tyon langan maara
     * @param lankamerkki lankan merkki
     */
    public TyonLanka(double maara, Lanka lankamerkki)
    {
        setMaara(maara);
        setLankamerkki(lankamerkki);        
    }
    
    /**
     * Getteri
     * @return maara palauttaa maaran
     */
    public double getMaara(){return maara;}

    public void setMaara(double maara) {
       this.maara = maara;
    }
    
     /**
     * Getteri
     * @return lankamerkki palauttaa lankamerkin
     */
    public Lanka getLankamerkki(){return lankamerkki;}

    public void setLankamerkki(Lanka lankamerkki) {
        this.lankamerkki = lankamerkki;
    }
    
    /**
     * Tulostetaan merkin tiedot
     */
    @Override
    public String toString()
    {
        return lankamerkki + ", " 
                + maara + ".";    
    }        
}

