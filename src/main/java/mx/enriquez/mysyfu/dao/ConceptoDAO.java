/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Concepto;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface ConceptoDAO {

    public void addConcepto(Concepto c);

    public void updateConcepto(Concepto c);

    public List<Concepto> listConceptos();

    public Concepto getConceptoById(int id);

    public void removeConcepto(int id);

}
