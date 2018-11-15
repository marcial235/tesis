/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.dao.EstadoFinancieroDAO;
import mx.enriquez.mysyfu.model.EstadoFinanciero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Service
public class EstadoFinancieroServiceImpl implements EstadoFinancieroService {

    @Autowired
    private EstadoFinancieroDAO estadoFinancieroDAO;

    public void setEstadoFinancieroDAO(EstadoFinancieroDAO estadoFinancieroDAO) {
        this.estadoFinancieroDAO = estadoFinancieroDAO;
    }

    @Override
    @Transactional
    public void addEstadoFinanciero(EstadoFinanciero ef) {
        this.estadoFinancieroDAO.addEstadoFinanciero(ef);
    }

    @Override
    @Transactional
    public void updateEstadoFinanciero(EstadoFinanciero ef) {
        this.estadoFinancieroDAO.updateEstadoFinanciero(ef);
    }

    @Override
    @Transactional
    public List<EstadoFinanciero> listEstadoFinancieros() {
        return this.estadoFinancieroDAO.listEstadoFinancieros();
    }

    @Override
    @Transactional
    public EstadoFinanciero getEstadoFinancieroById(int id) {
        return this.estadoFinancieroDAO.getEstadoFinancieroById(id);
    }

    @Override
    @Transactional
    public void removeEstadoFinanciero(int id) {
        this.estadoFinancieroDAO.removeEstadoFinanciero(id);
    }

}
