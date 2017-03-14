package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.PostDao;
import org.ws.entities.Post;

@Repository
public class PostDaoImpl extends GenericDaoImpl<Post, Integer> implements PostDao{

	@PersistenceContext
	EntityManager em;
	
	public PostDaoImpl() {
		super(Post.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
