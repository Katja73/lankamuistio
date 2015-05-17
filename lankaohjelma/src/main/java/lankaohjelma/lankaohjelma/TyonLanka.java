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
public class TyonLanka {
    
    private int lankanro;
    private LankaMerkki lankamerkki;
    
     /**
     * Oletuskonstruktori
     */
    public TyonLanka()
    {
        setLankanro(0);
        setLankamerkki(null);        
    }
    
    /**
     * Parametrit vastaanottava konstruktori
     * @param lankanro
     * @param lankamerkki
     */
    public TyonLanka(int lankanro, LankaMerkki lankamerkki)
    {
        setLankanro(lankanro);
        setLankamerkki(lankamerkki);        
    }

    private void setLankanro(int lankanro) {
       this.lankanro = lankanro;
    }

    private void setLankamerkki(LankaMerkki lankamerkki) {
        this.lankamerkki = lankamerkki;
    }

    
}

