package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.NotificationDao;
import org.ws.entities.Notification;
@Repository
public class NotificationDaoImpl  extends GenericDaoImpl<Notification, Integer> implements NotificationDao{
	
	@PersistenceContext
	EntityManager em;
	
	public NotificationDaoImpl() {
		super(Notification.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}


}
