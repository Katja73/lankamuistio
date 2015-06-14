/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.perusluokat.Lanka;
import java.util.ArrayList;
import lankaohjelma.lankaohjelma.XmlKasittely;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja
 */
public class LankaTest { 
  
    /**
     * Testataan oletuskonstruktori
     */
    @Test
    public void TestaaOletuskonstruktori() {
    
       Lanka oletusLanka = new Lanka();      
       System.out.println(oletusLanka);    
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {
    
       new Lanka(1, 365, "DMC");          
    }
    
    @Test
    public void TestaaKonstruktoriGetterit()
    {
        Lanka lanka = new Lanka(2, 368, "DMC");
        int lankaid = lanka.getLankaid();
        int lankanro = lanka.getLankanro();
        String lankaMerkki = lanka.getMerkki();
        
        assertEquals(2, lankaid);
        assertEquals(368, lankanro);
        assertEquals("DMC", lankaMerkki);        
    }
    
    /**
     * Testataan tulostus
     */
    @Test
    public void TestaaTulostus(){
        Lanka lanka = new Lanka(2, 368, "DMC");
        ArrayList<Lanka> langat = new ArrayList();
        langat.add(lanka);
        
        lanka.tulostaLanka(langat);       
    }
    
     /**
     * Testataan tulostus tyhjällä rivillä
     */
    @Test
    public void TestaaTulostusTyhja(){
        Lanka lanka = new Lanka();
        ArrayList<Lanka> langat = new ArrayList();
        langat.add(null);
        
        lanka.tulostaLanka(langat);       
    }
    
    @Test
    public void TestaaEtsiLankaLoytyy(){
        Lanka lanka = new Lanka(1, 456, "DMC");
        Lanka lanka1 = new Lanka(2, 789, "Anchor");
        ArrayList<Lanka> langat = new ArrayList();
        langat.add(lanka);
        langat.add(lanka1);
        
        int etsittava;
        etsittava = 1;       
        
        Lanka etsiLanka = lanka.etsiLanka(langat, etsittava);
        assertEquals(456, etsiLanka.getLankanro());       
    }
    
    @Test
    public void TestaaEtsiLankaEiLoydy(){
        Lanka lanka = new Lanka(1, 456, "DMC");
        Lanka lanka1 = new Lanka(2, 789, "Anchor");
        ArrayList<Lanka> langat = new ArrayList();
        langat.add(lanka);
        langat.add(lanka1);
        
        int etsittava;
        etsittava = 3;       
        
        Lanka etsiLanka = lanka.etsiLanka(langat, etsittava);
        assertEquals(null, etsiLanka);       
    }
    
     /**
     * Testataan langan lisays
     */
    @Test
    public void TestaaLisaaLanka() throws Exception {  
  
        Lanka lanka1 = new Lanka(1, 543, "DMC");      
        int paluukoodi = 0;
        
        lanka1.lisaaLanka(lanka1, paluukoodi);        
    }
    
    /**
     * Testataan langan tulostus
     */
    @Test
    public void TestaaTulostaLanka() throws Exception {  
  
        Lanka lanka1 = new Lanka(1, 543, "DMC");  
        ArrayList<Lanka> langat = new ArrayList<Lanka>();
       
        langat.add(lanka1);
        
        lanka1.tulostaLanka(langat);        
    }
}
