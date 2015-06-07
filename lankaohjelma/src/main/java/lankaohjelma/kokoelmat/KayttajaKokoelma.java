/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.kokoelmat;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lankaohjelma.perusluokat.Kayttaja;

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

    public void setKayttajat(ArrayList<Kayttaja> kayttajat) {
        this.kayttajat = kayttajat;
    }
}
