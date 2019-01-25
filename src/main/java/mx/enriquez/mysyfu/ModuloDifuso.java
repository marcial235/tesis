/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author Cristian
 */
public class ModuloDifuso {
    
    final static String RUTA = "c://fuzzy/test.fcl";
    
    //Valores a crear
    private Double rc;
    private Double ra;
    private Double re;
    private Double rcd;
    
    FIS fis = FIS.load(RUTA,true);
    FunctionBlock functionBlock = fis.getFunctionBlock(null);
    
    public String evalua(){
        String response = "";
        
        functionBlock.setVariable("rc", this.rc);
        functionBlock.setVariable("ra", this.ra);
        functionBlock.setVariable("re", this.re);
        functionBlock.setVariable("rcd", this.rcd);
        functionBlock.evaluate();
        
        Variable EstadoFinanciero = functionBlock.getVariable("ef");
        
        response = "{values : {ef: '"+ fis.getVariable("ef").getValue() + "'";
        response += ", ef: '" + fis.getVariable("ef").getValue() + "'";
        response += ", bn: '" + EstadoFinanciero.getMembership("bueno") + "'";
        response += ", rg: '" + EstadoFinanciero.getMembership("regular") + "'";
        response += ", ml: '" + EstadoFinanciero.getMembership("malo") + "'}}";
        
        
    return response;
    }

    public Double getRc() {
        return rc;
    }

    public void setRc(Double rc) {
        this.rc = rc;
    }

    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    public Double getRe() {
        return re;
    }

    public void setRe(Double re) {
        this.re = re;
    }

    public Double getRcd() {
        return rcd;
    }

    public void setRcd(Double rcd) {
        this.rcd = rcd;
    }
    
    
    
}
