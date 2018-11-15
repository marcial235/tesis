/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Entity
@Table(name = "estado_financiero")
public class EstadoFinanciero implements Serializable {

    @Id
    @Column(name = "id_estadof")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_estado")
    private String tipoEstado;

    @Column(name = "inicio_periodo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ini_periodo;

    @Column(name = "fin_periodo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin_periodo;

    @Column(name = "fecha_publicacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_publicacion;

    @Column(name = "_idempresa")
    private int _idEmpresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public Date getIniPeriodo() {
        return ini_periodo;
    }

    public void setIniPeriodo(Date ini_periodo) {
        this.ini_periodo = ini_periodo;
    }

    public Date getFinPeriodo() {
        return fin_periodo;
    }

    public void setFinPeriodo(Date fin_periodo) {
        this.fin_periodo = fin_periodo;
    }

    public Date getFechaPublicacion() {
        return fecha_publicacion;
    }

    public void setFechaPublicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getIdEmpresa() {
        return _idEmpresa;
    }

    public void setIdEmpresa(int _idEmpresa) {
        this._idEmpresa = _idEmpresa;
    }

}
