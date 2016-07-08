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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
	@NamedQuery(name = "Permiso.findByIdpermiso", query = "SELECT p FROM Permiso p WHERE p.idpermiso = :idpermiso"),
	@NamedQuery(name = "Permiso.findByDesde", query = "SELECT p FROM Permiso p WHERE p.desde = :desde"),
	@NamedQuery(name = "Permiso.findByHasta", query = "SELECT p FROM Permiso p WHERE p.hasta = :hasta"),
	@NamedQuery(name = "Permiso.findByComentarios", query = "SELECT p FROM Permiso p WHERE p.comentarios = :comentarios")})
public class Permiso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpermiso")
	private Integer idpermiso;
	@Column(name = "desde")
    @Temporal(TemporalType.TIMESTAMP)
	private Date desde;
	@Column(name = "hasta")
    @Temporal(TemporalType.TIMESTAMP)
	private Date hasta;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comentarios")
	private String comentarios;
	@JoinColumn(name = "tipopermiso_idtipopermiso", referencedColumnName = "idtipopermiso")
    @ManyToOne(optional = false)
	private Tipopermiso tipopermisoIdtipopermiso;
	@JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
	private Empleado empleadoIdempleado;

	public Permiso() {
	}

	public Permiso(Integer idpermiso) {
		this.idpermiso = idpermiso;
	}

	public Permiso(Integer idpermiso, String comentarios) {
		this.idpermiso = idpermiso;
		this.comentarios = comentarios;
	}

	public Integer getIdpermiso() {
		return idpermiso;
	}

	public void setIdpermiso(Integer idpermiso) {
		this.idpermiso = idpermiso;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Tipopermiso getTipopermisoIdtipopermiso() {
		return tipopermisoIdtipopermiso;
	}

	public void setTipopermisoIdtipopermiso(Tipopermiso tipopermisoIdtipopermiso) {
		this.tipopermisoIdtipopermiso = tipopermisoIdtipopermiso;
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
		hash += (idpermiso != null ? idpermiso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Permiso)) {
			return false;
		}
		Permiso other = (Permiso) object;
		if ((this.idpermiso == null && other.idpermiso != null) || (this.idpermiso != null && !this.idpermiso.equals(other.idpermiso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.entidades.Permiso[ idpermiso=" + idpermiso + " ]";
	}
	
}
