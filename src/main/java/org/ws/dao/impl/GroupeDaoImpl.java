package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.GroupeDao;
import org.ws.entities.Groupe;
@Repository
public class GroupeDaoImpl extends GenericDaoImpl<Groupe, Integer> implements GroupeDao{
	
	@PersistenceContext
	EntityManager em;

	public GroupeDaoImpl() {
		super(Groupe.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
