/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.kokoelmat;

import java.util.ArrayList;
import lankaohjelma.perusluokat.RistipistoTyo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * RistipistoTyoKokoelma -luokan testit
 * @author Katja
 */
public class RistipistoTyoKokoelmaTest {
    
    /**
     * Testaa ristipistotyon getter
     */
    @Test
    public void testaaGetteriRistipistoTyot() {
        
        RistipistoTyoKokoelma instance = new RistipistoTyoKokoelma();
        ArrayList odotettuTulos = null;
        ArrayList tulos = instance.getRistipistoTyot();
        assertEquals(odotettuTulos, tulos);
    }

    /**
     * Testaa setteri
     */
    @Test
    public void testSetRistipistoTyot() {
       
        ArrayList<RistipistoTyo> tyot = null;
        RistipistoTyoKokoelma kokoelma = new RistipistoTyoKokoelma();
        kokoelma.setRistipistoTyot(tyot);     
    }    
}
