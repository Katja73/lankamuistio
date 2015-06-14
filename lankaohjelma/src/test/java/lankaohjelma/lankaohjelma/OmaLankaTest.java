/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import lankaohjelma.perusluokat.Lanka;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * OmaLanka -luokan testit
 * @author Katja
 */
public class OmaLankaTest {  

    /**
     * Testataan Lanka getteri
     */
    @Test
    public void testaaGetteriLanka() {
        
        OmaLanka omaLanka = new OmaLanka();
        Lanka odotettuTulos = null;
        Lanka result = omaLanka.getLanka();
        assertEquals(odotettuTulos, result);
    }
}
