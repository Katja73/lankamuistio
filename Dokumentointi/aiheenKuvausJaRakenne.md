#Aiheen kuvaus ja rakenne

**Aihe:** 
Ohjelman avulla voidaan pitää kirjaa kaikista ristipistotöihin tarvittavista langoista ja kankaista.
Käyttäjä voi syöttää lankoja, kankaita, yhden käyttäjän ja yhden ristipistotyön. Seuraavissa versiossa on mahdollista syöttää useampi käyttäjä tai ristipistotyö.

Ristipistotyön tallentavaan osuuteen syötetään työn nimi, lankamerkki, nkangas ja kaikki langat, joita työhön tarvitaan. Myöhemmässä vaiheessa ohjelmaan lisätään ostoslista
-toiminto, joka voidaan generoida suoraan puuttuvista langoista.

Toisessa osassa käyttäjä voi syöttää listalle omistamansa langat (merkki, määrä, värinro).

**Käyttäjät:** 
Ristipistojen tekijät.  

**Kaikkien käyttäjien toiminnot:**
- Ristipistotyön syöttäminen. 
    - Työ-ikkunalla voidaan syöttää työn tiedot sisältäen langat, korkeus, leveys ja kangas
- Lankojen ja merkkien tietojen syöttäminen
- Kaikkien lankojen ja kankaiden listaus

**Jatkokehittelyn mahdollisuus**
- Mahdollisuus tallentaa kuvana värikarttoja
- Useamman käyttäjän syöttäminen
- Useamman ristipistotyön syöttäminen

**Ohjelman rakenne:**
Ohjelma koostuu käyttöliittymästä, muutamasta kokoelma-luokasta ja muutamasta perusluokasta. Perusluokissa tehdään ohjelman perusominaisuudet, kuten lisäys ja etsiminen.
Kokoelmaluokat kasaavat eri asioita yhteen (esim. käyttäjän lankoja ja työn lankoja).
XML -käsittelyssä kirjoitetaan kaikki tiedot talteen erilaisiin XML -sanomiin. Niissä on käytetty kahta erilaista rakennetta. 

Kun käyttäjä avaan ohjelman, hän syöttää ensin kankaat ja langat. Tätä ei ole pakotettu, mutta ohjeissa on maininta aiheesta. Myös ristipistotyöt kannattaa syöttää ensin.
Viimeisenä tallennetaan käyttäjä. Töille voidaan valita työn langat, ja kangas. Ne tallennetaan työn xml -tiedostoon.

Käyttäjä -ikkunalla valitaan työt ja käyttäjälle omat langat. Nämä ovat niitä lankoja, joita käyttäjällä on omasta takaa. 
