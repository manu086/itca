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
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
	@NamedQuery(name = "Candidato.findByIdcandidato", query = "SELECT c FROM Candidato c WHERE c.idcandidato = :idcandidato"),
	@NamedQuery(name = "Candidato.findByNombres", query = "SELECT c FROM Candidato c WHERE c.nombres = :nombres"),
	@NamedQuery(name = "Candidato.findByApellidos", query = "SELECT c FROM Candidato c WHERE c.apellidos = :apellidos"),
	@NamedQuery(name = "Candidato.findByFechadenacimiento", query = "SELECT c FROM Candidato c WHERE c.fechadenacimiento = :fechadenacimiento"),
	@NamedQuery(name = "Candidato.findByTelefono", query = "SELECT c FROM Candidato c WHERE c.telefono = :telefono"),
	@NamedQuery(name = "Candidato.findByDui", query = "SELECT c FROM Candidato c WHERE c.dui = :dui"),
	@NamedQuery(name = "Candidato.findByNit", query = "SELECT c FROM Candidato c WHERE c.nit = :nit"),
	@NamedQuery(name = "Candidato.findByDireccion", query = "SELECT c FROM Candidato c WHERE c.direccion = :direccion")})
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcandidato")
	private Integer idcandidato;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
	private String nombres;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
	private String apellidos;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechadenacimiento")
	private String fechadenacimiento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
	private String telefono;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dui")
	private String dui;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nit")
	private String nit;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidatoIdcandidato")
	private List<Empleado> empleadoList;
	@JoinColumn(name = "estadocivil_idestadocivil", referencedColumnName = "idestadocivil")
    @ManyToOne(optional = false)
	private Estadocivil estadocivilIdestadocivil;
	@JoinColumn(name = "municipio_idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
	private Municipio municipioIdmunicipio;

	public Candidato() {
	}

	public Candidato(Integer idcandidato) {
		this.idcandidato = idcandidato;
	}

	public Candidato(Integer idcandidato, String nombres, String apellidos, String fechadenacimiento, String telefono, String dui, String nit, String direccion) {
		this.idcandidato = idcandidato;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechadenacimiento = fechadenacimiento;
		this.telefono = telefono;
		this.dui = dui;
		this.nit = nit;
		this.direccion = direccion;
	}

	public Integer getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(Integer idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(String fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@XmlTransient
	public List<Empleado> getEmpleadoList() {
		return empleadoList;
	}

	public void setEmpleadoList(List<Empleado> empleadoList) {
		this.empleadoList = empleadoList;
	}

	public Estadocivil getEstadocivilIdestadocivil() {
		return estadocivilIdestadocivil;
	}

	public void setEstadocivilIdestadocivil(Estadocivil estadocivilIdestadocivil) {
		this.estadocivilIdestadocivil = estadocivilIdestadocivil;
	}

	public Municipio getMunicipioIdmunicipio() {
		return municipioIdmunicipio;
	}

	public void setMunicipioIdmunicipio(Municipio municipioIdmunicipio) {
		this.municipioIdmunicipio = municipioIdmunicipio;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcandidato != null ? idcandidato.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Candidato)) {
			return false;
		}
		Candidato other = (Candidato) object;
		if ((this.idcandidato == null && other.idcandidato != null) || (this.idcandidato != null && !this.idcandidato.equals(other.idcandidato))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombres;
	}
	
}
