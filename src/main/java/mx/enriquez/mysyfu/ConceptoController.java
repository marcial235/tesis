/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import mx.enriquez.mysyfu.model.Concepto;
import mx.enriquez.mysyfu.model.Valores;
import mx.enriquez.mysyfu.service.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mx.enriquez.mysyfu.service.ValoresEstadoService;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Controller
public class ConceptoController {

    private ConceptoService conceptoService;
    private ValoresEstadoService valoresEstadoService;

    @Autowired(required = true)
    @Qualifier(value = "conceptoService")
    public void setConceptoService(ConceptoService conceptoService) {
        this.conceptoService = conceptoService;
    }

    @RequestMapping(value = "/conceptos", method = RequestMethod.GET)
    public String listConceptos(Model model) {
        model.addAttribute("concepto", new Concepto());
        model.addAttribute("listConceptos", this.conceptoService.listConceptos());
        return "concepto";
    }

    // For add and update concepto both
    @RequestMapping(value = "/concepto/add", method = RequestMethod.POST)
    public String addConcepto(@ModelAttribute("concepto") Concepto c) {
        if (c.getId() == 0) {
// new concepto, add it
            this.conceptoService.addConcepto(c);
        } else {
// existing concepto, call update
            this.conceptoService.updateConcepto(c);
        }
        return "redirect:/conceptos";
    }

    @RequestMapping("/removeconcepto/{id}")
    public String removeConcepto(@PathVariable("id") int id) {
        this.conceptoService.removeConcepto(id);
        return "redirect:/conceptos";
    }

    @RequestMapping("/editconcepto/{id}")
    public String editConcepto(@PathVariable("id") int id, Model model) {
        model.addAttribute("concepto", this.conceptoService.getConceptoById(id));
        model.addAttribute("listconceptos", this.conceptoService.listConceptos());
        return "concepto";
    }

}
