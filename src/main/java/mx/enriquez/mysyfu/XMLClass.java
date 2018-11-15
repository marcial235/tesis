/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.RazonServiceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public class XMLClass {

    public static void main(String args[]) {

        try {
            File archivo = new File("C:\\raa.xbrl");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();

            NodeList listaNodos = document.getDocumentElement().getChildNodes();

            for (int temp = 0; temp < listaNodos.getLength(); temp++) {
                Node nodo = listaNodos.item(temp);
                if (nodo.getNodeName().contains("xbrl")) {
                    Element element = (Element) nodo;
                    System.out.print("Elemento: " + element.getNodeName() + "\n");
                    System.out.print("         ID: " + element.getAttribute("id") + "\n");
                    System.out.print("         Valor: " + element.getTextContent() + "\n");
                }
                if (nodo.getNodeName().contains("ifrs")) {
                    Element element = (Element) nodo;
                    System.out.print("Elemento: " + element.getNodeName() + "\n");
                    System.out.print("         ID: " + element.getAttribute("id") + "\n");
                    System.out.print("         Valor: " + element.getTextContent() + "\n");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
