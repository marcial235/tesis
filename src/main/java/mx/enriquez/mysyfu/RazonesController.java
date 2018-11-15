/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import mx.enriquez.mysyfu.model.Empresa;
import mx.enriquez.mysyfu.model.Razon;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.EmpresaService;
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
    private EmpresaService empresaService;
    private RazonService razonService;

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
    
    /*Cuando llame a "valores", mostrar: 
    1.- Interfaz para seleccionar empresa: Seleccionar empresa
    2.- Mostrar estados financieros: Seleccionar estado financiero
    3.- Mostrar las razones calculadas para el estado financiero seleccionado
    4.- Opcion de realizar analisis difuso
    */
    @RequestMapping(value = "/razones", method = RequestMethod.GET)
    public String listValores(Model model) {
        model.addAttribute("listRazonesRotacion", this.razonService.listaRazonesRotacion(1));
        model.addAttribute("listRazonesLiquidez", this.razonService.listaRazonesLiquidez(1));
        model.addAttribute("listRazonesSolvencia", this.razonService.listaRazonesSolvencia(1));
        model.addAttribute("razon", new Razon());
        return "razon";
    }

    @RequestMapping(value = "/razones/calcular", method = RequestMethod.POST)
    public String addValoresEstado(@ModelAttribute("idv") Valores v) {
            this.valoresEstadoService.addValorEstado(v);
        return "redirect:/razones";
    }

}
