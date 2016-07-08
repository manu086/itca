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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
	@NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
	@NamedQuery(name = "Empleado.findByIsss", query = "SELECT e FROM Empleado e WHERE e.isss = :isss"),
	@NamedQuery(name = "Empleado.findByNup", query = "SELECT e FROM Empleado e WHERE e.nup = :nup"),
	@NamedQuery(name = "Empleado.findByFechadeingreso", query = "SELECT e FROM Empleado e WHERE e.fechadeingreso = :fechadeingreso"),
	@NamedQuery(name = "Empleado.findBySueldo", query = "SELECT e FROM Empleado e WHERE e.sueldo = :sueldo")})
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempleado")
	private Integer idempleado;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "isss")
	private String isss;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nup")
	private String nup;
	@Basic(optional = false)
    @NotNull
    @Column(name = "fechadeingreso")
	private double fechadeingreso;
	@Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
	private int sueldo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
	private List<Descuento> descuentoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
	private List<Planilla> planillaList;
	@JoinColumn(name = "cargo_idcargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
	private Cargo cargoIdcargo;
	@JoinColumn(name = "afp_idafp", referencedColumnName = "idafp")
    @ManyToOne(optional = false)
	private Afp afpIdafp;
	@JoinColumn(name = "estado_idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
	private Estado estadoIdestado;
	@JoinColumn(name = "tipodeplanilla_idtipoplanilla", referencedColumnName = "idtipoplanilla")
    @ManyToOne(optional = false)
	private Tipodeplanilla tipodeplanillaIdtipoplanilla;
	@JoinColumn(name = "candidato_idcandidato", referencedColumnName = "idcandidato")
    @ManyToOne(optional = false)
	private Candidato candidatoIdcandidato;
	@JoinColumn(name = "renta_idrenta", referencedColumnName = "idrenta")
    @ManyToOne(optional = false)
	private Renta rentaIdrenta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
	private List<Horaextra> horaextraList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
	private List<Permiso> permisoList;

	public Empleado() {
	}

	public Empleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Empleado(Integer idempleado, String isss, String nup, double fechadeingreso, int sueldo) {
		this.idempleado = idempleado;
		this.isss = isss;
		this.nup = nup;
		this.fechadeingreso = fechadeingreso;
		this.sueldo = sueldo;
	}

	public Integer getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public String getIsss() {
		return isss;
	}

	public void setIsss(String isss) {
		this.isss = isss;
	}

	public String getNup() {
		return nup;
	}

	public void setNup(String nup) {
		this.nup = nup;
	}

	public double getFechadeingreso() {
		return fechadeingreso;
	}

	public void setFechadeingreso(double fechadeingreso) {
		this.fechadeingreso = fechadeingreso;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	@XmlTransient
	public List<Descuento> getDescuentoList() {
		return descuentoList;
	}

	public void setDescuentoList(List<Descuento> descuentoList) {
		this.descuentoList = descuentoList;
	}

	@XmlTransient
	public List<Planilla> getPlanillaList() {
		return planillaList;
	}

	public void setPlanillaList(List<Planilla> planillaList) {
		this.planillaList = planillaList;
	}

	public Cargo getCargoIdcargo() {
		return cargoIdcargo;
	}

	public void setCargoIdcargo(Cargo cargoIdcargo) {
		this.cargoIdcargo = cargoIdcargo;
	}

	public Afp getAfpIdafp() {
		return afpIdafp;
	}

	public void setAfpIdafp(Afp afpIdafp) {
		this.afpIdafp = afpIdafp;
	}

	public Estado getEstadoIdestado() {
		return estadoIdestado;
	}

	public void setEstadoIdestado(Estado estadoIdestado) {
		this.estadoIdestado = estadoIdestado;
	}

	public Tipodeplanilla getTipodeplanillaIdtipoplanilla() {
		return tipodeplanillaIdtipoplanilla;
	}

	public void setTipodeplanillaIdtipoplanilla(Tipodeplanilla tipodeplanillaIdtipoplanilla) {
		this.tipodeplanillaIdtipoplanilla = tipodeplanillaIdtipoplanilla;
	}

	public Candidato getCandidatoIdcandidato() {
		return candidatoIdcandidato;
	}

	public void setCandidatoIdcandidato(Candidato candidatoIdcandidato) {
		this.candidatoIdcandidato = candidatoIdcandidato;
	}

	public Renta getRentaIdrenta() {
		return rentaIdrenta;
	}

	public void setRentaIdrenta(Renta rentaIdrenta) {
		this.rentaIdrenta = rentaIdrenta;
	}

	@XmlTransient
	public List<Horaextra> getHoraextraList() {
		return horaextraList;
	}

	public void setHoraextraList(List<Horaextra> horaextraList) {
		this.horaextraList = horaextraList;
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
		hash += (idempleado != null ? idempleado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Empleado)) {
			return false;
		}
		Empleado other = (Empleado) object;
		if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Empleado[ idempleado=" + idempleado + " ]";
	}
	
}
