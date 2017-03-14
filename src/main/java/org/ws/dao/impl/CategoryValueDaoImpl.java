package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.CategoryValueDao;
import org.ws.entities.CategoryValue;

@Repository
public class CategoryValueDaoImpl extends GenericDaoImpl<CategoryValue, Integer> implements CategoryValueDao {

	@PersistenceContext
	EntityManager em;
	
	public CategoryValueDaoImpl() {
		super(CategoryValue.class);

	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
