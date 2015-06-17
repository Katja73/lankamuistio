# RISTIPISTOTYÖOHJELMA – OHJEET

**1.	Yleistä**
Ohjelmalla pystyy syöttämään ristipistotyössä tarvittavia tietoja. Ohjelman ensimmäisessä versiossa pystyy tekemään seuraavat tallennukset:
-	Syöttämään lankoja
-	Syöttämään kankaita
-	Syöttämään yhden ristipistotyön kerrallaan
-	Syöttämään yhden käyttäjän kerrallaan.

Seuraavassa versiossa tulee mahdolliseksi useamman käyttäjän ja ristipistotyön syöttäminen.

HUOM! .JAR pitää ajaa kansiossa, jossa on kirjoitusoikeudet. XML –sanomat tallentuvat tähän kansioon. Myöhemmin ohjelmaan on tarkoitus lisätä tietokanta.

Yksikkötestit pitää ajaa sellaisessa kansiossa, jossa on polku src\testitiedostot -kansio. Muuten kaikki testit eivät käänny.

**2.	Ohjelmassa olevat toiminnalliset puutteet ja virheet:**
-	Tässä versiossa ei pysty syöttämään kuin yhden käyttäjän. Seuraavan syöttäminen tuhoaa edellisen. Ei myöskään pysty syöttämään kuin yhden ristipistotyön kerrallaan. Uuden tallentaminen tuhoaa edellisen. 

-	Käyttäjiä tai ristipistotöitä ei voi tarkastella kuin XML –tiedostojen kautta. Niille ei ole tarjolla omaa näyttöikkunaa.

-	Lankojen ja kankaiden tallennuksessa ei ole poistoa tai muokkausta. Tässä versiossa voi vain lisätä uusia kankaita tai lankoja.

-	Eri kohtien id:t eivät tule sekvenssistä. Tämä mahdollistetaan seuraaviin versioihin.

**3.	Ohjeet**
**3.1.	Päävalikko**

Painikkeet:
- Langat: Avaa Langat –ikkunan
- Kankaat: Avaa Kankaat ikkunan
- Ristipistotyöt: Avaa ristipistotyöt –ikkunan
- Käyttäjät: Avaa Käyttäjät –ikkunan
- Lopeta: Ohjelma suljetaan

Aloita syöttämällä langat ja kankaat. Sen jälkeen syötä ristipistotyöt.  Näin ne ovat käytössä valmiina Käyttäjät -näytössä.
 
**3.2.	Langat –ikkuna**

Kentät
- Langan id: 	Pakollisuus: Pakollinen, numeerinen kenttä.
Selitys: Langan id on yksilöivä numeerinen tunniste. Kannattaa katsoa Näytä langat –painikkeella jo valmiina olevat langat, ja ottaa seuraava numero. Samalla numerolla ei voi syöttää uutta lankaa. Ohjelma ei ilmoita päällekkäisyydestä, mutta lanka ei tallennu.

- Merkin nro:	Pakollisuus: Pakollinen, numeerinen kenttä.
  
Selitys: Jokaisella langalla on oma yksilöivä tunnistenumero ja merkki. Tähän syötetään langan värin numero, esim.    456 (DMC)

- Merkki: 	Pakollisuus: Pakollinen

Selitys: Tähän tulee langan merkki, joka yhdessä Merkin nro:n kanssa yksilöi värin. Töissä värit ilmoitetaan aina merkki + nro –muodossa. Esim. DMC 345 tai Anchor 1050.

Painikkeet
- Näytä langat: Näytetään jo valmiina olevat langat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
- Tallenna: Tallennetaan langat
- Palaa päävalikkoon: Palataan päävalikkoon 

**3.3.	Kankaat –ikkuna**
 
Kentät

- Kangas id: 	Pakollisuus: Pakollinen, numeerinen kenttä

Selitys: Kankaan id on yksilöivä numeerinen tunniste. Kannattaa katsoa Näytä kankaat –painikkeella jo valmiina olevat kankaat, ja ottaa seuraava numero.  Samalla numerolla ei voi syöttää uutta kangasta. Ohjelma ei ilmoita päällekkäisyydestä, mutta kangas ei tallennu.

- Kangasmerkki: 
Pakollisuus: Pakollinen
Selitys: Tähän tulee kankaan merkki. Kangas voi olla merkiltään mikä tahansa. Yleisimmät ovat Aida ja Pellava. Halutessaan kenttään voi kirjoittaa myös kankaan koon. Se ilmoitetaan numerona nimen perässä. Esim. Aida 18. Mitä suurempi numero, sen tiheämpi kangas.

