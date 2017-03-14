package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.CommentDao;
import org.ws.entities.Comment;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment, Integer> implements CommentDao {

	@PersistenceContext
	EntityManager em;
	
	public CommentDaoImpl() {
		super(Comment.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
