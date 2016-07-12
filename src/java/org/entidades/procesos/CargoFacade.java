/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades.procesos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.entidades.Cargo;

/**
 *
 * @author Manuel
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

	@PersistenceContext(unitName = "rrhhPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CargoFacade() {
		super(Cargo.class);
	}
	
	public List<Cargo> listarTodos(){
	Query q = em.createNamedQuery("Cargo.findAll");
	List c =  q.getResultList();
	return c;
	}
	
}
