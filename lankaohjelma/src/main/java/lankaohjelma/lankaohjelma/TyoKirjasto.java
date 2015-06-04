package lankaohjelma.lankaohjelma;


import java.util.ArrayList;
import java.util.Scanner;
import lankaohjelma.perusluokat.Kangas;
import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.RistipistoTyo;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Katja
 */
public class TyoKirjasto {
    
    private RistipistoTyo[] tyoTaulukko;
    private int lkm;
    
    /**
     * Oletuskonstruktori
     */
    public TyoKirjasto()
    {
    // Luodaan lista RistipistoTyo -tyyppisille olioille
        ArrayList<RistipistoTyo> tyoLista = new ArrayList<RistipistoTyo>();
        
        //loopataan taulukkoa
        while (true){
            Scanner lukija = new Scanner(System.in);
            int valinta;
        }      
    }
 /*   
    public void aja()
    {   
        // Annetaan käyttäjälle vaihtoehto
        while (true)
        {
        System.out.println("1. Lisää työ");
        System.out.println("2. Etsi työ");
        System.out.println("3. Poista työ");
        System.out.println("4. Tulosta työt");
        System.out.println("0. Lopeta");
        System.out.println("Valitse: ");
        valinta = lukija.nextInt();
    
        // Mennään oikeaan metodiin
        switch (valinta) {
            case 1:
            lisaaTyo();
            break;
            case 2:
            etsiTyo();
            break;
            case 3:
            poistaTyo();
            break;
            case 4:
            tulostaTyot();
            break;
            case 0:
            System.out.println(”Kiitos ohjelman käytöstä!”);
            System.exit(0);
            default:
            System.out.println(”Virheellinen valinta.”);
            }       
        }
    }
   */
    
    /**
     * Lisätään uusi ristipistotyö
     * @param uusiTyo
     */
    /*
    public void lisaaTyo()
    {
        Scanner lukija = new Scanner(System.in);
        ArrayList langat = null;
        Kangas kangas = null;
        Kayttaja tyonTekija = null;
        int leveys;
        int korkeus;
        
        if (lkm<tyoTaulukko.length)
        {
            // pyydetään työn tiedot
            //System.out.println("Pyydetään langat tiedot");
            //System.out.println("Anna kangas");
            //kangas = lukija.next();
            //System.out.println("Anna työn tekijän nimi");
            //tyonTekija = lukija.n
            System.out.println("Anna työn leveys pistoina");
            leveys = lukija.nextInt();
            System.out.println("Anna työn korkeus pistoina");
            korkeus = lukija.nextInt();
            
            //täytetään ne ensimmäiseen vapaaseen riviin
            tyoTaulukko[lkm] = new RistipistoTyo(langat, kangas, tyonTekija, leveys, korkeus);
            lkm++;       
        }
        
        // jos viimeinenkin rivi oli käytetty, tulostetaan tämä 
        else 
            System.out.println("Olet jo tallentanut maksimimäärän ristipistotöitä");
            System.out.println();    
    }
    */
    /*
     private void etsiTyo() {
        Scanner lukija = new Scanner(System.in);
        String etsittava;
        boolean loytyi = false;

        //jos edes jollakin rivillä on jo tietoja
        if (lkm > 0) {
        
            //pyydetään hakuehto            
            System.out.println("Anna etsittävän tyon tekija:");
            etsittava = lukija.next();

            //ja käydään läpi kaikki täytetyt rivit – myös rodun nimen osa kelpaa
            for (int i = 0; i < lkm; i++) {
            if (tyoTaulukko[i].getKayttaja().indexOf(etsittava.trim().toUpperCase()) >= 0) {

        //tulostetaan koiran tiedot
        System.out.println(tyoTaulukko[i].toString());
        //ja käännetään boolean todeksi.
        loytyi = true;
        }
    */
    /**
     * Tulostetaan ristipistotyöt
     */
    public void TulostaTyot()
    {}   

   
}
