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
@Table(name = "tipopermiso")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Tipopermiso.findAll", query = "SELECT t FROM Tipopermiso t"),
	@NamedQuery(name = "Tipopermiso.findByIdtipopermiso", query = "SELECT t FROM Tipopermiso t WHERE t.idtipopermiso = :idtipopermiso"),
	@NamedQuery(name = "Tipopermiso.findByNombre", query = "SELECT t FROM Tipopermiso t WHERE t.nombre = :nombre")})
public class Tipopermiso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopermiso")
	private Integer idtipopermiso;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipopermisoIdtipopermiso")
	private List<Permiso> permisoList;

	public Tipopermiso() {
	}

	public Tipopermiso(Integer idtipopermiso) {
		this.idtipopermiso = idtipopermiso;
	}

	public Tipopermiso(Integer idtipopermiso, String nombre) {
		this.idtipopermiso = idtipopermiso;
		this.nombre = nombre;
	}

	public Integer getIdtipopermiso() {
		return idtipopermiso;
	}

	public void setIdtipopermiso(Integer idtipopermiso) {
		this.idtipopermiso = idtipopermiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlTransient
	public List<Permiso> getPermisoList() {
		return permisoList;
	}

	public void setPermisoList(List<Permiso> permisoList) {
		this.permisoList = permisoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtipopermiso != null ? idtipopermiso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tipopermiso)) {
			return false;
		}
		Tipopermiso other = (Tipopermiso) object;
		if ((this.idtipopermiso == null && other.idtipopermiso != null) || (this.idtipopermiso != null && !this.idtipopermiso.equals(other.idtipopermiso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
