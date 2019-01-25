/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Razon;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface RazonDAO {

    public void addRazon(Razon r);

    public void updateRazon(Razon r);

    public List<Razon> listRazones();

    public Razon getRazonById(int id);

    public void removeRazon(int id);
    
    public List<Razon> listRazonesById(int idf);

}
