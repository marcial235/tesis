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
@Table(name = "razon")
public class Razon implements Serializable{
    @Id
    @Column(name = "id_razon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre_razon")
    private String nRazon;
    
    @Column(name = "valor")
    private double valor;
    
    @Column(name = "_idestadof")
    private int _idestadof;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnRazon() {
        return nRazon;
    }

    public void setnRazon(String nRazon) {
        this.nRazon = nRazon;
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
