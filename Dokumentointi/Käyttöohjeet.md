# RISTIPISTOTY�OHJELMA � OHJEET

** Sis�llys **
1.	Yleist�	1
2.	Ohjelmassa olevat toiminnalliset puutteet ja virheet:	1
3.	Ohjeet	2
3.1.	P��valikko	2
3.2.	Langat �ikkuna	3
3.3.	Kankaat �ikkuna	4
3.4.	K�ytt�j�t �ikkuna	5
3.5.	Ristipistoty�t �ikkuna	7

**1.	Yleist�**
Ohjelmalla pystyy sy�tt�m��n ristipistoty�ss� tarvittavia tietoja. Ohjelman ensimm�isess� versiossa pystyy tekem��n seuraavat tallennukset:
�	Sy�tt�m��n lankoja
�	Sy�tt�m��n kankaita
�	Sy�tt�m��n yhden ristipistoty�n kerrallaan
�	Sy�tt�m��n yhden k�ytt�j�n kerrallaan.

Seuraavassa versiossa tulee mahdolliseksi useamman k�ytt�j�n ja ristipistoty�n sy�tt�minen.
HUOM! .JAR pit�� ajaa kansiossa, jossa on kirjoitusoikeudet. XML �sanomat tallentuvat t�h�n kansioon. My�hemmin ohjelmaan on tarkoitus lis�t� tietokanta.

** 2.	Ohjelmassa olevat toiminnalliset puutteet ja virheet: **
�	T�ss� versiossa ei pysty sy�tt�m��n kuin yhden k�ytt�j�n. Seuraavan sy�tt�minen tuhoaa edellisen. Ei my�sk��n pysty sy�tt�m��n kuin yhden ristipistoty�n kerrallaan. Uuden tallentaminen tuhoaa edellisen. 

�	K�ytt�ji� tai ristipistot�it� ei voi tarkastella kuin XML �tiedostojen kautta. Niille ei ole tarjolla omaa n�ytt�ikkunaa.

�	Lankojen ja kankaiden tallennuksessa ei ole poistoa tai muokkausta. T�ss� versiossa voi vain lis�t� uusia kankaita tai lankoja.

�	Eri kohtien id:t eiv�t tule sekvenssist�. T�m� mahdollistetaan seuraaviin versioihin.

**3.	Ohjeet**
**3.1.	P��valikko**

 
Painikkeet:
Langat: Avaa Langat �ikkunan
Kankaat: Avaa Kankaat ikkunan
Ristipistoty�t: Avaa ristipistoty�t �ikkunan
K�ytt�j�t: Avaa K�ytt�j�t �ikkunan
Lopeta: Ohjelma suljetaan
Aloita sy�tt�m�ll� langat ja kankaat. Sen j�lkeen sy�t� ristipistoty�t.  N�in ne ovat k�yt�ss� valmiina K�ytt�j�t -n�yt�ss�.
 

**3.2.	Langat �ikkuna**

 
Kent�t
Langan id: 	Pakollisuus: Pakollinen, numeerinen kentt�.
Selitys: Langan id on yksil�iv� numeerinen tunniste. Kannattaa katsoa N�yt� langat �painikkeella jo valmiina olevat langat, ja ottaa seuraava numero. Samalla numerolla ei voi sy�tt�� uutta lankaa. Ohjelma ei ilmoita p��llekk�isyydest�, mutta lanka ei tallennu.


Merkin nro:	Pakollisuus: Pakollinen, numeerinen kentt�.
Selitys: Jokaisella langalla on oma yksil�iv� tunnistenumero ja merkki. T�h�n sy�tet��n langan v�rin numero, esim. 456 (DMC)

Merkki: 	Pakollisuus: Pakollinen
Selitys: T�h�n tulee langan merkki, joka yhdess� Merkin nro:n kanssa yksil�i v�rin. T�iss� v�rit ilmoitetaan aina merkki + nro �muodossa. Esim. DMC 345 tai Anchor 1050.
Painikkeet
N�yt� langat: N�ytet��n jo valmiina olevat langat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
Tallenna: Tallennetaan langat
Palaa p��valikkoon: Palataan p��valikkoon 

**3.3.	Kankaat �ikkuna**

 
Kent�t
Kangas id: 	Pakollisuus: Pakollinen, numeerinen kentt�
Selitys: Kankaan id on yksil�iv� numeerinen tunniste. Kannattaa katsoa N�yt� kankaat �painikkeella jo valmiina olevat kankaat, ja ottaa seuraava numero.  Samalla numerolla ei voi sy�tt�� uutta kangasta. Ohjelma ei ilmoita p��llekk�isyydest�, mutta kangas ei tallennu.

Kangasmerkki: 
	Pakollisuus: Pakollinen
