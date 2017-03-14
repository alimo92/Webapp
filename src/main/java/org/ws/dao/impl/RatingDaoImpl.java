package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.RatingDao;
import org.ws.entities.Rating;
@Repository
public class RatingDaoImpl extends GenericDaoImpl<Rating, Integer> implements RatingDao{

	@PersistenceContext
	EntityManager em;
	
	public RatingDaoImpl() {
		super(Rating.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
