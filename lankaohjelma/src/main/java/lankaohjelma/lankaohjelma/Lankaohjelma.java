/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

/**
 * Lankaohjelma -luokka
 * @author Katja
 */
public class Lankaohjelma {
    
      /**
     * Luokkaa kaytetaan, jos ei ajeta kayttoliittyman kautta
     * @param args the command line arguments
     * @throws java.lang.Exception nostetaan virhe
     */
    public static void main(String[] args) throws Exception {
        
        XmlKasittely kasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\testikayttaja.xml";
        kasittely.KirjoitaKayttajaXml(null, tiedNimi);       
    }
    
    /** 
     * Metodi avaa valitun toiminnon ikkunan, riippuen parametrista
     * @param toiminto Kayttajan antama toimintokoodi    
     * @throws java.lang.Exception nostetaan virhe 
     */
    public static void ValittuToiminto(int toiminto) throws Exception
    {
        if (toiminto == 1) 
        {
             System.out.println("Avataan tyoikkuna");   
        }
     }        
}
