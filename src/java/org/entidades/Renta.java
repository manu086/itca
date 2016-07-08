/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "renta")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r"),
	@NamedQuery(name = "Renta.findByIdrenta", query = "SELECT r FROM Renta r WHERE r.idrenta = :idrenta"),
	@NamedQuery(name = "Renta.findByDesde", query = "SELECT r FROM Renta r WHERE r.desde = :desde"),
	@NamedQuery(name = "Renta.findByHasta", query = "SELECT r FROM Renta r WHERE r.hasta = :hasta"),
	@NamedQuery(name = "Renta.findByComentario", query = "SELECT r FROM Renta r WHERE r.comentario = :comentario"),
	@NamedQuery(name = "Renta.findByPorcentaje", query = "SELECT r FROM Renta r WHERE r.porcentaje = :porcentaje")})
public class Renta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrenta")
	private Integer idrenta;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
    @NotNull
    @Column(name = "desde")
	private BigDecimal desde;
	@Basic(optional = false)
    @NotNull
    @Column(name = "hasta")
	private BigDecimal hasta;
	@Size(max = 45)
    @Column(name = "comentario")
	private String comentario;
	@Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje")
	private BigDecimal porcentaje;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rentaIdrenta")
	private List<Empleado> empleadoList;
	@JoinColumn(name = "tiporenta_idtiporenta", referencedColumnName = "idtiporenta")
    @ManyToOne(optional = false)
	private Tiporenta tiporentaIdtiporenta;

	public Renta() {
	}

	public Renta(Integer idrenta) {
		this.idrenta = idrenta;
	}

	public Renta(Integer idrenta, BigDecimal desde, BigDecimal hasta, BigDecimal porcentaje) {
		this.idrenta = idrenta;
		this.desde = desde;
		this.hasta = hasta;
		this.porcentaje = porcentaje;
	}

	public Integer getIdrenta() {
		return idrenta;
	}

	public void setIdrenta(Integer idrenta) {
		this.idrenta = idrenta;
	}

	public BigDecimal getDesde() {
		return desde;
	}

	public void setDesde(BigDecimal desde) {
		this.desde = desde;
	}

	public BigDecimal getHasta() {
		return hasta;
	}

	public void setHasta(BigDecimal hasta) {
		this.hasta = hasta;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	@XmlTransient
	public List<Empleado> getEmpleadoList() {
		return empleadoList;
	}

	public void setEmpleadoList(List<Empleado> empleadoList) {
		this.empleadoList = empleadoList;
	}

	public Tiporenta getTiporentaIdtiporenta() {
		return tiporentaIdtiporenta;
	}

	public void setTiporentaIdtiporenta(Tiporenta tiporentaIdtiporenta) {
		this.tiporentaIdtiporenta = tiporentaIdtiporenta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idrenta != null ? idrenta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Renta)) {
			return false;
		}
		Renta other = (Renta) object;
		if ((this.idrenta == null && other.idrenta != null) || (this.idrenta != null && !this.idrenta.equals(other.idrenta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Renta[ idrenta=" + idrenta + " ]";
	}
	
}
