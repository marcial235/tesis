/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.dao.EmpresaDAO;
import mx.enriquez.mysyfu.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaDAO empresaDAO;

    public void setEmpresaDAO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }

    @Override
    @Transactional
    public void addEmpresa(Empresa e) {
        this.empresaDAO.addEmpresa(e);
    }

    @Override
    @Transactional
    public void updateEmpresa(Empresa e) {
        this.empresaDAO.updateEmpresa(e);
    }

    @Override
    @Transactional
    public List<Empresa> listEmpresas() {
        return this.empresaDAO.listEmpresas();
    }

    @Override
    @Transactional
    public Empresa getEmpresaById(int id) {
        return this.empresaDAO.getEmpresaById(id);
    }

    @Override
    @Transactional
    public void removeEmpresa(int id) {
        this.empresaDAO.removeEmpresa(id);
    }

}
