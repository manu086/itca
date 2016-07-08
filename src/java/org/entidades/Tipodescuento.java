/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "tipodescuento")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Tipodescuento.findAll", query = "SELECT t FROM Tipodescuento t"),
	@NamedQuery(name = "Tipodescuento.findByIdtipodescuento", query = "SELECT t FROM Tipodescuento t WHERE t.idtipodescuento = :idtipodescuento"),
	@NamedQuery(name = "Tipodescuento.findByNombre", query = "SELECT t FROM Tipodescuento t WHERE t.nombre = :nombre"),
	@NamedQuery(name = "Tipodescuento.findByObservacion", query = "SELECT t FROM Tipodescuento t WHERE t.observacion = :observacion")})
public class Tipodescuento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipodescuento")
	private Integer idtipodescuento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
	private String nombre;
	@Size(max = 255)
    @Column(name = "observacion")
	private String observacion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodescuentoIdtipodescuento")
	private List<Descuento> descuentoList;

	public Tipodescuento() {
	}

	public Tipodescuento(Integer idtipodescuento) {
		this.idtipodescuento = idtipodescuento;
	}

	public Tipodescuento(Integer idtipodescuento, String nombre) {
		this.idtipodescuento = idtipodescuento;
		this.nombre = nombre;
	}

	public Integer getIdtipodescuento() {
		return idtipodescuento;
	}

	public void setIdtipodescuento(Integer idtipodescuento) {
		this.idtipodescuento = idtipodescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@XmlTransient
	public List<Descuento> getDescuentoList() {
		return descuentoList;
	}

	public void setDescuentoList(List<Descuento> descuentoList) {
		this.descuentoList = descuentoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtipodescuento != null ? idtipodescuento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tipodescuento)) {
			return false;
		}
		Tipodescuento other = (Tipodescuento) object;
		if ((this.idtipodescuento == null && other.idtipodescuento != null) || (this.idtipodescuento != null && !this.idtipodescuento.equals(other.idtipodescuento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
