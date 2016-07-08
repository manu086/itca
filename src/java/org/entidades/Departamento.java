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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
	@NamedQuery(name = "Departamento.findByIddepartamento", query = "SELECT d FROM Departamento d WHERE d.iddepartamento = :iddepartamento"),
	@NamedQuery(name = "Departamento.findByNombredepartamento", query = "SELECT d FROM Departamento d WHERE d.nombredepartamento = :nombredepartamento")})
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddepartamento")
	private Integer iddepartamento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombredepartamento")
	private String nombredepartamento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoIddepartamento")
	private List<Municipio> municipioList;
	@JoinColumn(name = "pais_idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
	private Pais paisIdpais;

	public Departamento() {
	}

	public Departamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public Departamento(Integer iddepartamento, String nombredepartamento) {
		this.iddepartamento = iddepartamento;
		this.nombredepartamento = nombredepartamento;
	}

	public Integer getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombredepartamento() {
		return nombredepartamento;
	}

	public void setNombredepartamento(String nombredepartamento) {
		this.nombredepartamento = nombredepartamento;
	}

	@XmlTransient
	public List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}

	public Pais getPaisIdpais() {
		return paisIdpais;
	}

	public void setPaisIdpais(Pais paisIdpais) {
		this.paisIdpais = paisIdpais;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Departamento)) {
			return false;
		}
		Departamento other = (Departamento) object;
		if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombredepartamento;
	}
	
}
