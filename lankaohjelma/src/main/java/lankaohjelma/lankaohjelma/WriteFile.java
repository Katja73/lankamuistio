/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lankaohjelma.lankaohjelma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.text.Document;
import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class WriteFile {

public void writeXmlFile(ArrayList<Kayttaja> list) {

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
}