Painikkeet

- Näytä kankaat: Näytetään jo valmiina olevat kankaat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
- Tallenna: Tallennetaan kankaat.
- Palaa päävalikkoon: Palataan päävalikkoon

**3.4.	Käyttäjät –ikkuna**
 
Kentät
- Käyttäjän nro: 
Pakollisuus: Pakollinen, numeerinen kenttä

Selitys: Käyttäjän nro on yksilöivä numeerinen tunniste. Tämän hetken tallentaa aina edellisen päälle, joten numeroksi voi antaa mitä vaan. 

- Käyttäjän etunimi: 	
Pakollisuus: Pakollinen
Selitys: Käyttäjän nimi. Pelkkä etunimi riittää. 

- Langan nro: 	Pakollisuus: Yksi lanka on pakollinen, numeerinen kenttä
Selitys:  Omat langat kohtaan voi syöttää maksimissaan neljä eri lankaa. Ohjelma tekee tarkistuksen, ovatko langat jo olemassa joten kannattaa painaa Näytä langat –painiketta, jotta saa näkyviin kaikki tiedostoon tallennetut langat. 
- Määrä:	Pakollisuus: Ensimmäisen langan määrä on pakollinen, mutta siihen voidaan syöttää myös 0. Numeerinen kenttä. Muiden määrä on pakollinen vain, jos myös lanka on syötetty.
Selitys: Kuinka monta tokkaa kyseistä lankaa käyttäjällä on (langat myydään tokissa). Yksi tokka sisältää n. 8 metriä lankaa.

- Osta:	Pakollisuus: Ei pakollinen.
	Selitys: Tähän valitaan, jos käyttäjä haluaa tallentaa tiedon, että lankaa pitää ostaa lisää. Ominaisuutta hyödynnetään seuraaviin versioihin tulevissa ostoslista –toiminnoissa.

Painikkeet
- Näytä langat: Näytetään jo valmiina olevat langat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
- Näytä ristipistotyöt: Näytetään jo valmiina oleva ristipistotyö taulukossa. Tässä versiossa on näkyvissä vain yksi työ, josta näkyy työn id ja nimi. Työtä tuplaklikkaamalla se valitaan käyttäjän työksi. Valittu rivi muuttuu punaiseksi.
- Tallenna: Tallennetaan käyttäjän tiedot.
- Palaa päävalikkoon: Palataan päävalikkoon

**3.5.	Ristipistotyöt –ikkuna**

Kentät
- Työn nro:  	Pakollisuus: Pakollinen, numeerinen kenttä
Selitys: työn nro on yksilöivä numeerinen tunniste. Tämän hetken versio tallentaa aina edellisen päälle, joten numeroksi voi antaa mitä vaan. 

- Nimi: 	Pakollisuus: Pakollinen, numeerinen kenttä
Selitys: Työn nimi

- Leveys: 	Pakollisuus: Pakollinen, numeerinen kenttä
Selitys: Työn leveys pistojen määränä

- Korkeus:	Pakollisuus: Pakollinen, numeerinen kenttä
  Selitys: Työn korkeus pistojen määränä 

- Langan nro: 	Pakollisuus: Yksi lanka on pakollinen, numeerinen kenttä
Selitys:  Omat langat kohtaan voi syöttää maksimissaan neljä eri lankaa. Ohjelma tekee tarkistuksen, ovatko langat jo olemassa, joten paina Näytä langat –painiketta, jotta saat näkyviin kaikki tiedostoon tallennetut langat. 

- Määrä:	Pakollisuus: Ensimmäisen langan määrä on pakollinen, mutta siihen voidaan syöttää myös 0. Numeerinen kenttä. Muiden määrä on pakollinen vain, jos myös lanka on syötetty.
Selitys: Kuinka monta tokkaa kyseistä lankaa tarvitaan työhön. Tokat ilmoitetaan kokonaislukuna. 

- Kangas:	Pakollisuus: Pakollinen. Pitää valita joku olemassa oleva id.	
Selitys: Syötetään kankaan id. Kankaat saadaan näkyviin Näytä kankaat –painikkeella. Kankaaksi pitää valita, joku listan id –numeroista. 

Painikkeet
- Näytä langat: Näytetään langat taulukossa. Taulukkoa ei voi muokata.
- Näytä kankaat: Näytetään kankaat taulukossa. Taulukkoa ei voi muokata.
- Tallenna: Tallennetaan ristipistotyön tiedot.
- Palaa päävalikkoon: Palataan päävalikkoon


