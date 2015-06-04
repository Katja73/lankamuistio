/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.kayttoliittyma.Kayttoliittyma;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 * Kayttajaluokka, joka sisältää käyttäjän tiedot
 * @author Katja
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Kayttaja {
    
    
    private int nro;
    
    private String etunimi;
//    @XmlElement
    private ArrayList<Integer> ristipistotyot;
//    @XmlElement
    private ArrayList<Lanka> omatLangat;  
    
    /**
     * Oletuskonstruktori
     */
    public Kayttaja()
    {
        setNro(0);
        setEtunimi(null);
        setRistipistotyot(null);
        setOmatLangat(null);      
    }
    
    /**
     * Parametrit vastaanottava konstruktori
     * @param nro
     * @param etunimi
     * @param ristipistotyot
     * @param omatLangat
     */    
    public Kayttaja(int nro, String etunimi, ArrayList<Integer> ristipistotyot, ArrayList<Lanka> omatLangat)
    {
        setNro(nro);
        setEtunimi(etunimi);
        setRistipistotyot(ristipistotyot);
        setOmatLangat(omatLangat);      
    }      
   
    public int getNro()  {
        return nro;
    }
    
//    @XmlElement
    public void setNro(int nro) {
        this.nro = nro;
    }

     public String getEtunimi()  {
        return etunimi;
    }
    
//    @XmlElement 
    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public ArrayList getRistipistotyot()  {
        return ristipistotyot;
    }
    
//    @XmlElement
    public void setRistipistotyot(ArrayList<Integer> ristipistotyot) {
        this.ristipistotyot = ristipistotyot;
    }
    
    public ArrayList getOmatLangat()  {
        return omatLangat;
    }
    
//    @XmlElement
    @XmlElement(type = Lanka.class)
    public void setOmatLangat(ArrayList<Lanka> omatLangat) {
        this.omatLangat = omatLangat;
    }
    
     /**
     * Tulostetaan Kayttajan tiedot
     */
    @Override
    public String toString()
    {
        return nro + ", " 
                + etunimi + ", "
                + omatLangat + ", "
                + ristipistotyot + ".";               
    } 
    
   public void aja() throws Exception{
    //luodaan lista Kayttaja-tyyppisille olioille
    ArrayList<Kayttaja> kayttajaLista = new ArrayList<Kayttaja>();
    while (true)
    {
        Scanner lukija = new Scanner(System.in);
        int valinta;

        System.out.println("Valitse toiminto: ");
        System.out.println("1. Käyttjän lisäys");
        System.out.println("2. Käyttäjän haku");
        System.out.println("3. Käyttäjän poisto");
        System.out.println("4. Käyttjäjälista");
        System.out.println("0. Lopeta");         
        valinta = lukija.nextInt();

//        switch (valinta) {
//            case 1:
//            lisaaKayttaja(kayttajaLista);
//            break;
//            case 2:
//            etsiKayttaja(kayttajaLista);
//            break;
////                case 3:
////                poistaLanka(lankaLista);
////                break;
//            case 4:
//            tulostaKayttaja(kayttajaLista);
//            break;
//            case 0:
//            System.out.println("Kiitos ohjelman käytöstä!");
//
//            //Tallennetaan tiedosto talteen seuraavaa kertaa varten
//            Tiedosto tiedosto = new Tiedosto();
//            String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\kayttaja.txt";
////                String tiedNimi = "C:\\Omat\\testi.txt";
//
//            tiedosto.Tallenna(tiedNimi, kayttajaLista);
////                tiedosto.LataaTiedosto(tiedNimi);
//
//            System.exit(0);
//            default:
//            System.out.println("Virheellinen valinta.");
//        }
    }
}  
   
    public void lisaaKayttaja(ArrayList<Kayttaja> kayttajaLista) throws Exception {
    
        XmlKasittely xmlKasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\kayttaja.xml";   
        
        try {        
            xmlKasittely.KirjoitaKayttajaXML(kayttajaLista, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

//private void lisaaKayttaja(ArrayList<Kayttaja> kayttajaLista) {
//    // Pyydetään tiedot
//    Scanner lukija = new Scanner(System.in);
//    System.out.println("Anna käyttäjän numero: ");
//    nro = lukija.nextInt();        
//     System.out.println("Anna käyttäjän nimi: ");
//    etunimi = lukija.next();
//     System.out.println("Syötä käyttäjän omat langat (lankaid)");
//     while (lukija.hasNextInt()) {
//         int i = lukija.nextInt();
//         omatLangat.add(new Lanka());
//     }
////    omatLangat = lukija.   lukija.next();
////     System.out.println("Syötä käyttäjän omat ristipistotyöt");
////    merkki = lukija.next();
//
//    // tallennetaan ne listaan
//    kayttajaLista.add(new Kayttaja(nro, etunimi, merkki));        
//}
//
//private void tulostaLanka(ArrayList<Lanka> lankaLista)
//{
//    // tulostetaan, jos listassa on jotain
//    if (lankaLista.size() > 0)
//        // loopataan läpi ja tulostetaan
//        {
//            for (int i = 0; i < lankaLista.size(); i++) {
//                System.out.println(lankaLista.get(i));
//        }
//    }
//    // jos ei ole mitään, tulostetaan
//    else    
//        System.out.println("Listassa ei ole vielä tuotteita");
//}
//
//private void etsiLanka(ArrayList<Lanka> lankaLista) {
//    // jos listassa on jotakin,
//    if (lankaLista.size() > 0) {
//   Scanner lukija = new Scanner(System.in);
//    String etsittava;
//    boolean loytyiko = false;
//
//    System.out.println("Anna etsittävän tuotteen langan merkki");
//    etsittava = lukija.nextLine();
//
//    // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
//    for (int i = 0; i < lankaLista.size(); i++) {
//    // jos tuoteListan rivillä i oleva Nimi-muuttuja on juuri sama
//    // kuin etsittävä String,
//    if (lankaLista.get(i).getMerkki().toUpperCase().trim()
//    .equals(etsittava.trim().toUpperCase())) {
//    // tulostetaan,
//    System.out.println(lankaLista.get(i));
//    // ja muutetaan boolean todeksi.
//    loytyiko = true;
//    }
//    }
//    // jos boolean ei ole muuttunut todeksi, ei ole löytynyt.
//    if (loytyiko == false)
//    System.out.println("Tuotetta " + etsittava + " ei löytynyt.");
//    // jos lista oli nollan pituinen, siinä ei varmaan ollut mitään.
//    } else
//    System.out.println("Listassa ei ole vielä tuotteita.");
//}           
}
