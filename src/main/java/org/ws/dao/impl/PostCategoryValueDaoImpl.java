package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.PostCategoryValueDao;
import org.ws.entities.PostCategoryValue;

@Repository
public class PostCategoryValueDaoImpl extends GenericDaoImpl<PostCategoryValue, Integer> implements PostCategoryValueDao{

	@PersistenceContext
	EntityManager em;
	
	public PostCategoryValueDaoImpl() {
		super(PostCategoryValue.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
