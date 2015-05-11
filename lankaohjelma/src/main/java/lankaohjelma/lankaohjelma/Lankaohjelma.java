/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

/**
 *
 * @author Katja
 */
public class Lankaohjelma {
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Katjan lankamaailma");
        System.out.println("Ei viela koodia");
        System.out.println("");
        
        // Kysytaan, haluaako aloittaa tai jatkaa tyota, vai syottaa lankoja
        
        
        // Valitun mukaan jatketaan, avataan kÃ¤yttÃ¶liittymÃ¤ sen mukaan
    }
    
    /** Metodi avaa valitun toiminnon ikkunan, riippuen parametrista
     * 
     * @param toiminto Kayttajan antama toimintokoodi    
     */
    public void ValittuToiminto(int toiminto)
    {
        if (toiminto == 1) 
        {
             System.out.println("Avataan tyoikkuna");   
        }
        else
        {   
            System.out.println("Avataan lankaikkuna");
        }
     }
    
}
