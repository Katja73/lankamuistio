/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Lankaohjelma -luokan testit
 * @author Katja
 */
public class LankaohjelmaTest {   

    /**
     * Testataan valittu toiminto
     */
    @Test
    public void testValittuToiminto() throws Exception {        
        int toiminto = 0;
        Lankaohjelma.ValittuToiminto(toiminto);
    }    
}
