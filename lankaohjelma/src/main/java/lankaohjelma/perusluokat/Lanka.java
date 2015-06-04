/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import lankaohjelma.kayttoliittyma.Kayttoliittyma;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lankaohjelma.lankaohjelma.Tiedosto;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 * Luokka käsittelee langan tietoja. Langat koostuvat aina nimestä ja
 * numerosta. Esim. DMC 365. Molemmat ovat pakollisia tietoja.
 * @author Katja
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Lanka implements Serializable {
    
    private int lankaid;
    private int merkkinro;
    private String merkki;
    
    private int toimintokoodi;
    
    /**
     * Oletuskonstruktori
     */
    
    public Lanka()
    {
        setLankaid(0);
        setLankanro(0);
        setMerkki(null);
    }
    
    /**
     *
     * 
     * @param lankaid
     * @param lankanro
     * @param merkki
     */
    public Lanka(int lankaid, int lankanro, String merkki)
    {
        setLankaid(lankaid);
        setLankanro(lankanro);
        setMerkki(merkki);
    }
    
    public int getLankaid()
    {return lankaid;}
    
//    @XmlElement
    public void setLankaid(int lankaid) {
        this.lankaid = lankaid;
    }

    public int getLankanro()
    {return merkkinro;}
    
//    @XmlElement
    public void setLankanro(int lankanro) {
        this.merkkinro = lankanro;
    }
    
    public String getMerkki()
    {
        return merkki;
    }

//    @XmlElement
    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
    
    /**
     * Tulostetaan merkin tiedot
     * @return lankaid, merkkinro ja merkki
     */
    @Override
    public String toString()
    {
        return lankaid + ","                 
                + merkkinro + ","
                + merkki;    
    }  
    
    public void aja() throws Exception{
        //luodaan lista Lanka-tyyppisille olioille
        ArrayList<Lanka> lankaLista = new ArrayList<Lanka>();
        while (true)
        {
            Scanner lukija = new Scanner(System.in);
            int valinta;
                        
            System.out.println("Valitse toiminto: ");
            System.out.println("1. Langan lisäys");
            System.out.println("2. Langan haku");
            System.out.println("3. Langan poisto");
            System.out.println("4. Lankalista");
            System.out.println("0. Lopeta");         
            valinta = lukija.nextInt();
            
            switch (valinta) {
                case 1:
                lisaaLanka(lankaLista);
                break;
                case 2:
                etsiLanka(lankaLista);
                break;
//                case 3:
//                poistaLanka(lankaLista);
//                break;
                case 4:
                tulostaLanka(lankaLista);
                break;
                case 0:
                System.out.println("Kiitos ohjelman käytöstä!");
                
                //Tallennetaan tiedosto talteen seuraavaa kertaa varten
                Tiedosto tiedosto = new Tiedosto();
                String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\lanka.ser";
//                String tiedNimi = "C:\\Omat\\testi.txt";

                tiedosto.Tallenna(tiedNimi, lankaLista);
//                tiedosto.LataaTiedosto(tiedNimi);

                System.exit(0);
                default:
                System.out.println("Virheellinen valinta.");
            }
        }
    }    

    /**
     * Lisätään lanka 
     * @param lankaLista
     * @throws Exception
     */
    public void lisaaLanka(ArrayList<Lanka> lankaLista) throws Exception {
    
        XmlKasittely xmlKasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\lanka.xml";

        try {        
            xmlKasittely.KirjoitaLankaXML(lankaLista, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * Tulostetaan langat, jotka ovat listalla
     * @param lankaLista
     */
    public void tulostaLanka(ArrayList<Lanka> lankaLista)
    {
        // tulostetaan, jos listassa on jotain
        if (lankaLista.size() > 0)
            // loopataan läpi ja tulostetaan
            {
                for (int i = 0; i < lankaLista.size(); i++) {
                    System.out.println(lankaLista.get(i));
            }
        }
        // jos ei ole mitään, tulostetaan
        else    
            System.out.println("Listassa ei ole vielä tuotteita");
    }

    public void etsiLanka(ArrayList<Lanka> lankaLista) {
        // jos listassa on jotakin,
        if (lankaLista.size() > 0) {
       Scanner lukija = new Scanner(System.in);
        String etsittava;
        boolean loytyiko = false;
        
        System.out.println("Anna etsittävän tuotteen langan merkki");
        etsittava = lukija.nextLine();

        // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
        for (int i = 0; i < lankaLista.size(); i++) {
        // jos tuoteListan rivillä i oleva Nimi-muuttuja on juuri sama
        // kuin etsittävä String,
        if (lankaLista.get(i).getMerkki().toUpperCase().trim()
        .equals(etsittava.trim().toUpperCase())) {
        // tulostetaan,
        System.out.println(lankaLista.get(i));
        // ja muutetaan boolean todeksi.
        loytyiko = true;
        }
        }
        // jos boolean ei ole muuttunut todeksi, ei ole löytynyt.
        if (loytyiko == false)
        System.out.println("Tuotetta " + etsittava + " ei löytynyt.");
        // jos lista oli nollan pituinen, siinä ei varmaan ollut mitään.
        } else
        System.out.println("Listassa ei ole vielä tuotteita.");
    }           
   } 