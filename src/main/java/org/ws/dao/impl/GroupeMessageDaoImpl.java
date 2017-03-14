package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.GroupeMessageDao;
import org.ws.entities.GroupeMessage;

@Repository
public class GroupeMessageDaoImpl extends GenericDaoImpl<GroupeMessage, Integer> implements GroupeMessageDao{

	@PersistenceContext
	EntityManager em;
	
	public GroupeMessageDaoImpl() {
		super(GroupeMessage.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
