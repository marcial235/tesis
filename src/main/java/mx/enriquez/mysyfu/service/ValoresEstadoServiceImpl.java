/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.dao.ValoresEstadoDAO;
import mx.enriquez.mysyfu.model.Valores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Service
public class ValoresEstadoServiceImpl implements ValoresEstadoService {

    @Autowired
    private ValoresEstadoDAO valoresEstadoDAO;
    
    public void setValoresEstadoDAO(ValoresEstadoDAO valoresEstadoDAO) {
        this.valoresEstadoDAO = valoresEstadoDAO;
    }

    @Override
    @Transactional
    public void addValorEstado(Valores ve) {
        this.valoresEstadoDAO.addValorEstado(ve);
    }
    
    @Override
    @Transactional
    public void updateValorEstado(Valores ve) {
        this.valoresEstadoDAO.updateValorEstado(ve);
    }
    
    @Override
    @Transactional
    public List<Valores> listValorEstado() {
        return this.valoresEstadoDAO.listValorEstados();
    }
    
    @Override
    @Transactional
    public Valores getValorEstadoById(int id) {
        return this.valoresEstadoDAO.getValorEstadoById(id);
    }
    
    @Override
    @Transactional
    public void removeValorEstado(int id) {
        this.valoresEstadoDAO.removeValorEstado(id);
    }
    
}
