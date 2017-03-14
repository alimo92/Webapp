package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.CategoryDao;
import org.ws.entities.Category;

@Repository
public class CategoryDaoImpl  extends GenericDaoImpl<Category, Integer> implements CategoryDao {
	
	@PersistenceContext
	EntityManager em;
	
	public CategoryDaoImpl() {
		super(Category.class);

	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
