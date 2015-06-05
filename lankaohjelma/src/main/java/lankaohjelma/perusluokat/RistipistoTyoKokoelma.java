/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author ylikrkat
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RistipistoTyoKokoelma {
    
     ArrayList<RistipistoTyo> ristipistotyot;
    
    /**
     * Oletuskonstruktori
     */
    public RistipistoTyoKokoelma()
    {
        setRistipistoTyot(null);
       
    }
    
    //    @XmlElement
    public void setRistipistoTyot(ArrayList<RistipistoTyo> tyot) {
        this.ristipistotyot = tyot;
    }
    
}
