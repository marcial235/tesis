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

        Empresa empresa = new Empresa();

        try {
            File archivo = new File("C:\\ifrsxbrl_VIVA_2018-1.xbrl");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();

            NodeList listaNodos = document.getDocumentElement().getChildNodes();
            //For principal para recorrer los nodos
            for (int temp = 0; temp < listaNodos.getLength(); temp++) {
                Node nodo = listaNodos.item(temp);
                //If para obtener las etiquetas xbrli:*
                if (nodo.getNodeName().contains("xbrli:")) {
                    Element element = (Element) nodo;
                    //If para seleccionar un contexto
                    if (element.getAttribute("id").contains("C861d4ba8-c3bf-4064-c0b8-0dc642c5f3c0")) {
                        System.out.print("Elemento: " + element.getNodeName() + "\n");
                        System.out.print("         ID: " + element.getAttribute("id") + "\n");

                        NodeList nodosElemento = element.getChildNodes();
                        //For para recorrer los tags anidados dentro de xbrli
                        for (int i = 0; i < nodosElemento.getLength(); i++) {
                            Node nodoElemento = nodosElemento.item(i);
                            if (nodoElemento.getNodeName().contains("entity")) {
                                empresa.setEmpresa(nodoElemento.getTextContent());
                                System.out.println("SetEmpresa():" + nodoElemento.getTextContent());
                            }

                        }
                    }

                }
                //If para obtener los tags ifrs (valores)
                if (nodo.getNodeName().contains("ifrs-full:")) {
                    Element elemento = (Element) nodo;
                    if (elemento.getAttribute("contextRef").contains("C861d4ba8-c3bf-4064-c0b8-0dc642c5f3c0") && (elemento.getTextContent() != null || !elemento.getTextContent().isEmpty())) {
                        System.out.print("Elemento: " + elemento.getNodeName() + "\n");
                        System.out.print("contextRef: " + elemento.getAttribute("contextRef") + "\n");
                        System.out.print("value: " + elemento.getTextContent() + "\n");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
