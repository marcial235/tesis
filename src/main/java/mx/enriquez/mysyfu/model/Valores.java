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
@Table(name = "valores")
public class Valores implements Serializable {

    @Id
    @Column(name = "idv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ca")
    private double ca;

    @Column(name = "cl")
    private double cl;

    @Column(name = "cm")
    private double cm;

    @Column(name = "cc")
    private double cc;

    @Column(name = "ddc")
    private double ddc;

    @Column(name = "ef")
    private double ef;

    @Column(name = "ra")
    private double ra;

    @Column(name = "racp")
    private double racp;

    @Column(name = "rp")
    private double rp;

    @Column(name = "ta")
    private double ta;

    @Column(name = "_idestadof")
    private int _idEstado;

    //Ventas netas
    @Column(name = "ntsls")
    private double ntsls;

    //Activos no corrientes
    @Column(name = "nca")
    private double nca;

    //Inventario
    @Column(name = "invt")
    private double invt;

    //Capital de trabajo
    @Column(name = "wrkcp")
    private double wrkcp;

    //Totald e deudas
    @Column(name = "tl")
    private double tl;

    public double getTl() {
        return tl;
    }

    public void setTl(double tl) {
        this.tl = tl;
    }

    public double getWrkcp() {
        return wrkcp;
    }

    public void setWrkcp(double wrkcp) {
        this.wrkcp = wrkcp;
    }

    public double getInvt() {
        return invt;
    }

    public void setInvt(double invt) {
        this.invt = invt;
    }

    public double getNca() {
        return nca;
    }

    public void setNca(double nca) {
        this.nca = nca;
    }

    public double getntsls() {
        return ntsls;
    }

    public void setntsls(double ntsls) {
        this.ntsls = ntsls;
    }

    public double getca() {
        return ca;
    }

    public void setca(double ca) {
        this.ca = ca;
    }

    public double getcl() {
        return cl;
    }

    public void setcl(double cl) {
        this.cl = cl;
    }

    public double getcm() {
        return cm;
    }

    public void setcm(double cm) {
        this.cm = cm;
    }

    public double getcc() {
        return cc;
    }

    public void setcc(double cc) {
        this.cc = cc;
    }

    public double getddc() {
        return ddc;
    }

    public void setddc(double ddc) {
        this.ddc = ddc;
    }

    public double getef() {
        return ef;
    }

    public void setef(double ef) {
        this.ef = ef;
    }

    public double getra() {
        return ra;
    }

    public void setra(double ra) {
        this.ra = ra;
    }

    public double getracp() {
        return racp;
    }

    public void setracp(double racp) {
        this.racp = racp;
    }

    public double getrp() {
        return rp;
    }

    public void setrp(double rp) {
        this.rp = rp;
    }

    public double getta() {
        return ta;
    }

    public void setta(double ta) {
        this.ta = ta;
    }

    public int getIdEstado() {
        return _idEstado;
    }

    public void setIdEstado(int _idEstado) {
        this._idEstado = _idEstado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
