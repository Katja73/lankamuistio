#Aiheen kuvaus ja rakenne

**Aihe:** 
Ohjelman avulla voidaan pit�� kirjaa kaikista ristipistot�ihin tarvittavista langoista ja kankaista.
K�ytt�j� voi sy�tt�� lankoja, kankaita, yhden k�ytt�j�n ja yhden ristipistoty�n. Seuraavissa versiossa on mahdollista sy�tt�� useampi k�ytt�j� tai ristipistoty�.

Ristipistoty�n tallentavaan osuuteen sy�tet��n ty�n nimi, lankamerkki, nkangas ja kaikki langat, joita ty�h�n tarvitaan. My�hemm�ss� vaiheessa ohjelmaan lis�t��n ostoslista
-toiminto, joka voidaan generoida suoraan puuttuvista langoista.

Toisessa osassa k�ytt�j� voi sy�tt�� listalle omistamansa langat (merkki, m��r�, v�rinro).

**K�ytt�j�t:** 
Ristipistojen tekij�t.  

**Kaikkien k�ytt�jien toiminnot:**
- Ristipistoty�n sy�tt�minen. 
    - Ty�-ikkunalla voidaan sy�tt�� ty�n tiedot sis�lt�en langat, korkeus, leveys ja kangas
- Lankojen ja merkkien tietojen sy�tt�minen
- Kaikkien lankojen ja kankaiden listaus

**Jatkokehittelyn mahdollisuus**
- Mahdollisuus tallentaa kuvana v�rikarttoja
- Useamman k�ytt�j�n sy�tt�minen
- Useamman ristipistoty�n sy�tt�minen

**Ohjelman rakenne:**
Ohjelma koostuu k�ytt�liittym�st�, muutamasta kokoelma-luokasta ja muutamasta perusluokasta. Perusluokissa tehd��n ohjelman perusominaisuudet, kuten lis�ys ja etsiminen.
Kokoelmaluokat kasaavat eri asioita yhteen (esim. k�ytt�j�n lankoja ja ty�n lankoja).
XML -k�sittelyss� kirjoitetaan kaikki tiedot talteen erilaisiin XML -sanomiin. Niiss� on k�ytetty kahta erilaista rakennetta. 

Kun k�ytt�j� avaan ohjelman, h�n sy�tt�� ensin kankaat ja langat. T�t� ei ole pakotettu, mutta ohjeissa on maininta aiheesta. My�s ristipistoty�t kannattaa sy�tt�� ensin.
Viimeisen� tallennetaan k�ytt�j�. T�ille voidaan valita ty�n langat, ja kangas. Ne tallennetaan ty�n xml -tiedostoon.

K�ytt�j� -ikkunalla valitaan ty�t ja k�ytt�j�lle omat langat. N�m� ovat niit� lankoja, joita k�ytt�j�ll� on omasta takaa. 
