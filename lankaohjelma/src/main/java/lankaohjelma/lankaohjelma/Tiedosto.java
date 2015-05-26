/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
     * Ladataan yksittäinen ArrayList
     * @param tiedNimi
     * @return ArrayListin
     * @throws Exception
     */
    public ArrayList LataaTiedosto(String tiedNimi) throws Exception
    {
        ArrayList paluulista = new ArrayList();
        File nimi = new File(tiedNimi);
        if (!nimi.exists()) {
            System.out.println("Tiedostoa "+nimi+" ei löydy!");
            return null; // keskeytetään kaikki!
        }
    
        BufferedReader syotto =  new BufferedReader(new InputStreamReader(
                      new FileInputStream(nimi)));

        String rivi = "";
        rivi = syotto.readLine();
        
        while (rivi != null ){
            System.out.println("**testirivi: **"+rivi);
                  
        // Konvertoidaan string Arraylistiksi. 
        //Tehdään ensin taulukko
        //String[] myStringArray = new String[]{rivi.split(",")};
        String[] riviArvot = rivi.split(",");
        System.out.println("**riviArvot**"+riviArvot);
        Collections.addAll(paluulista, riviArvot);
          rivi = syotto.readLine();

        }
        //String[] riviArvot = rivi.split(",");
        //System.out.println("**arvot: **"+riviArvot);
        
        // Lisätään taulukko ArrayListalle
      //ArrayList<String> arvot = new ArrayList<String>(Arrays.asList(riviArvot));   
        
        
        //System.out.println("**testirivitt: **"+arvot);
        
        //paluulista.add(arvot);
        
        
        System.out.println("**testipaluu: **"+paluulista);
        return paluulista;
        
    }   
    
     public void TallennaOlio(String tiedNimi, Object obj ) throws Exception
    {
        try {    
                    
         //   ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tiedNimi, true)));
         FileOutputStream fout = new FileOutputStream(tiedNimi, true);
         ObjectOutputStream out = new ObjectOutputStream(fout);
         
                System.out.println(obj);
                out.writeObject(obj);
                
                out.writeObject(obj);      // Talletetaan olio           
                out.close();                      // Suljetaan virta
            }
        
        catch(Exception virhe)
    {
      System.err.println(virhe.getMessage());
      System.exit(-1);                  // Lopetetaan tähän
    }
    }
    
//    public void LataaOlioTiedosto(String tiedNimi, Object obj) throws Exception
//    {
//       try {
//           FileInputStream streamIn = new FileInputStream(tiedNimi);
//        ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
//        List<MyClass> readCase = (List<MyClass>) objectinputstream.readObject();
//        recordList.add(readCase);
//        System.out.println(recordList.get(i));
//
//    } catch (Exception e) {
//
//        e.printStackTrace();
// }finally {
//        if(objectinputstream != null){
//            objectinputstream .close();
//         } 
// }
//      
//    }
}
