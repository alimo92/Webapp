package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.MessageDao;
import org.ws.entities.Message;

@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message, Integer> implements MessageDao{

	@PersistenceContext
	EntityManager em;
	
	public MessageDaoImpl() {
		super(Message.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
