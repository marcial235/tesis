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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    //subir archivo
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public /*@ResponseBody*/ String uploadFile(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // Crear el directorio para almacenar el archivo
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Crear documento en el servidor
                //File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                File archivo = new File("C:\\Users\\cnenr\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\tmpFiles\\ifrsxbrl_VIVA_2018-1.xbrl");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(archivo));

                System.out.println("Ubicación de documento = " + archivo.getAbsolutePath());
                stream.write(bytes);
                stream.close();

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(archivo);
                doc.getDocumentElement().normalize();

                //System.out.println(doc.getAttributes());

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList listaNodos = doc.getDocumentElement().getChildNodes();
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
                                    //empresa.setEmpresa(nodoElemento.getTextContent());
                                    System.out.println("SetEmpresa():" + nodoElemento.getTextContent());
                                }

                            }
                        }

                    }
                    //If para obtener los tags ifrs (valores)
                    if (nodo.getNodeName().contains("ifrs")) {
                        Element elemento = (Element) nodo;
                        if (elemento.getAttribute("contextRef").contains("C861d4ba8-c3bf-4064-c0b8-0dc642c5f3c0")) {
                            System.out.print("Elemento: " + elemento.getNodeName() + "\n");
                            System.out.print("contextRef: " + elemento.getAttribute("contextRef") + "\n");
                            System.out.print("value: " + elemento.getTextContent() + "\n");
                        }
                    }

                }
                return "redirect:/valores";
                //return "Documento subido correctamente = " + file.getOriginalFilename() + " Ubicacion del Archivo = " + archivo.getAbsolutePath();
            } catch (Exception e) {
                return "Ocurrio un error al subir documento" + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "Ocurrio un error al subir " + file.getOriginalFilename() + " documento vacio.";
        }
    }

}
