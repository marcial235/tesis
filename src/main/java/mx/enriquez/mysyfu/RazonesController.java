/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.util.ArrayList;
import mx.enriquez.mysyfu.model.Empresa;
import mx.enriquez.mysyfu.model.EstadoFinanciero;
import mx.enriquez.mysyfu.model.Razon;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.EmpresaService;
import mx.enriquez.mysyfu.service.EstadoFinancieroService;
import mx.enriquez.mysyfu.service.RazonService;
import mx.enriquez.mysyfu.service.ValoresEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Controller
public class RazonesController {

    private ValoresEstadoService valoresEstadoService;
    private RazonService razonService;
    private EmpresaService empresaService;
    private EstadoFinancieroService estadoFinancieroService;

    @Autowired(required = true)
    @Qualifier(value = "valoresEstadoService")
    public void setValoresEstadoService(ValoresEstadoService valoresEstadoService) {
        this.valoresEstadoService = valoresEstadoService;
    }

    @Autowired(required = true)
    @Qualifier(value = "razonService")
    public void setRazonService(RazonService razonService) {
        this.razonService = razonService;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "empresaService")
    public void setEmpresaService(EmpresaService empresaService){
        this.empresaService = empresaService;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "estadoFinancieroService")
    public void setEstadoFinancieroService(EstadoFinancieroService estadoFinancieroService){
        this.estadoFinancieroService = estadoFinancieroService;
    }

    /*Cuando llame a "valores", mostrar: 
    1.- Interfaz para seleccionar empresa: Seleccionar empresa
    2.- Mostrar estados financieros: Seleccionar estado financiero
    3.- Mostrar las razones calculadas para el estado financiero seleccionado
    4.- Opcion de realizar analisis difuso
     */
    @RequestMapping(value = "/razones", method = RequestMethod.GET)
    public String listValores(Model model) {
        model.addAttribute("listEstadosFinancieros", this.estadoFinancieroService.listEstadoFinancieros());
        model.addAttribute("listEmpresas", this.empresaService.listEmpresas());
        model.addAttribute("listRazones", this.razonService.listRazones());
        model.addAttribute("razon", new Razon());
        return "razon";
    }

    @RequestMapping(value = "/razones/calcular/{id}", method = RequestMethod.GET)
    public String addRazones(@PathVariable("id") int id, Model model) {
        //Traemos los valores
        Valores v = this.valoresEstadoService.getValorEstadoById(id);
        
        //Calculamos el valor de las razones solvencia
        ArrayList arrayRS = new ArrayList();
        arrayRS = this.razonService.listaRazonesSolvencia(v);
        System.out.println("Razon solvencia: ");
        for (int i = 0; i < arrayRS.size(); i++) {
            Razon r = new Razon();
            r = (Razon) arrayRS.get(i);
            System.out.println("Razon: " + r.getnRazon());
            System.out.println("Valor: " + r.getValor());
            this.razonService.addRazon(r);
        }
        
        //Calculamos el valor de las razones rotacion
        ArrayList arrayRR = new ArrayList();
        arrayRS = this.razonService.listaRazonesRotacion(v);
        System.out.println("Razon rotacion: ");
        for (int a = 0; a < arrayRR.size(); a++) {
            Razon r = new Razon();
            r = (Razon) arrayRR.get(a);
            System.out.println("Razon: " + r.getnRazon());
            System.out.println("Valor: " + r.getValor());
            this.razonService.addRazon(r);
        }
        
        //Calculamos el valor de las razones liquidez
        ArrayList arrayRL = new ArrayList();
        arrayRL = this.razonService.listaRazonesLiquidez(v);
        System.out.println("Razon liquidez: ");
        for (int b = 0; b < arrayRL.size(); b++) {
            Razon r = new Razon();
            r = (Razon) arrayRL.get(b);
            System.out.println("Razon: " + r.getnRazon());
            System.out.println("Valor: " + r.getValor());
            this.razonService.addRazon(r);
        }
        

        //-------------------------------------------------------
        //model.addAttribute("listRazonesRotacion", this.razonService.listaRazonesRotacion(v));
        //model.addAttribute("listRazonesLiquidez", this.razonService.listaRazonesLiquidez(v));
        //model.addAttribute("listRazonesSolvencia", this.razonService.listaRazonesSolvencia(v));
        //model.addAttribute("razon", new Razon());
        
        return "redirect:/razones";
    }

}
