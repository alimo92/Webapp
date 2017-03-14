package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.GroupeUserDao;
import org.ws.entities.GroupeUser;
@Repository
public class GroupeUserDaoImpl  extends GenericDaoImpl<GroupeUser, Integer> implements GroupeUserDao  {
	@PersistenceContext
	EntityManager em;
	
	public GroupeUserDaoImpl() {
		super(GroupeUser.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
