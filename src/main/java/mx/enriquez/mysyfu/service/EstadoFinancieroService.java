/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.List;
import mx.enriquez.mysyfu.model.EstadoFinanciero;

/**
 *
 * @author ISC. Cristian Enríquez
 */
public interface EstadoFinancieroService {

    public void addEstadoFinanciero(EstadoFinanciero ef);

    public void updateEstadoFinanciero(EstadoFinanciero ef);

    public List<EstadoFinanciero> listEstadoFinancieros();

    public EstadoFinanciero getEstadoFinancieroById(int id);

    public void removeEstadoFinanciero(int id);
}
