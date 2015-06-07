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
 *
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
     * @param maara
     * @param lanka
     */
    public TyonLanka(double maara, Lanka lankamerkki)
    {
        setMaara(maara);
        setLankamerkki(lankamerkki);        
    }
    
    /**
     * Getteri
     * @return maara
     */
    public double getMaara(){return maara;}

    private void setMaara(double maara) {
       this.maara = maara;
    }
    
     /**
     * Getteri
     * @return lankamerkki
     */
    public Lanka getLankamerkki(){return lankamerkki;}

    private void setLankamerkki(Lanka lankamerkki) {
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

