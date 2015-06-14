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
import lankaohjelma.perusluokat.RistipistoTyo;

/**
 * RistipistoTyoKokoelma -luokka
 * @author ylikrkat
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RistipistoTyoKokoelma {
    
     ArrayList<RistipistoTyo> ristipistotyot;
    
    /**
     * Oletuskonstruktori
     */
    public RistipistoTyoKokoelma() {
        setRistipistoTyot(null);       
    }
    
    public ArrayList getRistipistoTyot() {
        return ristipistotyot;
    }

    /**
     * Asetetaan lista ristipistotoista
     * @param tyot lista ristipistotoista
     */
    public void setRistipistoTyot(ArrayList<RistipistoTyo> tyot) {
        this.ristipistotyot = tyot;
    }    
}
