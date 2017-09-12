/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palmigiros.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bratc
 */
@Entity
@Table(name = "giros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giros.findAll", query = "SELECT g FROM Giros g")
    , @NamedQuery(name = "Giros.findById", query = "SELECT g FROM Giros g WHERE g.id = :id")
    , @NamedQuery(name = "Giros.findByFecha", query = "SELECT g FROM Giros g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "Giros.findByEstado", query = "SELECT g FROM Giros g WHERE g.estado = :estado")
    , @NamedQuery(name = "Giros.findByMonto", query = "SELECT g FROM Giros g WHERE g.monto = :monto")})
public class Giros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private Boolean estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "idCiudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudad;
    @JoinColumn(name = "idClienteEmisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idClienteEmisor;
    @JoinColumn(name = "idClienteReceptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idClienteReceptor;

    public Giros() {
    }

    public Giros(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Clientes getIdClienteEmisor() {
        return idClienteEmisor;
    }

    public void setIdClienteEmisor(Clientes idClienteEmisor) {
        this.idClienteEmisor = idClienteEmisor;
    }

    public Clientes getIdClienteReceptor() {
        return idClienteReceptor;
    }

    public void setIdClienteReceptor(Clientes idClienteReceptor) {
        this.idClienteReceptor = idClienteReceptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giros)) {
            return false;
        }
        Giros other = (Giros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.palmigiros.jpa.entities.Giros[ id=" + id + " ]";
    }
    
}
