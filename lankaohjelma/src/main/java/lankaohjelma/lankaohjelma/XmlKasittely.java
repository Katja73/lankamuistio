/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

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

import org.w3c.dom.NodeList;

public class XmlKasittely {

public void KirjoitaKayttajaXML(ArrayList<Kayttaja> list) {

    try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("KayttajaInfo");
        doc.appendChild(root);
        
        org.w3c.dom.Element kayttaja = doc.createElement("Kayttaja");
        root.appendChild(kayttaja);
        
//        org.w3c.dom.Element tyo = doc.createElement("Ristipistotyot");
//        kayttaja.appendChild(tyo);
//        
//        org.w3c.dom.Element langat = doc.createElement("OmatLangat");
//        kayttaja.appendChild(langat);

    //    for(int i=0; i<list.size(); i ++ ) {
        for (Kayttaja dt1 : list) {

            org.w3c.dom.Element name = doc.createElement("Nro");
            name.appendChild(doc.createTextNode(String.valueOf(dt1.getNro())));
            kayttaja.appendChild(name);

            org.w3c.dom.Element id = doc.createElement("Nimi");
            id.appendChild(doc.createTextNode(String.valueOf(dt1.getEtunimi())));
            kayttaja.appendChild(id);  
            
            org.w3c.dom.Element tyo = doc.createElement("RistipistoTyo");
            id.appendChild(doc.createTextNode(String.valueOf(dt1.getRistipistotyot())));
            kayttaja.appendChild(tyo);    
            
            org.w3c.dom.Element langat = doc.createElement("OmatLangat");
            id.appendChild(doc.createTextNode(String.valueOf(dt1.getOmatLangat())));
            kayttaja.appendChild(langat);   
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
            FileWriter fos = new FileWriter("C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\kayttaja.xml");
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
        // ToDo: Jos tiedostoa ei löydy
//         File nimi = new File(tiedNimi);
//         System.out.println("nimi: "+nimi);
//        if (!nimi.exists()) {
//            System.out.println("Tiedostoa "+nimi+" ei loydy!");
//        //    return null; // keskeytetaan kaikki!
//        }
        ArrayList lueLankaXml = LueLankaXml(tiedNimi);
        System.out.println("lueLankaXml.size(): "+lueLankaXml.size());
        if (lueLankaXml.size() > 0) {
           // for (int i = 0; i < lueLankaXml.size(); i++) {
                list.addAll(lueLankaXml);
          //  }            
        }
        
        System.out.println("list: ");
        
        // Käydään langat läpi ja lisätään jokainen XML:n
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
    public void KirjoitaKangasXML(ArrayList<Kangas> list, String tiedNimi) {

    try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("Kankaat");
        doc.appendChild(root);
        
        // Käydään langat läpi ja lisätään jokainen XML:n
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
     * Kirjoitetaan Kayttaja -luokan XML-dokumentti
     * @param list Langat jotka kirjoitetaan XML:n
     */
    public void KirjoitaKayttajaXML(ArrayList<Kayttaja> list, String tiedNimi) {
        
    try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        org.w3c.dom.Document doc = build.newDocument();        
        
        org.w3c.dom.Element root = doc.createElement("Kayttajat");
        doc.appendChild(root);      
        
        // Ei haluta tuhota jo valmiina olevia lankoja, joten haetaan ne ensin
        // ToDo: Jos tiedostoa ei löydy
//         File nimi = new File(tiedNimi);
//         System.out.println("nimi: "+nimi);
//        if (!nimi.exists()) {
//            System.out.println("Tiedostoa "+nimi+" ei loydy!");
//        //    return null; // keskeytetaan kaikki!
//        }
        ArrayList lueKayttajaXml = LueKayttajaXml(tiedNimi);
        System.out.println("lueLankaXml.size(): "+lueLankaXml.size());
        if (lueLankaXml.size() > 0) {
           // for (int i = 0; i < lueLankaXml.size(); i++) {
                list.addAll(lueLankaXml);
          //  }            
        }
        
        System.out.println("list: ");
        
        // Käydään langat läpi ja lisätään jokainen XML:n
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
     * Luetaan levyllä oleva Kangas.xml
     * @return listan kangaista
     * @throws Exception
     */
    public ArrayList LueKangasXml() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("C:\\Users\\Katja.Katja-PC\\lankamuistio\\Tiedostot\\kangas.xml");
            
            doc.getDocumentElement().normalize();
          //  System.out.println("Root element" + doc.getDocumentElement().getNodeName());
            
            NodeList listaKankaista = doc.getElementsByTagName("Kangas");
            int kaikkiKankaat = listaKankaista.getLength();
          //  System.out.println("Kaikki kankaat : " + kaikkiKankaat);  
            
            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();
            
            ArrayList<Kangas> kankaat = haeKaikkiKankaat(doc, xpath);
          //  System.out.println("Kankaat: "+kankaat);
            return kankaat;
            
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
    * Luetaan levyllä oleva Lanka.xml
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
