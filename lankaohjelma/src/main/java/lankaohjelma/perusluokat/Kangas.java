/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.perusluokat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lankaohjelma.kayttoliittyma.Kayttoliittyma;
import lankaohjelma.lankaohjelma.Tiedosto;
import lankaohjelma.lankaohjelma.XmlKasittely;

/**
 *
 * @author Katja
 */
public class Kangas implements Serializable {
    private int kangasnro;
    private String kangasMerkki;
    
    /**
     * Oletuskonstruktori
     */
    public Kangas()
    {
        setKangasnro(0);
        setKangasMerkki(null);
    }
    
    public Kangas(int kangasnro, String kangasmerkki)
    {
        setKangasnro(kangasnro);
        setKangasMerkki(kangasmerkki);
    }

    public int getKangasnro()
    {return kangasnro;}
    
    public void setKangasnro(int kangasnro) {
        this.kangasnro = kangasnro;
    }
    
    public String getKangasMerkki()
    {
        return kangasMerkki;
    }

    public void setKangasMerkki(String kangasMerkki) {
        this.kangasMerkki = kangasMerkki;
    }
    
    private int toimintokoodi;
    
    /**
     * Tulostetaan merkin tiedot
     * @return merkkinro ja merkki
     */
    @Override
    public String toString()
    {
        return kangasnro + ", " 
                + kangasMerkki;    
    } 
    
    /**
     * Metodi, josta luokkaa voidaan ajaa
     */
    public void kayta() throws Exception{
        
        // luodaan lista Kangas -tyyppisille olioille
        ArrayList<Kangas> kangasLista = new ArrayList<Kangas>();
        while (true){
                
            Scanner lukija = new Scanner(System.in);

            int valinta;
            toimintokoodi = 2;

            while (true) {
                //annetaan käyttäjälle vaihtoehdot ikuisessa loopissa
                System.out.println("Valitse toiminto: ");
                System.out.println("1. Lisää kangas");
                System.out.println("2. Etsi kangas");
                System.out.println("3. Poista kangas");
                System.out.println("4. Tulosta kaikki kankaat");
                System.out.println("0. Lopeta");
                valinta = lukija.nextInt();

                //valitaan switchillä, mitä metodia kulloinkin ajetaan (tai lopetetaanko ohjelma tms)
                switch (valinta) {
                    case 1:
                    lisaaKangas(kangasLista);
                    break;
                    case 2:
                    etsiKangas(kangasLista);
                    break;
                    case 3:
                    tulostaKankaat(kangasLista);
                    break;
                    case 0:
                    System.out.println("Kiitos ohjelman käytöstä!");

                    //Tallennetaan tiedosto talteen seuraavaa kertaa varten
                    Tiedosto tiedosto = new Tiedosto();
                    String tiedNimi = "src\\testitiedostot\\kangas.txt";
                    tiedosto.Tallenna(tiedNimi, kangasLista);
                    System.exit(0);

                    default:
                    System.out.println("Virheellinen valinta.");        
                }
            }
        }
    }

    /**
     * Lisätään kankaat 
     * @param kangasLista Lista lisättävistä kankaista
     */
    public void lisaaKangas(ArrayList <Kangas> kangasLista) {
                
        XmlKasittely xmlKasittely = new XmlKasittely();
        String tiedNimi = "src\\testitiedostot\\kangas.xml";

        try {        
            xmlKasittely.KirjoitaKangasXML(kangasLista, tiedNimi);           
        } catch (Exception ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private void tulostaKankaat(ArrayList<Kangas> kangasLista) {
        // tulostetaan, jos listassa on jotain
        if (kangasLista.size() > 0)
            // loopataan läpi ja tulostetaan
            {
                for (int i = 0; i < kangasLista.size(); i++) {
                    System.out.println(kangasLista.get(i));
            }
        }
        // jos ei ole mitään, tulostetaan
        else    
            System.out.println("Listassa ei ole vielä tuotteita");
    }

    private void etsiKangas(ArrayList<Kangas> kangasLista) {
        // jos listassa on jotakin,
        if (kangasLista.size() > 0) {
           Scanner lukija = new Scanner(System.in);
           String etsittava;
           boolean loytyiko = false;

           System.out.println("Anna etsittävän tuotteen kankaan merkki");
           etsittava = lukija.nextLine();

            // luodaan ja kysellään juttuja ja etsiskellään lista läpi.
            for (int i = 0; i < kangasLista.size(); i++) {
                // jos tuoteListan rivillä i oleva Merkki-muuttuja on juuri sama
                // kuin etsittävä String,
                if (kangasLista.get(i).getKangasMerkki().toUpperCase().trim()
                .equals(etsittava.trim().toUpperCase())) {
                // tulostetaan,
                System.out.println(kangasLista.get(i));
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