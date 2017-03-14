package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.AdminGroupeDao;
import org.ws.entities.AdminGroupe;

@Repository
public class AdminGroupeDaoImpl  extends GenericDaoImpl<AdminGroupe, Integer> implements AdminGroupeDao {
	
	@PersistenceContext
	EntityManager em;
	
	public AdminGroupeDaoImpl() {
		super(AdminGroupe.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
