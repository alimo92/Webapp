package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.BlockedUserDao;
import org.ws.entities.BlockedUser;

@Repository
public class BlockedUserDaoImpl  extends GenericDaoImpl<BlockedUser, Integer> implements BlockedUserDao{

	@PersistenceContext
	EntityManager em;
	
	
	public BlockedUserDaoImpl() {
		super(BlockedUser.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}


}
