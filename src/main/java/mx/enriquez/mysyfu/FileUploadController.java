/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    //subir archivo
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFile(@RequestParam("file") MultipartFile file) {

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
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

                System.out.println("Ubicación de documento = " + serverFile.getAbsolutePath());
                stream.write(bytes);
                stream.close();
                
                //File xBRLFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(serverFile);

                //doc.getDocumentElement().normalize();
                //NamedNodeMap node = ;
                System.out.println(doc.getAttributes());

               System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("xbrli:context");
               // NodeList nList = doc.getChildNodes();
                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        System.out.println("Staff id : " + eElement.getChildNodes());
                        //System.out.println("Staff id : " + eElement.getAttribute("id"));

                    }
                }

                return "Documento subido correctamente = " + file.getOriginalFilename() + " Ubicacion del Archivo = " + serverFile.getAbsolutePath();
            } catch (Exception e) {
                return "Ocurrio un error al subir documento" + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "Ocurrio un error al subir " + file.getOriginalFilename() + " documento vacio.";
        }
    }

}
