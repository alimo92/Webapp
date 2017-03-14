package org.ws.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.ws.core.dao.GenericDaoImpl;
import org.ws.dao.ReportPostDao;
import org.ws.entities.ReportPost;
@Repository
public class ReportPostDaoImpl  extends GenericDaoImpl<ReportPost, Integer> implements ReportPostDao{

	@PersistenceContext
	EntityManager em;
	
	public ReportPostDaoImpl() {
		super(ReportPost.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
