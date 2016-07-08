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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
	@NamedQuery(name = "Municipio.findByIdmunicipio", query = "SELECT m FROM Municipio m WHERE m.idmunicipio = :idmunicipio"),
	@NamedQuery(name = "Municipio.findByNombremunicipio", query = "SELECT m FROM Municipio m WHERE m.nombremunicipio = :nombremunicipio")})
public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmunicipio")
	private Integer idmunicipio;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombremunicipio")
	private String nombremunicipio;
	@JoinColumn(name = "departamento_iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false)
	private Departamento departamentoIddepartamento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioIdmunicipio")
	private List<Candidato> candidatoList;

	public Municipio() {
	}

	public Municipio(Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public Municipio(Integer idmunicipio, String nombremunicipio) {
		this.idmunicipio = idmunicipio;
		this.nombremunicipio = nombremunicipio;
	}

	public Integer getIdmunicipio() {
		return idmunicipio;
	}

	public void setIdmunicipio(Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public String getNombremunicipio() {
		return nombremunicipio;
	}

	public void setNombremunicipio(String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}

	public Departamento getDepartamentoIddepartamento() {
		return departamentoIddepartamento;
	}

	public void setDepartamentoIddepartamento(Departamento departamentoIddepartamento) {
		this.departamentoIddepartamento = departamentoIddepartamento;
	}

	@XmlTransient
	public List<Candidato> getCandidatoList() {
		return candidatoList;
	}

	public void setCandidatoList(List<Candidato> candidatoList) {
		this.candidatoList = candidatoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Municipio)) {
			return false;
		}
		Municipio other = (Municipio) object;
		if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombremunicipio;
	}
	
}
