/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import lankaohjelma.perusluokat.Lanka;

import lankaohjelma.perusluokat.Kangas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import java.io.File;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import lankaohjelma.kokoelmat.KayttajaKokoelma;
import lankaohjelma.kokoelmat.LankaKokoelma;
import lankaohjelma.kokoelmat.RistipistoTyoKokoelma;

public class XmlKasittely {

    /**
     * Kirjoitetaan Lanka -luokan XML-dokumentti
     * @param list Langat jotka kirjoitetaan XML:n
     */
    public void KirjoitaLankaXML(Lanka lisattavaLanka, String tiedNimi) {
        
        ArrayList<Lanka> list = new ArrayList<Lanka>();
        list.add(lisattavaLanka);
        
    try {
        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("Langat");
        doc.appendChild(root);      
        
        // Ei haluta tuhota jo valmiina olevia lankoja, joten haetaan ne ensin 
        if (OnkoTiedostoOlemassa(tiedNimi)) {
            ArrayList lueLankaXml = LueLankaXml(tiedNimi);           

            for (int i = 0; i < lueLankaXml.size(); i++) {
                // Haetaan langan nroarvo
                String oma = lueLankaXml.get(i).toString();
                String[] riviArvot = oma.split(",");
                int lankaNro = Integer.parseInt(riviArvot[0]);
               
                // Verrataan parametrina tullutta arvoa taulukon arvoon
                // Jos arvo on sama, ei lisata 
                // TODO: huomautuksen antaminen
                if (lisattavaLanka.getLankaid() != lankaNro){
                 list.addAll(lueLankaXml);                    
                }
            }
        } 
        
        // Kaydaan langat lapi ja lisataan jokainen XML:n
        for (Lanka dt1 : list) {
            org.w3c.dom.Element lanka = doc.createElement("Lanka");
            root.appendChild(lanka);

            org.w3c.dom.Element lankaId = doc.createElement("LankaId");
            lankaId.appendChild(doc.createTextNode(String.valueOf(dt1.getLankaid())));
            lanka.appendChild(lankaId);

            org.w3c.dom.Element lankanro = doc.createElement("MerkkiNro");
            lankanro.appendChild(doc.createTextNode(String.valueOf(dt1.getLankanro())));
            lanka.appendChild(lankanro);  
            
            org.w3c.dom.Element merkki = doc.createElement("Merkki");
            merkki.appendChild(doc.createTextNode(String.valueOf(dt1.getMerkki())));
            lanka.appendChild(merkki);        
        }

        // Tallennetaan xml -dokumentti levylle
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // Formatoidaan XML
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        try {
            FileWriter fos = new FileWriter(tiedNimi);
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        } catch (IOException e) {

            e.printStackTrace();
        }
        
        } catch (TransformerException ex) {
            System.out.println("Error outputting document");

        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        } catch (Exception ex) {
        Logger.getLogger(XmlKasittely.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    /**
     * Kirjoitetaan Kangas -luokan XML-dokumentti
     * @param list Kankaat jotka kirjoitetaan XML:n
     */
    public void KirjoitaKangasXML(Kangas lisattavaKangas, String tiedNimi) throws Exception {
        
        ArrayList<Kangas> list = new ArrayList<Kangas>();
        list.add(lisattavaKangas);

    try {
        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("Kankaat");
        doc.appendChild(root);
        
        // Ei haluta tuhota jo valmiina olevia kankaita, joten haetaan ne ensin 
        if (OnkoTiedostoOlemassa(tiedNimi)) {
            ArrayList lueKangasXml = LueKangasXml(tiedNimi);           

            for (int i = 0; i < lueKangasXml.size(); i++) {
                // Haetaan kangasnroarvo
                String oma = lueKangasXml.get(i).toString();
                String[] riviArvot = oma.split(",");
                int kangasNro = Integer.parseInt(riviArvot[0]);
               
                // Verrataan parametrina tullutta arvoa taulukon arvoon
                // Jos arvo on sama, ei lisata 
                // TODO: huomautuksen antaminen
                if (lisattavaKangas.getKangasnro()!= kangasNro){
                 list.addAll(lueKangasXml);                        
                }
            }
        }        
       
        // Kaydaan langat lapi ja lisataan jokainen XML:n
        for (Kangas dt1 : list) {
            org.w3c.dom.Element kangas = doc.createElement("Kangas");
            root.appendChild(kangas);

            org.w3c.dom.Element kangasId = doc.createElement("KangasId");
            kangasId.appendChild(doc.createTextNode(String.valueOf(dt1.getKangasnro())));
            kangas.appendChild(kangasId);

            org.w3c.dom.Element kangasMerkki = doc.createElement("KangasMerkki");
            kangasMerkki.appendChild(doc.createTextNode(String.valueOf(dt1.getKangasMerkki())));
            kangas.appendChild(kangasMerkki);  
        }

        // Tallennetaan xml -dokumentti levylle
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // Formatoidaan XML
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        try {
            FileWriter fos = new FileWriter(tiedNimi);
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        } catch (IOException e) {

            e.printStackTrace();
        }
        
        } catch (TransformerException ex) {
            System.out.println("Error outputting document");

        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
    }   
    
    /**
     * Luetaan levylla oleva Kangas.xml
     * @return listan kangaista
     * @throws Exception
     */
    public ArrayList LueKangasXml(String tiedNimi) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(tiedNimi);
            
            doc.getDocumentElement().normalize();         
            
            NodeList listaKankaista = doc.getElementsByTagName("Kangas");
            int kaikkiKankaat = listaKankaista.getLength();         
            
            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();
            
            ArrayList<Kangas> kankaat = HaeKaikkiKankaat(doc, xpath);        
            return kankaat;
            
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
    * Luetaan levylla oleva Lanka.xml
     * @param tiedNimi xml -tiedoston nimi
    * @return listan langoista
    * @throws Exception
    */
    public ArrayList LueLankaXml(String tiedNimi) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;        
        
        try {
            builder = factory.newDocumentBuilder();          
           doc = builder.parse(tiedNimi);
            
            doc.getDocumentElement().normalize();        
            
            NodeList listaLangoista = doc.getElementsByTagName("Lanka");
            int kaikkiLangat = listaLangoista.getLength();         
            
            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();
            
            ArrayList<Lanka> langat = HaeKaikkiLangat(doc, xpath);
            System.out.println("Langat: "+langat);
            return langat;
            
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static ArrayList<Kangas> HaeKaikkiKankaat(Document doc, XPath xpath){
        ArrayList<Kangas> kangasLista = new ArrayList<Kangas>();        
        try {
            //Luodaan XPath Expression
            XPathExpression expr =
                xpath.compile("/Kankaat/Kangas/KangasId/text()");
             XPathExpression expr2 =
                xpath.compile("/Kankaat/Kangas/KangasMerkki/text()");
            
             //Evaluoidaan tiedot noodeihin
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            
            for (int i = 0; i < nodes.getLength(); i++)
                kangasLista.add(new Kangas(Integer.parseInt(nodes.item(i).getNodeValue()), nodes2.item(i).getNodeValue()));            
            
                } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return kangasLista;
    }
    
        private static ArrayList<Lanka> HaeKaikkiLangat(Document doc, XPath xpath){
        ArrayList<Lanka> lankaLista = new ArrayList<Lanka>();        
        try {
            //Luodaan XPath Expression
            XPathExpression expr =
                xpath.compile("/Langat/Lanka/LankaId/text()");
             XPathExpression expr2 =
                xpath.compile("/Langat/Lanka/MerkkiNro/text()");
             XPathExpression expr3 =
                xpath.compile("/Langat/Lanka/Merkki/text()");
            
             //Evaluoidaan tiedot noodeihin
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes3 = (NodeList) expr3.evaluate(doc, XPathConstants.NODESET);
            
            for (int i = 0; i < nodes.getLength(); i++)           
            lankaLista.add(new Lanka(Integer.parseInt(nodes.item(i).getNodeValue()), 
                    Integer.parseInt(nodes2.item(i).getNodeValue()), 
                    nodes3.item(i).getNodeValue()));        
            
                } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return lankaLista;
    }  
        
    /**
     * Tutkitaan, onko tiedosto olemassa. 
     * @param tiedNimi Tiedosto, jota tutkitaan
     * @return true, jos tiedosto loytyy
     */
    public boolean OnkoTiedostoOlemassa(String tiedNimi)
        {
        File nimi = new File(tiedNimi);
        if (nimi.exists()) {
            return true;
        }
        return false;         
        }
    
     /**
     * Kirjoittaa XML:n kayttajista
     * @param tiedNimi tiedoston nimi
     * @throws Exception
     */
    public void KirjoitaKayttajaXml(KayttajaKokoelma kayttajat, String tiedNimi) throws Exception{
        
    try { 
        File file = new File(tiedNimi);
        JAXBContext jaxbContext = JAXBContext.newInstance(KayttajaKokoelma.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();                

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(kayttajat, file);
        jaxbMarshaller.marshal(kayttajat, System.out);
   
    } catch (JAXBException e) {
        e.printStackTrace();
        }   
    } 
    
    /**
     * Haetaan kaikki kayttajat
     * @param tiedNimi
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    public KayttajaKokoelma HaeKaikkiKayttajat(String tiedNimi) throws FileNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(KayttajaKokoelma.class);
	
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File xml = new File(tiedNimi);
        
        KayttajaKokoelma kayttajaKokoelma = (KayttajaKokoelma) unmarshaller.unmarshal(xml);
        //ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
//        kayttajat.add(kayttaja);
        return kayttajaKokoelma;
    }  
    
       /**
     * Kirjoittaa XML:n lankakokoelmista
     * @param tiedNimi tiedoston nimi
     * @throws Exception
     */
    public void KirjoitaLankaKokoelmaXml(LankaKokoelma lankaKokoelma, String tiedNimi) throws Exception{
        
    try { 
        File file = new File(tiedNimi);
        JAXBContext jaxbContext = JAXBContext.newInstance(LankaKokoelma.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();                

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(lankaKokoelma, file);
        jaxbMarshaller.marshal(lankaKokoelma, System.out);
   
    } catch (JAXBException e) {
        e.printStackTrace();
        }   
    } 
    
    
     /**
     * Kirjoittaa XML:n ristipistotöistä
     * @param tiedNimi tiedoston nimi
     * @throws Exception
     */
    public void KirjoitaRistipistoTyoKokoelmaXml(RistipistoTyoKokoelma ristipistotyoKokoelma, String tiedNimi) throws Exception{
        
    try { 
        File file = new File(tiedNimi);
        JAXBContext jaxbContext = JAXBContext.newInstance(RistipistoTyoKokoelma.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();                

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(ristipistotyoKokoelma, file);
        jaxbMarshaller.marshal(ristipistotyoKokoelma, System.out);
   
    } catch (JAXBException e) {
        e.printStackTrace();
        }   
    } 
    
    /**
     * Haetaan kaikki ristipistotyöt
     * @param tiedNimi
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    public RistipistoTyoKokoelma HaeKaikkiRistipistoTyoKokoelma(String tiedNimi) throws FileNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RistipistoTyoKokoelma.class);
	
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File xml = new File(tiedNimi);
        
        RistipistoTyoKokoelma ristipistoTyoKokoelma = (RistipistoTyoKokoelma) unmarshaller.unmarshal(xml);
        return ristipistoTyoKokoelma;
    }  

// Hakuun liittyviä käyttökelpoisia metodeja

//    private static List<String> getFemaleEmployeesName(Document doc, XPath xpath) {
//        List<String> list = new ArrayList<>();
//        try {
//            //create XPathExpression object
//            XPathExpression expr =
//                xpath.compile("/Employees/Employee[gender='Female']/name/text()");
//            //evaluate expression result on XML document
//            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//            for (int i = 0; i < nodes.getLength(); i++)
//                list.add(nodes.item(i).getNodeValue());
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

//    private static List<String> getEmployeeNameWithAge(Document doc, XPath xpath, int age) {
//        List<String> list = new ArrayList<>();
//        try {
//            XPathExpression expr =
//                xpath.compile("/Employees/Employee[age>" + age + "]/name/text()");
//            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//            for (int i = 0; i < nodes.getLength(); i++)
//                list.add(nodes.item(i).getNodeValue());
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

//    private static String getEmployeeNameById(Document doc, XPath xpath, int id) {
//        String name = null;
//        try {
//            XPathExpression expr =
//                xpath.compile("/Employees/Employee[@id='" + id + "']/name/text()");
//            name = (String) expr.evaluate(doc, XPathConstants.STRING);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//
//        return name;
//    }
}
