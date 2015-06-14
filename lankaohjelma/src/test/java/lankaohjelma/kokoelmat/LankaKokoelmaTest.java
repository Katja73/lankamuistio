/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.kokoelmat;

import java.util.ArrayList;
import lankaohjelma.lankaohjelma.OmaLanka;
import lankaohjelma.perusluokat.Kayttaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LankaKokoelma -luokan testit
 * @author Katja
 */
public class LankaKokoelmaTest { 

    /**
     * Testataan OmatLangat setteri
     */
    @Test
    public void testSetteriOmatLangat() {
        ArrayList<OmaLanka> omatLangat = null;
        LankaKokoelma lankakokoelma = new LankaKokoelma();
        lankakokoelma.setOmatLangat(omatLangat);
    }

    /**
    * Testataan Kayttaja setteri
    */
    @Test
    public void testaaSetteriKayttaja() {
        
        Kayttaja kayttaja = null;
        LankaKokoelma lankaKokoelma = new LankaKokoelma();
        lankaKokoelma.setKayttaja(kayttaja);
    }

    /**
     * Testataan LisaaLankaKokoelma metodi
     * @throws Exception
     */
    @Test
    public void testaaLisaaLankaKokoelma() throws Exception {
      
        LankaKokoelma lankaKokoelma = null;
        LankaKokoelma kokoelma = new LankaKokoelma();
        kokoelma.lisaaLankaKokoelma(lankaKokoelma);
    }    
}
