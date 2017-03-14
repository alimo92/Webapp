package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.ConversationDao;
import org.ws.entities.Conversation;
@Repository
public class ConversationDaoImpl  extends GenericDaoImpl<Conversation, Integer> implements ConversationDao{
	
	@PersistenceContext
	EntityManager em;
	
	public ConversationDaoImpl() {
		super(Conversation.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
