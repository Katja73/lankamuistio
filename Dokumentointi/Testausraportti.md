#Testausraportti

**Aihe:** Ristipistotyö –ohjelma
**Aika:** 13.6.2015
**Yleistä**
Testataan Ristipistotallennusohjelma. Ohjelmalla voidaan syöttää ristipistolankoja ja kankaita. Tämän hetken versiolla voidaan syöttää yksi ristipistotyö, joka sisältää maksimissaan 4 erilaista lankaa. Samoin voidaan syöttää yksi käyttäjä ja valita hänelle 4 kpl omia lankoja ja 1 työ. Lopullisessa versiossa käyttäjien, töiden tai lankojen määrää ei ole rajattu.
Kaikkia asioita ei saatu testattua yksikkötesteillä. Niiden kokonaiskattavuus jäi alle 90 %, mutta alla olevilla testitapauksilla on yritetty kattaa testaus käyttöliittymän kautta.

**Testauskohteet ja lopputulokset:**

Nro	Testauskohde	Testikuvaus	Haluttu lopputulos	Lopputulos
1	Päävalikko	Näyttöjen painikkeet	Näytöt aukeavat	OK
2	Päävalikko	Poistu –painike	Ohjelma sulkeutuu	OK
3	Langat –ikkuna	Syötetään kaikki tiedot	Muodostuu oikeanlainen ”lanka.xml”	OK
4	Langat -ikkuna	Jätetään pois joku kenttä	Saadaan huomautus puuttuvasta kentästä.	OK
5	Langat –ikkuna	Näytä langat –painike	Taulukkoon haetaan tiedot langoista.	OK
6	Langat –ikkuna	Näytä langat –painike	Jos taulukko on tyhjä, ohjelma ei kaadu virheeseen	OK
7	Langat –ikkuna	Lanka -taulukko	Taulukkoa ei voi päivittää.	OK
8	Langat –ikkuna	Sama id	Samalla id:llä ei voi syöttää uutta tietoa. Ohjelma ei anna ilmoitusta, mutta tieto ei mene xml:n	OK
9	Kangas –ikkuna	Syötetään kaikki tiedot.	Muodostuu oikeanlainen ”kangas.xml”	OK
10	Kangas -ikkuna	Jätetään pois joku kenttä	Saadaan huomautus puuttuvasta kentästä.	OK
11	Kangas –ikkuna	Näytä kankaat –painike	Taulukkoon haetaan tiedot kankaista.	OK
12	Kangas –ikkuna	Näytä langat –painike	Jos taulukko on tyhjä, ohjelma ei kaadu virheeseen	OK
13	Kangas –ikkuna	Lanka -taulukko	Taulukkoa ei voi päivittää.	OK
14	Kangas –ikkuna	Sama id	Samalla id:llä ei voi syöttää uutta tietoa. Ohjelma ei anna ilmoitusta, mutta tieto ei mene xml:n	OK
15	Kangas –ikkuna	Palaa päävalikkoon	Palaa päävalikkoon –painike palaa päävalikkoon	OK

16	Käyttäjät -ikkuna	Syötetään kaikki tiedot	Muodostuu oikeanlainen ”kayttajakokoelma.xml”	Ok, liian monta tasoa langoissa, mutta toimii
17	Käyttäjät -ikkuna	Jätetään pois id tai nimi	Annetaan huomautus puuttuvasta kentästä	OK
18	Käyttäjät -ikkuna	Yksi lanka	Yksi lanka on pakollinen, määrän voi laittaa nollaksi.	OK
19	Käyttäjät –ikkuna	Ristipistotyöt 	Ristipistotyöt eivät ole pakollisia, sanoma muodostuu ilman niitäkin	OK
20	Käyttäjät  –ikkuna	Palaa päävalikkoon	Palaa päävalikkoon –painike palaa päävalikkoon	OK

21	Ristipisto -ikkuna	Syötetään kaikki pakolliset tiedot	Muodostuu oikeanlainen ” ristipistotyokokoelma.xml”	OK
22	Ristipisto -ikkuna	Jätetään pois joku kenttä	Annetaan huomautus puuttuvasta kentästä	OK
23	Ristipisto -ikkuna	Lanka tai kangas eri kuin listassa	Annetaan huomautus, että lankaa tai kangasta ei löydy.	Ei toimi. Ohjelma antaa virheen
24	Ristipisto -ikkuna	Näytä langat –painike	Näytetään kaikki langat	OK
25	Ristipisto -ikkuna	Näytä langat –painike	Jos taulukko on tyhjä, ei tule virhettä	OK
26	Ristipisto -ikkuna	Näytä kankaat –painike	Näytetään kaikki kankaat	OK
27	Ristipisto -ikkuna	Näytä kankaat –painike	Jos taulukko on tyhjä, ei tule virhettä	OK
28	Ristipisto –ikkuna	Palaa päävalikkoon	Palaa päävalikkoon –painike palaa päävalikkoon	OK

29	Kaikki ikkunat	Numeeriset kentät	Numeerisiksi määriteltyihin kenttiin ei voi syöttää muita kuin numeroita.	OK
30	Käyttäjät –ikkuna	Määrä –kentät	Jos on syötetty lankanumero, myös määrä pitää olla syötetty	OK
31	Ristipisto –ikkuna	Määrä –kentät	Jos on syötetty lankanumero, myös määrä pitää olla syötetty	OK


