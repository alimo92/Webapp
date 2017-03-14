package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.ConversationUserDao;
import org.ws.entities.ConversationUser;

@Repository
public class ConversationUserDaoImpl extends GenericDaoImpl<ConversationUser, Integer> implements ConversationUserDao {
	@PersistenceContext
	EntityManager em;
	
	public ConversationUserDaoImpl() {
		super(ConversationUser.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
