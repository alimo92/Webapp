package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.TagDao;
import org.ws.entities.Tag;

@Repository
public class TagDaoImpl extends GenericDaoImpl<Tag, Integer> implements TagDao{

	@PersistenceContext
	EntityManager em;
	
	public TagDaoImpl() {
		super(Tag.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
