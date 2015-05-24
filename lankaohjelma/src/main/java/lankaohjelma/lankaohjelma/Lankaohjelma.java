/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Katja
 */
public class Lankaohjelma {
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);
        
        // Kysytaan, haluaako aloittaa tai jatkaa tyota, vai syottaa lankoja
        System.out.println("Haluatko tehdä uuden työn tai jatkaa vanhaa, vai syöttää lankoja?");
        System.out.println("Työ = 1, Langat = 2, Kankaat = 3");
        
        int tieto = Integer.parseInt(lukija.nextLine());       
        ValittuToiminto(tieto);       
    }
    
    /** Metodi avaa valitun toiminnon ikkunan, riippuen parametrista
     * 
     * @param toiminto Kayttajan antama toimintokoodi    
     */
    public static void ValittuToiminto(int toiminto) throws Exception
    {
        if (toiminto == 1) 
        {
             System.out.println("Avataan tyoikkuna");   
        }
        if (toiminto == 2)
        {   
            Lanka lanka = new Lanka();
            lanka.aja();
        }
        if (toiminto == 3)
        {
            Kangas kangas = new Kangas();
            kangas.kayta();
        }
     }
    
    public void LisaaRistipistoTyo(RistipistoTyo uusiTyo)
    {
     /**
        TyoKirjasto kirjasto = new TyoKirjasto();
        
        
        RistopistoTyo tyo = new RistopistoTyo();
        
        
        ArrayList langat = null;
        langat.add(1, "DMC");
        
        Kangas kangas = new Kangas();          
        Kayttaja kayttaja = new Kayttaja();
        
        int leveys = 10;
        int korkeus = 20;
        uusiTyo(langat, kangas, kayttaja, leveys, korkeus );
    **/
    }
    
    public void TulostaRistipistoTyot()
    {
    }
}
