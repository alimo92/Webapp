package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.FollowerDao;
import org.ws.entities.Follower;

@Repository
public class FollowerDaoImpl extends GenericDaoImpl<Follower, Integer> implements FollowerDao{

	@PersistenceContext
	EntityManager em;
	
	public FollowerDaoImpl() {
		super(Follower.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
