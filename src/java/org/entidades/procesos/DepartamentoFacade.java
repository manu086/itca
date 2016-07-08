/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades.procesos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.entidades.Departamento;

/**
 *
 * @author Manuel
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

	@PersistenceContext(unitName = "rrhhPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public DepartamentoFacade() {
		super(Departamento.class);
	}
	
}
