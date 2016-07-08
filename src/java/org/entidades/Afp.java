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
@Table(name = "afp")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Afp.findAll", query = "SELECT a FROM Afp a"),
	@NamedQuery(name = "Afp.findByIdafp", query = "SELECT a FROM Afp a WHERE a.idafp = :idafp"),
	@NamedQuery(name = "Afp.findByNombreafp", query = "SELECT a FROM Afp a WHERE a.nombreafp = :nombreafp")})
public class Afp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idafp")
	private Integer idafp;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreafp")
	private String nombreafp;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "afpIdafp")
	private List<Empleado> empleadoList;

	public Afp() {
	}

	public Afp(Integer idafp) {
		this.idafp = idafp;
	}

	public Afp(Integer idafp, String nombreafp) {
		this.idafp = idafp;
		this.nombreafp = nombreafp;
	}

	public Integer getIdafp() {
		return idafp;
	}

	public void setIdafp(Integer idafp) {
		this.idafp = idafp;
	}

	public String getNombreafp() {
		return nombreafp;
	}

	public void setNombreafp(String nombreafp) {
		this.nombreafp = nombreafp;
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
		hash += (idafp != null ? idafp.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Afp)) {
			return false;
		}
		Afp other = (Afp) object;
		if ((this.idafp == null && other.idafp != null) || (this.idafp != null && !this.idafp.equals(other.idafp))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombreafp;
		//return "org.entidades.Afp[ idafp=" + idafp + " ]";
	}
	
}
