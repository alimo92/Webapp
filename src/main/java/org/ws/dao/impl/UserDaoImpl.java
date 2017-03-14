package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.UserDao;
import org.ws.entities.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
