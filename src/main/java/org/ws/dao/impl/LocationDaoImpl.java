package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.LocationDao;
import org.ws.entities.Location;

@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location, Integer> implements LocationDao{
	
	@PersistenceContext
	EntityManager em;
	
	public LocationDaoImpl() {
		super(Location.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
