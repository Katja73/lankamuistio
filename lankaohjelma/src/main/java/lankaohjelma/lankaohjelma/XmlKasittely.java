/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import lankaohjelma.perusluokat.Lanka;
import lankaohjelma.perusluokat.Kayttaja;
import lankaohjelma.perusluokat.Kangas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class XmlKasittely {

    /**
     * Kirjoitetaan kayttaja -luokan XML -tiedosto levylle
     * @param list
     * @param tiedNimi
     * @throws Exception
     */
    public void KirjoitaKayttajaXML(ArrayList<Kayttaja> list, String tiedNimi) throws Exception {

    try {
        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("KayttajaInfo");
        doc.appendChild(root);      
        
        // Ei haluta tuhota jo valmiina olevia kayttajia, joten haetaan ne ensin 
        if (OnkoTiedostoOlemassa(tiedNimi)) {
            ArrayList lueKayttajaXml = LueKayttajaXml(tiedNimi);           

            for (int i = 0; i < lueKayttajaXml.size(); i++) {
                // Haetaan kÃ¤yttÃ¤jÃ¤n nroarvo
                String oma = lueKayttajaXml.get(i).toString();
                String[] riviArvot = oma.split(",");
                int kayttajaNro = Integer.parseInt(riviArvot[0]);
               
                // Verrataan parametrina tullutta arvoa taulukon arvoon
                // Jos arvo on sama, ei lisÃ¤tÃ¤ 
                // TODO: huomautuksen antaminen
                for (Kayttaja dt2 : list){
                    Integer arvo = dt2.getNro();
                    if (arvo != kayttajaNro){
                        list.addAll(lueKayttajaXml);
                        System.out.println("kayttajaNro"+ kayttajaNro); 
                    }
                }               
            }
        }
        
        System.out.println("kayttajalista"+list);
        
        for (Kayttaja dt1 : list) {
            
            org.w3c.dom.Element kayttaja = doc.createElement("Kayttaja");
            root.appendChild(kayttaja);

            org.w3c.dom.Element name = doc.createElement("Nro");
            name.appendChild(doc.createTextNode(String.valueOf(dt1.getNro())));
            kayttaja.appendChild(name);

            org.w3c.dom.Element id = doc.createElement("Nimi");
            id.appendChild(doc.createTextNode(String.valueOf(dt1.getEtunimi())));
            kayttaja.appendChild(id); 
            
            org.w3c.dom.Element ristipistotyot = doc.createElement("Ristipistotyot");
            kayttaja.appendChild(ristipistotyot);
            
            for (int i = 0; i < dt1.getRistipistotyot().size(); i++) {                
            
               org.w3c.dom.Element tyo = doc.createElement("Tyo");
                tyo.appendChild(doc.createTextNode(String.valueOf(dt1.getRistipistotyot().get(i))));
                ristipistotyot.appendChild(tyo);    
            }           
            
            org.w3c.dom.Element omatLangat = doc.createElement("Omatlangat");
            kayttaja.appendChild(omatLangat);
            
            for (int i = 0; i < dt1.getOmatLangat().size(); i++) {   
            
                org.w3c.dom.Element langat = doc.createElement("Lanka");
                langat.appendChild(doc.createTextNode(String.valueOf(dt1.getOmatLangat().get(i))));
                omatLangat.appendChild(langat);   
            }
        }
        
         // Save the document to the disk file
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // format the XML nicely
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
     * Kirjoitetaan Lanka -luokan XML-dokumentti
     * @param list Langat jotka kirjoitetaan XML:n
     */
    public void KirjoitaLankaXML(ArrayList<Lanka> list, String tiedNimi) {
        
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
                // Jos arvo on sama, ei lisÃ¤tÃ¤ 
                // TODO: huomautuksen antaminen
                for (Lanka dt2 : list){
                    Integer arvo = dt2.getLankanro();            
                    if (arvo != lankaNro){
                        list.addAll(lueLankaXml);
                        System.out.println("langan Nro"+ lankaNro); 
                    }
                }               
            }
        }
        
        System.out.println("list: ");
        
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
    public void KirjoitaKangasXML(ArrayList<Kangas> list, String tiedNimi) throws Exception {

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
                // Jos arvo on sama, ei lisÃ¤tÃ¤ 
                // TODO: huomautuksen antaminen
                for (Kangas dt2 : list){
                    Integer arvo = dt2.getKangasnro();            
                    if (arvo != kangasNro){
                        list.addAll(lueKangasXml);
                        System.out.println("kangasNro"+ kangasNro); 
                    }
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
            
            ArrayList<Kangas> kankaat = haeKaikkiKankaat(doc, xpath);        
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
          //  System.out.println("Kaikki langat : " + kaikkiLangat);  
            
            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();
            
            ArrayList<Lanka> langat = haeKaikkiLangat(doc, xpath);
            System.out.println("Langat: "+langat);
            return langat;
            
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
    public ArrayList LueKayttajaXml(String tiedNimi) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;        
        
        try {
            builder = factory.newDocumentBuilder();          
           doc = builder.parse(tiedNimi);
            
            doc.getDocumentElement().normalize();        
            
            NodeList kayttajaLista = doc.getElementsByTagName("Kayttaja");
            int kaikkiKayttaja = kayttajaLista.getLength();         
            
            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();
            
            ArrayList<Kayttaja> kayttajat = haeKaikkiKayttajat(doc, xpath);
//            ArrayList<Kayttaja> kayttajat = haeKaikkiKayttajat2(doc, xpath);
            System.out.println("Kayttajat: "+kayttajat);
            return kayttajat;
            
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
  
    private static ArrayList<Kangas> haeKaikkiKankaat(Document doc, XPath xpath){
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
    
        private static ArrayList<Lanka> haeKaikkiLangat(Document doc, XPath xpath){
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
        
    private static ArrayList<Kayttaja> haeKaikkiKayttajat(Document doc, XPath xpath){
        
        ArrayList<Kayttaja> kayttajaLista = new ArrayList<Kayttaja>();        
        
        try {
            //Luodaan XPath Expression
            XPathExpression expr =
                xpath.compile("/KayttajaInfo/Kayttaja/Nro/text()");
            XPathExpression expr2 =
                xpath.compile("/KayttajaInfo/Kayttaja/Nimi/text()");
                XPathExpression expr3 =
                    xpath.compile("/KayttajaInfo/Kayttaja/Ristipistotyot/Tyo/text()");
                XPathExpression expr4 =
                    xpath.compile("/KayttajaInfo/Kayttaja/Omalangat/Lanka/text()");
                
                XPathExpression expr5 =
                    xpath.compile("/KayttajaInfo/Kayttaja/Ristipistotyot/text()");
            
             //Evaluoidaan tiedot noodeihin
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes3 = (NodeList) expr3.evaluate(doc, XPathConstants.NODESET);           
            NodeList nodes4 = (NodeList) expr4.evaluate(doc, XPathConstants.NODESET);  
            NodeList nodes5 = (NodeList) expr5.evaluate(doc, XPathConstants.NODESET);             
            
            ArrayList<Integer> lista = new ArrayList<Integer>();
            
            for (int i = 0; i < nodes.getLength(); i++){               
           
//                    //System.out.println("pituus: "+nodes.getLength());
//                    //System.out.println("test: "+Integer.parseInt(nodes.item(i).getNodeValue()));
//            //System.out.println("test2: "+nodes2.item(i).getNodeValue());
//                for (int j = 0; j < nodes3.getLength(); j++) {
//                    System.out.println("test: "+nodes3.item(i).getNodeValue());
                    System.out.println("test5: "+nodes5.item(i).getNodeValue());
////                    System.out.println("test2: "+nodes4.item(i).getChildNodes());
//                    String tyo = doc.getElementsByTagName("Tyo").item(j).getTextContent();
//                    System.out.println("tyo: "+tyo);
//                }
//
                       lista.add(Integer.parseInt(nodes3.item(i).getNodeValue()));
                       System.out.println("lista: "+lista);
                       kayttajaLista.add(new Kayttaja(Integer.parseInt(nodes.item(i).getNodeValue()), nodes2.item(i).getNodeValue(), 
                               lista, null));
//                               Integer.parseInt(nodes3.item(i).getNodeValue()), Integer.parseInt(nodes4.item(i).getNodeValue())));
//                    
            }
                } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
            System.out.println("kayttajalista: "+kayttajaLista);
        return kayttajaLista;
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
    
       // Jaxb -testailua
     /**
     * Kirjoittaa XML:n oikein, mutta tekee jokaisesta kayttajasta uuden --KORJAA!
     * @param tiedNimi
     * @throws Exception
     */
    public void kirjoitaKayttajaXml3(ArrayList<Kayttaja> kayttajat, String tiedNimi) throws Exception{
        
        try { 
            File file = new File(tiedNimi);
            JAXBContext jaxbContext = JAXBContext.newInstance(Kayttaja.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                
//          jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                
            for (int i = 0; i < kayttajat.size(); i++) {
                jaxbMarshaller.marshal(kayttajat.get(i), file);
                jaxbMarshaller.marshal(kayttajat.get(i), System.out);
            }
	    
        } catch (JAXBException e) {
            e.printStackTrace();
            }   
    } 
    
    /**
     * Testataan JAXB:lla hakua, muuten toimii, mutta kirjoitus ei tee kuin 1 xml:n kerrallaan
     * @param tiedNimi
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    public ArrayList<Kayttaja> haeKaikkiKayttajat2(String tiedNimi) throws FileNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Kayttaja.class);
	
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File xml = new File(tiedNimi);
        
        Kayttaja kayttaja = (Kayttaja) unmarshaller.unmarshal(xml);
        ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
        kayttajat.add(kayttaja);
        return kayttajat;
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