Selitys: T�h�n tulee kankaan merkki. Kangas voi olla merkilt��n mik� tahansa. Yleisimm�t ovat Aida ja Pellava. Halutessaan kentt��n voi kirjoittaa my�s kankaan koon. Se ilmoitetaan numerona nimen per�ss�. Esim. Aida 18. Mit� suurempi numero, sen tihe�mpi kangas.
Painikkeet
N�yt� kankaat: N�ytet��n jo valmiina olevat kankaat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
Tallenna: Tallennetaan kankaat.
Palaa p��valikkoon: Palataan p��valikkoon
 

**3.4.	K�ytt�j�t �ikkuna**

 
Kent�t
K�ytt�j�n nro: 
	Pakollisuus: Pakollinen, numeerinen kentt�
Selitys: K�ytt�j�n nro on yksil�iv� numeerinen tunniste. T�m�n hetken tallentaa aina edellisen p��lle, joten numeroksi voi antaa mit� vaan. 

K�ytt�j�n etunimi: 	
Pakollisuus: Pakollinen
Selitys: K�ytt�j�n nimi. Pelkk� etunimi riitt��. 
Langan nro: 	Pakollisuus: Yksi lanka on pakollinen, numeerinen kentt�
Selitys:  Omat langat kohtaan voi sy�tt�� maksimissaan nelj� eri lankaa. Ohjelma tekee tarkistuksen, ovatko langat jo olemassa joten kannattaa painaa N�yt� langat �painiketta, jotta saa n�kyviin kaikki tiedostoon tallennetut langat. 
M��r�:	Pakollisuus: Ensimm�isen langan m��r� on pakollinen, mutta siihen voidaan sy�tt�� my�s 0. Numeerinen kentt�. Muiden m��r� on pakollinen vain, jos my�s lanka on sy�tetty.
Selitys: Kuinka monta tokkaa kyseist� lankaa k�ytt�j�ll� on (langat myyd��n tokissa). Yksi tokka sis�lt�� n. 8 metri� lankaa.
Osta:	Pakollisuus: Ei pakollinen.
	Selitys: T�h�n valitaan, jos k�ytt�j� haluaa tallentaa tiedon, ett� lankaa pit�� ostaa lis��. Ominaisuutta hy�dynnet��n seuraaviin versioihin tulevissa ostoslista �toiminnoissa.

Painikkeet
N�yt� langat: N�ytet��n jo valmiina olevat langat taulukossa. Taulukkoa ei voi muokata tai valita lankoja.
N�yt� ristipistoty�t: N�ytet��n jo valmiina oleva ristipistoty� taulukossa. T�ss� versiossa on n�kyviss� vain yksi ty�, josta n�kyy ty�n id ja nimi. Ty�t� tuplaklikkaamalla se valitaan k�ytt�j�n ty�ksi. Valittu rivi muuttuu punaiseksi.
Tallenna: Tallennetaan k�ytt�j�n tiedot.
Palaa p��valikkoon: Palataan p��valikkoon
 

**3.5.	Ristipistoty�t �ikkuna**

 
Kent�t
Ty�n nro:  	Pakollisuus: Pakollinen, numeerinen kentt�
Selitys: ty�n nro on yksil�iv� numeerinen tunniste. T�m�n hetken versio tallentaa aina edellisen p��lle, joten numeroksi voi antaa mit� vaan. 

Nimi: 	Pakollisuus: Pakollinen, numeerinen kentt�
Selitys: Ty�n nimi
Leveys: 	Pakollisuus: Pakollinen, numeerinen kentt�
Selitys: Ty�n leveys pistojen m��r�n�
Korkeus:	Pakollisuus: Pakollinen, numeerinen kentt�
	Selitys: Ty�n korkeus pistojen m��r�n� 
Langan nro: 	Pakollisuus: Yksi lanka on pakollinen, numeerinen kentt�
Selitys:  Omat langat kohtaan voi sy�tt�� maksimissaan nelj� eri lankaa. Ohjelma tekee tarkistuksen, ovatko langat jo olemassa, joten paina N�yt� langat �painiketta, jotta saat n�kyviin kaikki tiedostoon tallennetut langat. 
M��r�:	Pakollisuus: Ensimm�isen langan m��r� on pakollinen, mutta siihen voidaan sy�tt�� my�s 0. Numeerinen kentt�. Muiden m��r� on pakollinen vain, jos my�s lanka on sy�tetty.
Selitys: Kuinka monta tokkaa kyseist� lankaa tarvitaan ty�h�n. Tokat ilmoitetaan kokonaislukuna. 
Kangas:	Pakollisuus: Pakollinen. Pit�� valita joku olemassa oleva id.	
Selitys: Sy�tet��n kankaan id. Kankaat saadaan n�kyviin N�yt� kankaat �painikkeella. Kankaaksi pit�� valita, joku listan id �numeroista. 
Painikkeet
N�yt� langat: N�ytet��n langat taulukossa. Taulukkoa ei voi muokata.
N�yt� kankaat: N�ytet��n kankaat taulukossa. Taulukkoa ei voi muokata.
Tallenna: Tallennetaan ristipistoty�n tiedot.
Palaa p��valikkoon: Palataan p��valikkoon


