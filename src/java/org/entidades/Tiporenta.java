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
@Table(name = "tiporenta")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Tiporenta.findAll", query = "SELECT t FROM Tiporenta t"),
	@NamedQuery(name = "Tiporenta.findByIdtiporenta", query = "SELECT t FROM Tiporenta t WHERE t.idtiporenta = :idtiporenta"),
	@NamedQuery(name = "Tiporenta.findByNombre", query = "SELECT t FROM Tiporenta t WHERE t.nombre = :nombre"),
	@NamedQuery(name = "Tiporenta.findByComentario", query = "SELECT t FROM Tiporenta t WHERE t.comentario = :comentario")})
public class Tiporenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtiporenta")
	private Integer idtiporenta;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
	private String nombre;
	@Size(max = 45)
    @Column(name = "comentario")
	private String comentario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tiporentaIdtiporenta")
	private List<Renta> rentaList;

	public Tiporenta() {
	}

	public Tiporenta(Integer idtiporenta) {
		this.idtiporenta = idtiporenta;
	}

	public Tiporenta(Integer idtiporenta, String nombre) {
		this.idtiporenta = idtiporenta;
		this.nombre = nombre;
	}

	public Integer getIdtiporenta() {
		return idtiporenta;
	}

	public void setIdtiporenta(Integer idtiporenta) {
		this.idtiporenta = idtiporenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@XmlTransient
	public List<Renta> getRentaList() {
		return rentaList;
	}

	public void setRentaList(List<Renta> rentaList) {
		this.rentaList = rentaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtiporenta != null ? idtiporenta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tiporenta)) {
			return false;
		}
		Tiporenta other = (Tiporenta) object;
		if ((this.idtiporenta == null && other.idtiporenta != null) || (this.idtiporenta != null && !this.idtiporenta.equals(other.idtiporenta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
