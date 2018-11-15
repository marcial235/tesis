/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.model.Valores;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface ValoresEstadoService {

    public void addValorEstado(Valores ve);

    public void updateValorEstado(Valores ve);

    public List<Valores> listValorEstado();

    public Valores getValorEstadoById(int id);

    public void removeValorEstado(int id);

}
