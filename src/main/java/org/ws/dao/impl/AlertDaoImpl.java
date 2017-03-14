package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.AlertDao;
import org.ws.entities.Alert;
@Repository
public class AlertDaoImpl  extends GenericDaoImpl<Alert, Integer> implements AlertDao{

	@PersistenceContext
	EntityManager em;
	
	
	public AlertDaoImpl() {
		super(Alert.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}


}
