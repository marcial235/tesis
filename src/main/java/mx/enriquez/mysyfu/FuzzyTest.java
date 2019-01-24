/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu;

import mx.enriquez.mysyfu.model.Empresa;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public class FuzzyTest {
    //Creamos la empresa
    Empresa empresa = new Empresa();
   
    public static void main(String[] args) throws Exception {
        // Cargar archivo 'FCL'
        String fileName = "c://fuzzy/test.fcl";
        FIS fis = FIS.load(fileName, true);
        if (fis == null) { // Error while loading?
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Mostrar reglas y funciones de pertenencia
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        functionBlock.setVariable("rc", 2.54);
        functionBlock.setVariable("ra", 1.31);
        functionBlock.setVariable("re", 0.39);
        functionBlock.setVariable("rcd", 0);

        // Evaluate 
        functionBlock.evaluate();

        //Mostrar variables de salida y graficos
        Variable EstadoFinanciero = functionBlock.getVariable("ef");
        JFuzzyChart.get().chart(EstadoFinanciero, EstadoFinanciero.getDefuzzifier(), true);
        System.out.println(EstadoFinanciero);
        System.out.println("-------------------------------------------------");
        // Print ruleSet
        //System.out.println(functionBlock);
        System.out.println("Valor de la variable Estado financiero:" + fis.getVariable("ef").getValue());
        System.out.println("Tipo de desborrosificador:" + EstadoFinanciero.getDefuzzifier());
        System.out.println("Valor del termino bueno:" + EstadoFinanciero.getMembership("bueno"));
        System.out.println("Valor del termino regular:" + EstadoFinanciero.getMembership("regular"));
        System.out.println("Valor del termino malo:" + EstadoFinanciero.getMembership("malo"));
        //System.out.println("TIP:" + functionBlock.getVariable("tip").getValue());
        // Show each rule (and degree of support)
        /*System.out.println("Reglas y peso del bloque 1");
        for (Rule r : fis.getFunctionBlock("analisisfinanciero").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }
        System.out.println("Reglas y peso del bloque 2");
        for (Rule r : fis.getFunctionBlock("analisisfinanciero").getFuzzyRuleBlock("No2").getRules()) {
            System.out.println(r);
        }
        System.out.println("Reglas y peso del bloque 3");
        for (Rule r : fis.getFunctionBlock("analisisfinanciero").getFuzzyRuleBlock("No3").getRules()) {
            System.out.println(r);
        }
        */
    }
}
