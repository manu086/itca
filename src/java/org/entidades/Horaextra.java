/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "horaextra")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Horaextra.findAll", query = "SELECT h FROM Horaextra h"),
	@NamedQuery(name = "Horaextra.findByIdhoraextra", query = "SELECT h FROM Horaextra h WHERE h.idhoraextra = :idhoraextra"),
	@NamedQuery(name = "Horaextra.findByInicio", query = "SELECT h FROM Horaextra h WHERE h.inicio = :inicio"),
	@NamedQuery(name = "Horaextra.findByFin", query = "SELECT h FROM Horaextra h WHERE h.fin = :fin")})
public class Horaextra implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhoraextra")
	private Integer idhoraextra;
	@Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fin")
	private String fin;
	@JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
	private Empleado empleadoIdempleado;

	public Horaextra() {
	}

	public Horaextra(Integer idhoraextra) {
		this.idhoraextra = idhoraextra;
	}

	public Horaextra(Integer idhoraextra, Date inicio, String fin) {
		this.idhoraextra = idhoraextra;
		this.inicio = inicio;
		this.fin = fin;
	}

	public Integer getIdhoraextra() {
		return idhoraextra;
	}

	public void setIdhoraextra(Integer idhoraextra) {
		this.idhoraextra = idhoraextra;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
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
		hash += (idhoraextra != null ? idhoraextra.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Horaextra)) {
			return false;
		}
		Horaextra other = (Horaextra) object;
		if ((this.idhoraextra == null && other.idhoraextra != null) || (this.idhoraextra != null && !this.idhoraextra.equals(other.idhoraextra))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Horaextra[ idhoraextra=" + idhoraextra + " ]";
	}
	
}
