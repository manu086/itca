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
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
	@NamedQuery(name = "Pais.findByIdpais", query = "SELECT p FROM Pais p WHERE p.idpais = :idpais"),
	@NamedQuery(name = "Pais.findByNombrePais", query = "SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais")})
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpais")
	private Integer idpais;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_pais")
	private String nombrePais;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paisIdpais")
	private List<Departamento> departamentoList;

	public Pais() {
	}

	public Pais(Integer idpais) {
		this.idpais = idpais;
	}

	public Pais(Integer idpais, String nombrePais) {
		this.idpais = idpais;
		this.nombrePais = nombrePais;
	}

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@XmlTransient
	public List<Departamento> getDepartamentoList() {
		return departamentoList;
	}

	public void setDepartamentoList(List<Departamento> departamentoList) {
		this.departamentoList = departamentoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idpais != null ? idpais.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Pais)) {
			return false;
		}
		Pais other = (Pais) object;
		if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombrePais;
	}
	
}
