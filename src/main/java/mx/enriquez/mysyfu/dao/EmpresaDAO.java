/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Empresa;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface EmpresaDAO {

    public void addEmpresa(Empresa e);

    public void updateEmpresa(Empresa e);

    public List<Empresa> listEmpresas();

    public Empresa getEmpresaById(int id);

    public void removeEmpresa(int id);

}
