/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import mx.enriquez.mysyfu.model.Empresa;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.EmpresaService;
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
public class ValoresController {
    private ValoresEstadoService valoresEstadoService;
    private EmpresaService empresaService;

    @Autowired(required = true)
    @Qualifier(value = "valoresEstadoService")
    public void setValoresEstadoService(ValoresEstadoService valoresEstadoService) {
       this.valoresEstadoService = valoresEstadoService;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "empresaService")
    public void setEmpresaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }
    
    

    @RequestMapping(value = "/valores", method = RequestMethod.GET)
    public String listValores(Model model) {
       model.addAttribute("valor", new Valores());
       model.addAttribute("listValores", this.valoresEstadoService.listValorEstado());
       model.addAttribute("empresa", new Empresa());
       model.addAttribute("listEmpresas", this.empresaService.listEmpresas());
        return "valor";
    }

    // For add and update valor both
    @RequestMapping(value = "/valor/add", method = RequestMethod.POST)
    public String addValoresEstado(@ModelAttribute("valor") Valores c) {
        if (c.getId() == 0) {
// new valor, add it
            this.valoresEstadoService.addValorEstado(c);
        } else {
// existing valor, call update
            this.valoresEstadoService.updateValorEstado(c);
        }
        return "redirect:/valores";
    }

    @RequestMapping("/removevalor/{id}")
    public String removeValoresEstado(@PathVariable("id") int id) {
        this.valoresEstadoService.removeValorEstado(id);
        return "redirect:/valors";
    }

    @RequestMapping("/editvalor/{id}")
    public String editValoresEstado(@PathVariable("id") int id, Model model) {
        model.addAttribute("valor", this.valoresEstadoService.getValorEstadoById(id));
        model.addAttribute("listValores", this.valoresEstadoService.listValorEstado());
        return "valor";
    }

    
}
