/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.io.Serializable;
import java.util.Scanner;

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
    
    /**
     * Tulostetaan merkin tiedot
     * @return merkkinro ja merkki
     */
    @Override
    public String toString()
    {
        return kangasnro + ", " 
                + kangasMerkki + ".";    
    } 
    
    /**
     * Metodi, josta luokkaa voidaan ajaa
     */
    public void kayta() throws Exception{
        
        Scanner lukija = new Scanner(System.in);
        //luodaan taulukko, johon mahtuu 20 kangas-luokkaan kuuluvaa oliota
        Kangas kangasTaulukko[] = new Kangas[20];
        int valinta;

        while (true) {
        //annetaan käyttäjälle vaihtoehdot ikuisessa loopissa
        System.out.println("Valitse toiminto: ");
        System.out.println("1. Lisää kangas");
        System.out.println("2. Etsi kangas");
        System.out.println("3. Tulosta kaikki kangaat");
        System.out.println("4. Lopeta");
        valinta = lukija.nextInt();

        //valitaan switchillä, mitä metodia kulloinkin ajetaan (tai lopetetaanko ohjelma tms)
        switch (valinta) {
        case 1:
        lisaaKangas(kangasTaulukko);
        break;
        case 2:
        etsiKangas(kangasTaulukko);
        break;
        case 3:
        tulostaKankaat(kangasTaulukko);
        break;
        case 4:
        System.out.println("Kiitos ohjelman käytöstä!");
        //Tallennetaan tiedosto talteen seuraavaa kertaa varten
                Tiedosto tiedosto = new Tiedosto();
                String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testi4.txt";
                tiedosto.TallennaOlio(tiedNimi, kangasTaulukko);
        System.exit(0);
        default:
        System.out.println("Virheellinen valinta.");        
        }
    }
    }

    private void lisaaKangas(Kangas[] kangasTaulukko) {
        Scanner lukija = new Scanner(System.in);

        int tallennuspaikka = 0;
        //etsitään tyhjä tallennuspaikka;
        //katsotaan niin kauan kuin taulukkoa riittää onko taulukon rivi tyhjä.
        while (tallennuspaikka < kangasTaulukko.length) {
        
        //jos on, breikki.
        if (kangasTaulukko[tallennuspaikka] == null)
            break;
        else
            tallennuspaikka++;
        }
        
        //jos taulukkoon mahtuu
        if (tallennuspaikka < kangasTaulukko.length) {
        
            //luodaan uusi Kappale-luokan olio kyseiseen tallennuspaikkaan
            kangasTaulukko[tallennuspaikka] = new Kangas();
            int kangasnro1;
            String kangasMerkki1;        

            //ja pyydetään käyttäjältä arvot riveille

            System.out.print("Anna kankaan nro: ");
            kangasnro1 = lukija.nextInt();

            //taulukon tallennuspaikka-riville asetetaan arvoksi saveltaja-muuttuja setSaveltaja-metodin avulla
            kangasTaulukko[tallennuspaikka].setKangasnro(kangasnro1);

            System.out.print("Anna kankaan merkki, esim. Aida: ");
            kangasMerkki1 = lukija.next();
            
            kangasTaulukko[tallennuspaikka].setKangasMerkki(kangasMerkki1);
        } 
        else
            //jos tallennuspaikan arvo oli suurempi kuin taulukon viimeisen ruudun sijanumero, tulostetaan tämä.
            System.out.println("Olet tallentanut maksimimäärän kankaita, et voi tallentaa niitä enempää!");
    }    
    
    private void LisaaKangasTiedostoon()
    {
        
    }

    private void tulostaKankaat(Kangas[] kangasTaulukko) {
        //jos taulukon ensimmäisessäkään rivissä ei ole mitään arvoa, tulostetaan tämä
        if (kangasTaulukko[0] == null) {
        System.out.println("Et ole vielä antanut kankaita.");
        }
        else
        //jos arvoja on, tulostetaan niitä niin kauan kunnes joko koko taulukko on tulostettu tai vastaan tulee tyhjä solu
        for (int i = 0; i < kangasTaulukko.length && kangasTaulukko[i]!=null; i++) 
        {
            //tulostamiseen käytetään Kappale-luokan toString-metodia
            System.out.println(kangasTaulukko[i].toString());
        }
    }

    private void etsiKangas(Kangas[] kangasTaulukko) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna etsittävän kankaan nimi: ");
        String etsittava = lukija.nextLine();

        //alustetaan ”loytyi” epätodeksi
        boolean loytyi = false;

        //käydään taulukkoa läpi niin kauan kuin sitä riittää/siinä riittää arvoja
        for (int i = 0; i < kangasTaulukko.length && kangasTaulukko[i] != null; i++) {

        //katsotaan järjestyksessä jokainen rivi,
        if (kangasTaulukko[i].getKangasMerkki().toUpperCase()
                .indexOf(etsittava.trim().toUpperCase()) >= 0) {
            
                //jos merkki löytyi riviltä i, printataan rivi toStringillä
                System.out.println(kangasTaulukko[i].toString());

                //ja käännetään löytyi-vipu todeksi.
                loytyi = true;
                
                //jatketaan for-loopin alkuun
            }
        }

        //jos vipua ei ole käännetty tosi-asentoon, tulostetaan tämä.
        if (!loytyi)
            System.out.println("Antamaasi kangasta ei löytynyt.\n");
        else
            //muuten printataan tyhjä rivi selkeyden vuoksi.
            System.out.println();
    }
}
