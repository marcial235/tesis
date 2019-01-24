/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.ArrayList;
import java.util.List;
import mx.enriquez.mysyfu.model.Razon;
import mx.enriquez.mysyfu.model.Valores;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface RazonService {

    public void addRazon(Razon r);

    public void updateRazon(Razon r);

    public List<Razon> listRazones();

    public Razon getRazonById(int id);

    public void removeRazon(int id);
    
    public ArrayList listaRazonesRotacion(Valores v);
    
    public ArrayList listaRazonesLiquidez(Valores v);
    
    public ArrayList listaRazonesSolvencia(Valores v);
}
