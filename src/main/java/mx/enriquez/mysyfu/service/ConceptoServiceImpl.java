/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.dao.ConceptoDAO;
import mx.enriquez.mysyfu.model.Concepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ISC. Cristian Enríquez
 * CONCEPTOS:
 * CA: Activo Corriente o Activo Circulante                 CA: Current Assets
 * CL: Pasivo Circulante o Pasivo exigible a corto plazo    CL: Current Liabilities
 * CM: Costo de los Materiales                              CM: Cost of Materials
 * CC: Capital Circulante                                   WC: Working Capital
 * DDC: Derechos de cobro comerciales                       DDC: Trade Receivables
 * EF: Efectivo                                             EF: Cash
 * RA: Préstamos o Recursos Ajenos                          RA: Borrowings
 * RACP: Recursos ajenos a corto plazo                      RACP: Short-Term Borrowings
 * RP: Equidad o Recursos Propios                           RP: Equity
 * TA: Activo Total                                         TA: Total Assets
 */
@Service
public class ConceptoServiceImpl implements ConceptoService {

    @Autowired
    private ConceptoDAO conceptoDAO;

    public void setConceptoDAO(ConceptoDAO conceptoDAO) {
        this.conceptoDAO = conceptoDAO;
    }

    @Override
    @Transactional
    public void addConcepto(Concepto c) {
        this.conceptoDAO.addConcepto(c);
    }

    @Override
    @Transactional
    public void updateConcepto(Concepto c) {
        this.conceptoDAO.updateConcepto(c);
    }

    @Override
    @Transactional
    public List<Concepto> listConceptos() {
        return this.conceptoDAO.listConceptos();
    }

    @Override
    @Transactional
    public Concepto getConceptoById(int id) {
        return this.conceptoDAO.getConceptoById(id);
    }

    @Override
    @Transactional
    public void removeConcepto(int id) {
        this.conceptoDAO.removeConcepto(id);
    }

}
