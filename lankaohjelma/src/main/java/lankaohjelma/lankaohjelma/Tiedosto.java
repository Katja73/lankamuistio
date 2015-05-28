/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Katja
 */
public class Tiedosto implements Serializable {  
    
    /**
     * Tallennetaan parametrina saatu tiedosto
     * @param tiedNimi Tiedoston nimi
     * @param lista Tiedoston tiedot     
     * @throws Exception
     */
    public void Tallenna(String tiedNimi, ArrayList lista) throws Exception
    {
        PrintWriter tiedosto = new PrintWriter (new File(tiedNimi));
        int maara = lista.size();
     
        for (int i = 0; i < maara; i++) {
            tiedosto.println(lista.get(i));  
        }      
        tiedosto.close();      	  
    }  
    
    /**
     * Ladataan yksittainen ArrayList
     * @param tiedNimi     
     * @return ArrayListin
     * @throws Exception
     */
    public ArrayList LataaLankaTiedosto(String tiedNimi) throws Exception
    {
        ArrayList<Lanka> paluulista = new ArrayList();
        File nimi = new File(tiedNimi);
        if (!nimi.exists()) {
            System.out.println("Tiedostoa "+nimi+" ei loydy!");
            return null; // keskeytetaan kaikki!
        }
    
        BufferedReader syotto =  new BufferedReader(new InputStreamReader(
                      new FileInputStream(nimi)));

        String rivi = "";
        rivi = syotto.readLine();
        
        while (rivi != null ){
          
            // Konvertoidaan string Arraylistiksi. 
            String[] riviArvot = rivi.split(",");
                  
            Lanka omaLanka = new Lanka(Integer.parseInt(riviArvot[0]), Integer.parseInt(riviArvot[1]), riviArvot[2]);
          
            paluulista.add(omaLanka);
            rivi = syotto.readLine();
        }
        return paluulista;
    }  
    
     /**
     * Ladataan yksittainen kangas ArrayList
     * @param tiedNimi     
     * @return ArrayListin
     * @throws Exception
     */
    public ArrayList LataaKangasTiedosto(String tiedNimi) throws Exception
    {
        ArrayList<Kangas> paluulista = new ArrayList();
        File nimi = new File(tiedNimi);
        if (!nimi.exists()) {
            System.out.println("Tiedostoa "+nimi+" ei loydy!");
            return null; // keskeytetaan kaikki!
        }
    
        BufferedReader syotto =  new BufferedReader(new InputStreamReader(
                      new FileInputStream(nimi)));

        String rivi = "";
        rivi = syotto.readLine();
        
        while (rivi != null ){
          
            // Konvertoidaan string Arraylistiksi. 
            String[] riviArvot = rivi.split(",");
                  
            Kangas omaKangas = new Kangas(Integer.parseInt(riviArvot[0]), riviArvot[1]);
          
            paluulista.add(omaKangas);
            rivi = syotto.readLine();
        }
        return paluulista;
    }  
}
