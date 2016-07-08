/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "descuento")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
	@NamedQuery(name = "Descuento.findByIddescuento", query = "SELECT d FROM Descuento d WHERE d.iddescuento = :iddescuento"),
	@NamedQuery(name = "Descuento.findByComentario", query = "SELECT d FROM Descuento d WHERE d.comentario = :comentario"),
	@NamedQuery(name = "Descuento.findByMonto", query = "SELECT d FROM Descuento d WHERE d.monto = :monto")})
public class Descuento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddescuento")
	private Integer iddescuento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comentario")
	private String comentario;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "monto")
	private BigDecimal monto;
	@JoinColumn(name = "tipodescuento_idtipodescuento", referencedColumnName = "idtipodescuento")
    @ManyToOne(optional = false)
	private Tipodescuento tipodescuentoIdtipodescuento;
	@JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
	private Empleado empleadoIdempleado;

	public Descuento() {
	}

	public Descuento(Integer iddescuento) {
		this.iddescuento = iddescuento;
	}

	public Descuento(Integer iddescuento, String comentario) {
		this.iddescuento = iddescuento;
		this.comentario = comentario;
	}

	public Integer getIddescuento() {
		return iddescuento;
	}

	public void setIddescuento(Integer iddescuento) {
		this.iddescuento = iddescuento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Tipodescuento getTipodescuentoIdtipodescuento() {
		return tipodescuentoIdtipodescuento;
	}

	public void setTipodescuentoIdtipodescuento(Tipodescuento tipodescuentoIdtipodescuento) {
		this.tipodescuentoIdtipodescuento = tipodescuentoIdtipodescuento;
	}

	public Empleado getEmpleadoIdempleado() {
		return empleadoIdempleado;
	}

	public void setEmpleadoIdempleado(Empleado empleadoIdempleado) {
		this.empleadoIdempleado = empleadoIdempleado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iddescuento != null ? iddescuento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Descuento)) {
			return false;
		}
		Descuento other = (Descuento) object;
		if ((this.iddescuento == null && other.iddescuento != null) || (this.iddescuento != null && !this.iddescuento.equals(other.iddescuento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Descuento[ iddescuento=" + iddescuento + " ]";
	}
	
}
