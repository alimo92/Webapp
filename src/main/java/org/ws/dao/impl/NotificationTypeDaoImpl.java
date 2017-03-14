package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.NotificationTypeDao;
import org.ws.entities.NotificationType;
@Repository
public class NotificationTypeDaoImpl extends GenericDaoImpl<NotificationType, Integer> implements NotificationTypeDao {

	@PersistenceContext
	EntityManager em;
	
	public NotificationTypeDaoImpl() {
		super(NotificationType.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
