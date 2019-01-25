/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mx.enriquez.mysyfu.model.Empresa;
import mx.enriquez.mysyfu.model.EstadoFinanciero;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.EmpresaService;
import mx.enriquez.mysyfu.service.EstadoFinancieroService;
import mx.enriquez.mysyfu.service.ValoresEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Servicios
    private ValoresEstadoService valoresEstadoService;
    private EmpresaService empresaService;
    private EstadoFinancieroService estadoFinancieroService;

    @Autowired(required = true)
    @Qualifier(value = "empresaService")
    public void setEmpresaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Autowired(required = true)
    @Qualifier(value = "valoresEstadoService")
    public void setValoresEstadoService(ValoresEstadoService valoresEstadoService) {
        this.valoresEstadoService = valoresEstadoService;
    }

    @Autowired(required = true)
    @Qualifier(value = "estadoFinancieroService")
    public void setEstadoFinancieroService(EstadoFinancieroService estadoFinancieroService) {
        this.estadoFinancieroService = estadoFinancieroService;
    }

    //subir archivo
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public /*@ResponseBody*/ String uploadFile(@RequestParam("file") MultipartFile file) {
        Empresa empresa = new Empresa();
        Valores valores = new Valores();
        EstadoFinanciero estadoFinanciero = new EstadoFinanciero();
        String contextoID = "";

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
                File archivo = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                //File archivo = new File("C:\\Users\\cnenr\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\tmpFiles\\ifrsxbrl_VIVA_2018-1.xbrl");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(archivo));

                //System.out.println("Ubicación de documento = " + archivo.getAbsolutePath());
                stream.write(bytes);
                stream.close();

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(archivo);
                doc.getDocumentElement().normalize();

                NodeList listaNodos = doc.getDocumentElement().getChildNodes();
                //Recuperamos el contexto con el que vamos a trabajar, el cual se encuentra en la pocision 5
                Element contexto = (Element) listaNodos.item(5);
                contextoID = contexto.getAttribute("id");
                System.out.println("Seleccionamos contexto: " + contextoID);

                NodeList list = listaNodos.item(3).getChildNodes();
                NodeList listaFechas = list.item(3).getChildNodes();
                System.out.println("Fecha inicio: " + listaFechas.item(1).getTextContent());
                System.out.println("Fecha fin: " + listaFechas.item(3).getTextContent());
                System.out.println("Fecha emision: " + listaFechas.item(3).getTextContent());
                Date fechaEmision = new SimpleDateFormat("dd-MM-yyyy").parse(listaFechas.item(3).getTextContent());
                Date fechaInicio = new SimpleDateFormat("dd-MM-yyyy").parse(listaFechas.item(1).getTextContent());
                Date fechaFin = new SimpleDateFormat("dd-MM-yyyy").parse(listaFechas.item(3).getTextContent());
                estadoFinanciero.setFechaPublicacion(fechaEmision);
                estadoFinanciero.setIniPeriodo(fechaInicio);
                estadoFinanciero.setFinPeriodo(fechaFin);
                estadoFinanciero.setTipoEstado("Balance general");

                //For principal para recorrer los nodos
                for (int temp = 0; temp < listaNodos.getLength(); temp++) {
                    Node nodo = listaNodos.item(temp);
                    //If para obtener las etiquetas xbrli:*
                    if (nodo.getNodeName().contains("xbrli:")) {
                        Element element = (Element) nodo;
                        //If para seleccionar un contexto
                        if (element.getAttribute("id").contains(contextoID)) {
                            NodeList nodosElemento = element.getChildNodes();
                            //For para recorrer los tags anidados dentro de xbrli
                            for (int i = 0; i < nodosElemento.getLength(); i++) {
                                Node nodoElemento = nodosElemento.item(i);
                                if (nodoElemento.getNodeName().contains("entity")) {
                                    //Setteamos los datos de la empresa
                                    empresa.setNempresa(nodoElemento.getTextContent().trim());
                                    System.out.println("Empresa: " + nodoElemento.getTextContent().trim());
                                }

                            }
                        }

                    }
                    //If para obtener los tags ifrs (valores)
                    if (nodo.getNodeName().contains("ifrs-full:")) {
                        Element elemento = (Element) nodo;
                        if (elemento.getAttribute("contextRef").contains(contextoID) && (elemento.getTextContent() != null || !elemento.getTextContent().isEmpty())) {
                            Double valor = Double.parseDouble(elemento.getTextContent());
                            System.out.print("Elemento: " + elemento.getNodeName() + "\n");
                            System.out.print("value: " + elemento.getTextContent() + "\n");
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:CurrentAssets")) {
                                valores.setca(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:CurrentLiabilities")) {
                                valores.setcl(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:Cash")) {
                                valores.setef(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:TradeAndOtherCurrentPayables")) {
                                valores.setracp(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:NoncurrentPayables")) {
                                valores.setra(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:Equity")) {
                                valores.setrp(valor);
                            }
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:Assets")) {
                                valores.setta(valor);
                            }
                            //Activos no corrientes
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:NoncurrentAssets")) {
                                valores.setNca(valor);
                            }
                            //Inventario
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:Inventories")) {
                                valores.setInvt(valor);
                            }
                            //Total de deudas
                            if ((elemento.getNodeName()).contentEquals("ifrs-full:Liabilities")) {
                                valores.setTl(valor);
                            }

                            //Valores que no vienen en el XBRL
                            valores.setcm(0);
                            valores.setcc(0);
                            valores.setddc(0);
                            valores.setntsls(0);
                            valores.setWrkcp(0);

                        }
                    }

                }
                try {
                    //Guardamos la empresa
                    this.empresaService.addEmpresa(empresa);

                    //Recuperamos el ID de la ultima empresa insertada
                    int indexEmpresa = this.empresaService.listEmpresas().size();
                    Empresa ultimaEmpresa = this.empresaService.listEmpresas().get(indexEmpresa-1);
                    System.out.print(ultimaEmpresa.getId());
                    estadoFinanciero.setIdEmpresa(ultimaEmpresa.getId());
                    //Guardamos los datos del estado financiero
                    this.estadoFinancieroService.addEstadoFinanciero(estadoFinanciero);

                    //Recuperamos el ID del ultimo estado financiero
                    int indexEstadoFinanciero = this.estadoFinancieroService.listEstadoFinancieros().size();
                    EstadoFinanciero ultimoEstado = (EstadoFinanciero) this.estadoFinancieroService.listEstadoFinancieros().get(indexEstadoFinanciero-1);
                    valores.setIdEstado(ultimoEstado.getId());
                    System.out.print(ultimoEstado.getId());
                    //Guardamos los valores y el estado financiero al que pertenecen
                    this.valoresEstadoService.addValorEstado(valores);

                } catch (Exception e) {
                    System.out.print(e);
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
