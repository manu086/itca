/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades;

import java.io.Serializable;
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
@Table(name = "descuentosley")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Descuentosley.findAll", query = "SELECT d FROM Descuentosley d"),
	@NamedQuery(name = "Descuentosley.findByIdDescuento", query = "SELECT d FROM Descuentosley d WHERE d.idDescuento = :idDescuento"),
	@NamedQuery(name = "Descuentosley.findByNombre", query = "SELECT d FROM Descuentosley d WHERE d.nombre = :nombre"),
	@NamedQuery(name = "Descuentosley.findByPorcentaje", query = "SELECT d FROM Descuentosley d WHERE d.porcentaje = :porcentaje")})
public class Descuentosley implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDescuento")
	private Integer idDescuento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "porcentaje")
	private String porcentaje;
	@JoinColumn(name = "planilla_idplanilla", referencedColumnName = "idplanilla")
    @ManyToOne(optional = false)
	private Planilla planillaIdplanilla;

	public Descuentosley() {
	}

	public Descuentosley(Integer idDescuento) {
		this.idDescuento = idDescuento;
	}

	public Descuentosley(Integer idDescuento, String nombre, String porcentaje) {
		this.idDescuento = idDescuento;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}

	public Integer getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(Integer idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Planilla getPlanillaIdplanilla() {
		return planillaIdplanilla;
	}

	public void setPlanillaIdplanilla(Planilla planillaIdplanilla) {
		this.planillaIdplanilla = planillaIdplanilla;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idDescuento != null ? idDescuento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Descuentosley)) {
			return false;
		}
		Descuentosley other = (Descuentosley) object;
		if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Descuentosley[ idDescuento=" + idDescuento + " ]";
	}
	
}
