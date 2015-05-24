/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka käsittelee langan tietoja. Langat koostuvat aina nimestä ja
 * numerosta. Esim. DMC 365. Molemmat ovat pakollisia tietoja.
 * @author Katja
 */
public class Lanka implements Serializable {
    
    int lankaid;
    private int merkkinro;
    private String merkki;
    
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
    
    public void setLankaid(int lankaid) {
        this.lankaid = lankaid;
    }

    public int getLankanro()
    {return merkkinro;}
    
    public void setLankanro(int lankanro) {
        this.merkkinro = lankanro;
    }
    
    public String getMerkki()
    {
        return merkki;
    }

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
        return lankaid + ", " 
                + merkki + ", " 
                + merkkinro + ".";    
    }  
    
    public void aja() throws Exception{
        //luodaan lista Lanka-tyyppisille olioille
        ArrayList<Lanka> lankaLista = new ArrayList<Lanka>();
        while (true)
        {
            Scanner lukija = new Scanner(System.in);
            int valinta;
            
            System.out.println("1. Tuotteen lisäys");
            System.out.println("2. Tuotteen haku");
            System.out.println("3. Tuotteen poisto");
            System.out.println("4. Tuotelista");
            System.out.println("0. Lopeta");
            System.out.println("Valitse: ");
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
//                Tiedosto tiedosto = new Tiedosto();
                String tiedNimi = "C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\testi3.ser";
//                tiedosto.TallennaOlio(tiedNimi, lankaLista);
                TallennaTiedostoon(tiedNimi, lankaLista);
                LataaTiedosto(tiedNimi, lankaLista);
                System.exit(0);
                default:
                System.out.println("Virheellinen valinta.");
            }
        }
    }
    

    private void lisaaLanka(ArrayList<Lanka> lankaLista) {
        // Pyydetään tiedot
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna tuotteen id (yksilöivä nro): ");
        lankaid = lukija.nextInt();
         System.out.println("Anna langan merkki, esim. DMC");
        merkki = lukija.next();
         System.out.println("Anna langan nro: ");
        merkkinro = lukija.nextInt();    
        
        // tallennetaan ne listaan
        lankaLista.add(new Lanka(lankaid, merkkinro, merkki));        
    }
    
    private void tulostaLanka(ArrayList<Lanka> lankaLista)
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

    private void etsiLanka(ArrayList<Lanka> lankaLista) {
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
    
    public void TallennaTiedostoon(String tiedNimi, ArrayList lista){
          try {    
                    
         //   ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tiedNimi, true)));
         FileOutputStream fout = new FileOutputStream(tiedNimi, true);
         ObjectOutputStream out = new ObjectOutputStream(fout);
         
                System.out.println(lista);
                out.writeObject(lista);
                
                out.writeObject(lista);      // Talletetaan olio           
                out.close();                      // Suljetaan virta
            }
        
        catch(Exception virhe)
    {
      System.err.println(virhe.getMessage());
      System.exit(-1);                  // Lopetetaan tähän
    }
    }
    
     public void LataaTiedosto(String tiedNimi, ArrayList lista) throws Exception
    {
//       try {
          ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(tiedNimi));
 
// start getting the objects out in the order in which they were written
ArrayList lanka = (ArrayList) objectInputStream.readObject();
System.out.println("lopullinen lanka"+lanka);
System.out.println(objectInputStream.readBoolean());
System.out.println(objectInputStream.readFloat());
 
// get the course object
//Course readCourse = (Course) objectInputStream.readObject();
//System.out.println(readCourse.getName());
//Student student1Read = readCourse.getStudents().get(0);
//System.out.println(student1Read.getAge());
//System.out.println(student1Read.getName());
objectInputStream.close();
      

//    } catch (Exception e) {
//
//        e.printStackTrace();
// }finally {
//        if(objectinputstream != null){
//            objectinputstream .close();
//         } 
//}
      
    }
            
   }  


