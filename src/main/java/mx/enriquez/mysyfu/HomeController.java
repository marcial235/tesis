package mx.enriquez.mysyfu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ISC. Cristian Enríquez
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }
    
    @RequestMapping(value = "/valores")
    public ModelAndView valoresPage() {
        return new ModelAndView("valor");
    }
    
    @RequestMapping(value = "/resultados")
    public ModelAndView resPage() {
        return new ModelAndView("resultados");
    }
}
