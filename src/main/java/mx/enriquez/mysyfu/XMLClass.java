/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mx.enriquez.mysyfu.model.Empresa;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public class XMLClass {

    public static void main(String args[]) {

        String contextoID = "";

        try {
            File archivo = new File("C:\\ifrsxbrl_CHDRAUI_2018-1.xbrl");
            //File archivo = new File("C:\\ifrsxbrl_VIVA_2018-1.xbrl");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();

            NodeList listaNodos = document.getDocumentElement().getChildNodes();
            
            //Recuperamos el contexto con el que vamos a trabajar, el cual se encuentra en la pocision 5
            Element contexto = (Element) listaNodos.item(5);
            contextoID = contexto.getAttribute("id");
            System.out.println("Seleccionamos contexto: " + contextoID);
            
            NodeList list = listaNodos.item(3).getChildNodes();
            NodeList listaFechas = list.item(3).getChildNodes();
            System.out.println("Fecha inicio: " + listaFechas.item(1).getTextContent());
            System.out.println("Fecha fin: " + listaFechas.item(3).getTextContent());
            System.out.println("Fecha emision: " + listaFechas.item(3).getTextContent());
            
            //For principal para recorrer los nodos
            for (int temp = 0; temp < listaNodos.getLength(); temp++) {
                Node nodo = listaNodos.item(temp);
               // System.out.println(temp + " - " +nodo.getNodeName() + " - " + nodo.getTextContent());
                //If para obtener las etiquetas xbrli:*
                if (nodo.getNodeName().contains("xbrli:")) {
                    Element element = (Element) nodo;                    
                    //If para seleccionar un contexto
                    if (element.getAttribute("id").contains(contextoID)) {
                        NodeList nodosElemento = element.getChildNodes();
                        //For para recorrer los tags anidados dentro de xbrli
                        for (int z = 0; z < nodosElemento.getLength(); z++) {
                            Node nodoElemento = nodosElemento.item(z);
                            if (nodoElemento.getNodeName().contains("entity")) {
                                System.out.println("Empresa: " + nodoElemento.getTextContent().trim());
                            }
                        }
                    }

                }
                
                //If para obtener los tags ifrs (valores)
                if (nodo.getNodeName().contains("ifrs-full:")) {
                    Element elemento = (Element) nodo;
                    if (elemento.getAttribute("contextRef").contains(contextoID) && (elemento.getTextContent() != null || !elemento.getTextContent().isEmpty())) {
                       System.out.print("Elemento: " + elemento.getNodeName() + "\n");
                       System.out.print("value: " + elemento.getTextContent() + "\n");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
