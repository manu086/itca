/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades.procesos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.entidades.Descuento;

/**
 *
 * @author Manuel
 */
@Stateless
public class DescuentoFacade extends AbstractFacade<Descuento> {

	@PersistenceContext(unitName = "rrhhPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public DescuentoFacade() {
		super(Descuento.class);
	}
	
}
