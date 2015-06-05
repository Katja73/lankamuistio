/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ylikrkat
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class KayttajaKokoelma {
    
    
    ArrayList<Kayttaja> kayttajat;
    
    /**
     * Oletuskonstruktori
     */
    public KayttajaKokoelma()
    {
        setKayttajat(null);
       
    }
    
    //    @XmlElement
    public void setKayttajat(ArrayList<Kayttaja> kayttajat) {
        this.kayttajat = kayttajat;
    }
}
