#Testausraportti

**Aihe:** Ristipistoty� �ohjelma
**Aika:** 13.6.2015
**Yleist�**
Testataan Ristipistotallennusohjelma. Ohjelmalla voidaan sy�tt�� ristipistolankoja ja kankaita. T�m�n hetken versiolla voidaan sy�tt�� yksi ristipistoty�, joka sis�lt�� maksimissaan 4 erilaista lankaa. Samoin voidaan sy�tt�� yksi k�ytt�j� ja valita h�nelle 4 kpl omia lankoja ja 1 ty�. Lopullisessa versiossa k�ytt�jien, t�iden tai lankojen m��r�� ei ole rajattu.
Kaikkia asioita ei saatu testattua yksikk�testeill�. Niiden kokonaiskattavuus j�i alle 90 %, mutta alla olevilla testitapauksilla on yritetty kattaa testaus k�ytt�liittym�n kautta.

**Testauskohteet ja lopputulokset:**

Nro	Testauskohde	Testikuvaus	Haluttu lopputulos	Lopputulos
1	P��valikko	N�ytt�jen painikkeet	N�yt�t aukeavat	OK
2	P��valikko	Poistu �painike	Ohjelma sulkeutuu	OK
3	Langat �ikkuna	Sy�tet��n kaikki tiedot	Muodostuu oikeanlainen �lanka.xml�	OK
4	Langat -ikkuna	J�tet��n pois joku kentt�	Saadaan huomautus puuttuvasta kent�st�.	OK
5	Langat �ikkuna	N�yt� langat �painike	Taulukkoon haetaan tiedot langoista.	OK
6	Langat �ikkuna	N�yt� langat �painike	Jos taulukko on tyhj�, ohjelma ei kaadu virheeseen	OK
7	Langat �ikkuna	Lanka -taulukko	Taulukkoa ei voi p�ivitt��.	OK
8	Langat �ikkuna	Sama id	Samalla id:ll� ei voi sy�tt�� uutta tietoa. Ohjelma ei anna ilmoitusta, mutta tieto ei mene xml:n	OK
9	Kangas �ikkuna	Sy�tet��n kaikki tiedot.	Muodostuu oikeanlainen �kangas.xml�	OK
10	Kangas -ikkuna	J�tet��n pois joku kentt�	Saadaan huomautus puuttuvasta kent�st�.	OK
11	Kangas �ikkuna	N�yt� kankaat �painike	Taulukkoon haetaan tiedot kankaista.	OK
12	Kangas �ikkuna	N�yt� langat �painike	Jos taulukko on tyhj�, ohjelma ei kaadu virheeseen	OK
13	Kangas �ikkuna	Lanka -taulukko	Taulukkoa ei voi p�ivitt��.	OK
14	Kangas �ikkuna	Sama id	Samalla id:ll� ei voi sy�tt�� uutta tietoa. Ohjelma ei anna ilmoitusta, mutta tieto ei mene xml:n	OK
15	Kangas �ikkuna	Palaa p��valikkoon	Palaa p��valikkoon �painike palaa p��valikkoon	OK

16	K�ytt�j�t -ikkuna	Sy�tet��n kaikki tiedot	Muodostuu oikeanlainen �kayttajakokoelma.xml�	Ok, liian monta tasoa langoissa, mutta toimii
17	K�ytt�j�t -ikkuna	J�tet��n pois id tai nimi	Annetaan huomautus puuttuvasta kent�st�	OK
18	K�ytt�j�t -ikkuna	Yksi lanka	Yksi lanka on pakollinen, m��r�n voi laittaa nollaksi.	OK
19	K�ytt�j�t �ikkuna	Ristipistoty�t 	Ristipistoty�t eiv�t ole pakollisia, sanoma muodostuu ilman niit�kin	OK
20	K�ytt�j�t  �ikkuna	Palaa p��valikkoon	Palaa p��valikkoon �painike palaa p��valikkoon	OK

21	Ristipisto -ikkuna	Sy�tet��n kaikki pakolliset tiedot	Muodostuu oikeanlainen � ristipistotyokokoelma.xml�	OK
22	Ristipisto -ikkuna	J�tet��n pois joku kentt�	Annetaan huomautus puuttuvasta kent�st�	OK
23	Ristipisto -ikkuna	Lanka tai kangas eri kuin listassa	Annetaan huomautus, ett� lankaa tai kangasta ei l�ydy.	Ei toimi. Ohjelma antaa virheen
24	Ristipisto -ikkuna	N�yt� langat �painike	N�ytet��n kaikki langat	OK
25	Ristipisto -ikkuna	N�yt� langat �painike	Jos taulukko on tyhj�, ei tule virhett�	OK
26	Ristipisto -ikkuna	N�yt� kankaat �painike	N�ytet��n kaikki kankaat	OK
27	Ristipisto -ikkuna	N�yt� kankaat �painike	Jos taulukko on tyhj�, ei tule virhett�	OK
28	Ristipisto �ikkuna	Palaa p��valikkoon	Palaa p��valikkoon �painike palaa p��valikkoon	OK

29	Kaikki ikkunat	Numeeriset kent�t	Numeerisiksi m��riteltyihin kenttiin ei voi sy�tt�� muita kuin numeroita.	OK
30	K�ytt�j�t �ikkuna	M��r� �kent�t	Jos on sy�tetty lankanumero, my�s m��r� pit�� olla sy�tetty	OK
31	Ristipisto �ikkuna	M��r� �kent�t	Jos on sy�tetty lankanumero, my�s m��r� pit�� olla sy�tetty	OK


