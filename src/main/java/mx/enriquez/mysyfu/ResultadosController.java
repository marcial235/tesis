/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cristian
 */
@Controller
public class ResultadosController {
    @ExceptionHandler(Exception.class)
    @RequestMapping(value = "/resultados", method = RequestMethod.GET)
    public ModelAndView resultadosPage(Model model, Exception exception,HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        
        //Le tenemos que pasar valores de razones al modulo de logica difusa
        ModuloDifuso md = new ModuloDifuso();
        md.setRa(0.5);
        md.setRc(0.5);
        md.setRcd(0.5);
        md.setRe(0.5);
        
        //Mandar JSON a la vista
        String result= md.evalua();
        model.addAttribute("response", result);
        
        System.out.print(result);
        return new ModelAndView("resultados");
    }
    
}
