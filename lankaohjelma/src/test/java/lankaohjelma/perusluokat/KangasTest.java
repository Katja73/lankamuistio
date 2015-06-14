package lankaohjelma.perusluokat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lankaohjelma.lankaohjelma.XmlKasittely;
import lankaohjelma.lankaohjelma.XmlKasittelyTest;
import lankaohjelma.perusluokat.Kangas;
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
public class KangasTest { 

  /**
     * Testataan oletuskonstruktori
     */
    @Test
    public void TestaaOletuskonstruktori() {
        
        Kangas kangas = new Kangas();
        System.out.println(kangas); 
    }
    
    /**
     * Testataan parametrikonstruktori
     */
    @Test
    public void TestaaParametrikonstruktori() {          
       new Kangas(10, "Aida");            
    }
    
    @Test
    public void TestaaEtsiKangasLoytyy(){
        Kangas kangas = new Kangas(1, "Aida");
        Kangas kangas1 = new Kangas(2, "Pellava");
        ArrayList<Kangas> kankaat = new ArrayList();
        kankaat.add(kangas);
        kankaat.add(kangas1);
        
        int etsittava;
        etsittava = 1;       
        
        Kangas etsiKangas = kangas.etsiKangas(kankaat, etsittava);
        assertEquals(1, etsiKangas.getKangasnro());       
    }
    
    @Test
    public void TestaaEtsiKangasEiLoydy(){
        Kangas kangas = new Kangas(1, "Aida");
        Kangas kangas1 = new Kangas(2, "Pellava");
        ArrayList<Kangas> kankaat = new ArrayList();
        kankaat.add(kangas);
        kankaat.add(kangas1);
        
        int etsittava;
        etsittava = 3;       
        
        Kangas etsiKangas = kangas.etsiKangas(kankaat, etsittava);
        assertEquals(null, etsiKangas);           
    }
    
    @Test
    public void TestaaLisaaKangas(){
        try {
            Kangas kangas = new Kangas(1, "Aida");          
            String tiedNimi = "src\\testitiedostot\\testikangas1.xml";      
            
            kangas.lisaaKangas(kangas, tiedNimi);  
            
        } catch (Exception ex) {
            Logger.getLogger(XmlKasittelyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
