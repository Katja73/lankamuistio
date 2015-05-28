/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.util.ArrayList;

/**
 * Kayttajan omat langat
 * @author Katja
 */
class LankaKokoelma {
    
    private Lanka lanka;
    private int maara;
    private boolean osta;
    
    /**
     * Oletuskonstruktori
     */
    public LankaKokoelma()
    {       
        setLanka(null);
        setMaara(0);
        setOsta(false);      
    }

    public LankaKokoelma(Lanka lanka, int maara, boolean osta)
    {
        setLanka(lanka);
        setMaara(maara);
        setOsta(osta);       
    }    
   
    public Lanka getLanka()  {
        return lanka;
    }
    
    public void setLanka(Lanka lanka) {
        this.lanka = lanka;
    }
    
    public int getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        this.maara = maara;
    }
    
    public boolean getOsta() {
        return osta;
    }

    public void setOsta(boolean osta) {
        this.osta = osta;
    }   
    
    /**
     * Tulostetaan lankakokoelman tiedot
     */
    @Override
    public String toString()
    {
        return lanka + ", " 
                + maara + ", "
                + osta + ". ";    
    }    
}
