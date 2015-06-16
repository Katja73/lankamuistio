#Käyttötapaukset


**Langan tallennus**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Langat -ikkunan	K1
3.	Käyttäjä syöttää langoista pakolliset tiedot. 	K2
4.	Käyttäjä ei voi tallentaa samalla id:llä uutta lankaa	K3
5.	Käyttäjä painaa Tallenna –painiketta.	

Käyttötapaukset	
K1 Tietoja voidaan syöttää seuraavista tiedoista:
•	Langan id (yksilöivä tieto)
•	Langan merkin nro
•	Langan merkki	Langan merkin nro on yksilöivä tunniste langan merkin sisällä (esim. DMC 365)
K2 Pakollisia tietoja ovat: Langan id, langan merkin nro, langan merkki	P1
K3 Jos käyttäjä yrittää syöttää samalla id:llä uutta lankaa, annetaan ilmoitus	P2

Poikkeukset	
P1 Jos joku pakollinen tieto puuttuu, annetaan huomautus V1. 
	V1 =”XX on pakollinen tieto.”

P2 Samaa lankaa ei voi syöttää uudelleen	V2=”Samalla id:llä on jo lanka”

**Langan haku**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Kayttajat tai Ristipistotyö -ikkunan	
3.	Käyttäjä painaa Nayta langat –painiketta, jolloin näyttöön tuodaan kaikki xml:n tallennetut langat. 	K1, K2
	
Käyttötapaukset	

K1 Listalla näkyy 
•	Langan id
•	Langan merkin nro
•	Langan merkki	
K2 Jos listalla ei ole lankoja, ei näytetä mitään.	

Poikkeukset	
	
**Kankaan tallennus**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Kangas -ikkunan	K1
3.	Käyttäjä syöttää kankaasta pakolliset tiedot.
	K2
4.	Käyttäjä ei voi tallentaa samalla id:llä uutta kangasta	K3
5.	Käyttäjä painaa Tallenna –painiketta.	

Käyttötapaukset	

K1 Tietoja voidaan syöttää seuraavista tiedoista:
•	Kankaan id (yksilöivä tieto)
•	Kankaan merkki	Kankaan id on yksilöivä tunniste.
K2 Pakollisia tietoja ovat: Kankaan id, kankaan merkki	P1
K3 Jos käyttäjä yrittää syöttää samalla id:llä uutta kangasta, annetaan ilmoitus	P2

Poikkeukset	
P1 Jos joku pakollinen tieto puuttuu, annetaan huomautus V1. 
	V1 =”XX on pakollinen tieto.”

P2 Samaa lankaa ei voi syöttää uudelleen	V2=”Samalla id:llä on jo kangas”

**Kankaan haku**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Kayttajat tai Ristipistotyö -ikkunan	
3.	Käyttäjä painaa Nayta kankaat –painiketta, jolloin näyttöön tuodaan kaikki xml:n tallennetut kankaat. 	K1, K2
	
Käyttötapaukset	
K1 Listalla näkyy 
•	Kankaan id
•	Kankaan merkki	
K2 Jos listalla ei ole lankoja, ei näytetä mitään.	
Poikkeukset	
	
**Ristipistotyön tallennus**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Ristipistotyö -ikkunan	K1
3.	Käyttäjä syöttää ristipistotyöstä pakolliset tiedot	K2, K3, K4
4.	Kun työn tiedot ovat syötetty, painetaan Tallenna -painiketta

Käyttötapaukset	
K1 Tietoja voidaan syöttää seuraavista tiedoista:
•	Työn id (yksilöivä tieto)
•	Työn leveys (pistojen määrä)
•	Työn korkeus (pistojen määrä)
•	Työn langat (valitaan listalta) 
•	Työn kangas (valitaan listalta)	Tässä versiossa voi syöttää vain 4 lankaa per työ. Lopullisessa versiossa lankojen määrä on rajaton. 

K2 Lankojen valinta	Lankoja voidaan syöttää 4 kpl. Ainakin yksi pitää valita. Jos langasta on syötetty numero, pitää olla myös määrä. P1, P2

K3 Kankaan valinta	Kangas syötetään itse, mutta se pitää olla olemassa oleva kangas. P3

K4 Kaikki tiedot ovat pakollisia	P4

Poikkeukset	

P1 Ainakin yksi lanka on lisättävä.	V1 = ”Syötä ainakin yksi lanka. Voit laittaa sille määräksi 0.”

P2 Jos lanka on syötetty, määrä on pakollinen	V2 = ”Määrä on pakollinen. Voit syöttää määräksi 0.”

P3 Kangas täytyy löytyä listasta	V3 = ”Kankaan numeron täytyy löytyä listasta.”

P4 Jos joku pakollinen tieto puuttuu, annetaan huomautus V1. 
	V4 =”XX on pakollinen tieto.”

**Käyttäjän tallennus**

Kuvaus	
1.	Käyttäjä avaa ristipistotyö -ohjelman	
2.	Käyttäjä avaa päävalikosta Käyttäjä -ikkunan	K1
3.	Käyttäjä syöttää käyttäjästä pakolliset tiedot	K2, K3, K4
4.	Kun työn tiedot ovat syötetty, painetaan Tallenna -painiketta	

Käyttötapaukset	

K1 Tietoja voidaan syöttää seuraavista tiedoista:
•	Käyttäjän nro (yksilöivä tieto)
•	Käyttäjän etunimi
•	Omat langat (numerot listalta) 
•	Ristipistotyö (valitaan listalta)	Tässä versiossa voi syöttää vain 4 lankaa per käyttäjä. Lopullisessa versiossa lankojen määrä on rajaton. 

K2 Lankojen valinta	Lankoja voidaan syöttää 4 kpl. Ainakin yksi pitää valita. Jos langasta on syötetty numero, pitää olla myös määrä. P1, P2

K3 Ristipistotyön valinta	Näytetään ristipistotyöt taulukossa. Tässä versiossa niitä ei ole kuin yksi. Jos listassa ei ole töitä, pitää ne käydä syöttämässä ensin ristipistotyö –näytöllä. Käyttäjä tekee valinnan tuplaklikkaamalla riviä. Sen tausta muuttuu punaiseksi. 

K4 Kaikki tiedot ovat pakollisia	P3

Poikkeukset	

P1 Ainakin yksi lanka on lisättävä.	V1 = ”Syötä ainakin yksi lanka. Voit laittaa sille määräksi 0.”

P2 Jos lanka on syötetty, määrä on pakollinen	V2 = ”Määrä on pakollinen. Voit syöttää määräksi 0.”

P3 Jos joku pakollinen tieto puuttuu, annetaan huomautus V1. 
	V4 =”XX on pakollinen tieto.”


	

