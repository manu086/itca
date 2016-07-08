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
@Table(name = "tipodeplanilla")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Tipodeplanilla.findAll", query = "SELECT t FROM Tipodeplanilla t"),
	@NamedQuery(name = "Tipodeplanilla.findByIdtipoplanilla", query = "SELECT t FROM Tipodeplanilla t WHERE t.idtipoplanilla = :idtipoplanilla"),
	@NamedQuery(name = "Tipodeplanilla.findByNombreplanilla", query = "SELECT t FROM Tipodeplanilla t WHERE t.nombreplanilla = :nombreplanilla")})
public class Tipodeplanilla implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoplanilla")
	private Integer idtipoplanilla;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreplanilla")
	private String nombreplanilla;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodeplanillaIdtipoplanilla")
	private List<Empleado> empleadoList;

	public Tipodeplanilla() {
	}

	public Tipodeplanilla(Integer idtipoplanilla) {
		this.idtipoplanilla = idtipoplanilla;
	}

	public Tipodeplanilla(Integer idtipoplanilla, String nombreplanilla) {
		this.idtipoplanilla = idtipoplanilla;
		this.nombreplanilla = nombreplanilla;
	}

	public Integer getIdtipoplanilla() {
		return idtipoplanilla;
	}

	public void setIdtipoplanilla(Integer idtipoplanilla) {
		this.idtipoplanilla = idtipoplanilla;
	}

	public String getNombreplanilla() {
		return nombreplanilla;
	}

	public void setNombreplanilla(String nombreplanilla) {
		this.nombreplanilla = nombreplanilla;
	}

	@XmlTransient
	public List<Empleado> getEmpleadoList() {
		return empleadoList;
	}

	public void setEmpleadoList(List<Empleado> empleadoList) {
		this.empleadoList = empleadoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtipoplanilla != null ? idtipoplanilla.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tipodeplanilla)) {
			return false;
		}
		Tipodeplanilla other = (Tipodeplanilla) object;
		if ((this.idtipoplanilla == null && other.idtipoplanilla != null) || (this.idtipoplanilla != null && !this.idtipoplanilla.equals(other.idtipoplanilla))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombreplanilla;
	}
	
}
