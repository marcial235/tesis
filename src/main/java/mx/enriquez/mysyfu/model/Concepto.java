/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ISC. Cristian Enríquez
 */

@Entity
@Table(name = "concepto")
public class Concepto implements Serializable{
    
    @Id
    @Column(name = "id_concepto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (name="nombre_concepto")
    private String cve;
    
    @Column (name="valor")
    private double valor;
    
    @Column (name="_idestadof")
    private int _idestadof;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdestadof() {
        return _idestadof;
    }

    public void setIdestadof(int _idestadof) {
        this._idestadof = _idestadof;
    }
    
    

    
}
