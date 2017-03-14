package org.ws.service.impl;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.ReportPostDao;
import org.ws.entities.ReportPost;
import org.ws.service.ReportPostService;
@Service
public class ReportPostServiceImpl  extends GenericServiceImpl<ReportPost, Integer> implements ReportPostService{
	@Autowired
	ReportPostDao ReportPostDao;
		
	@Override
	protected GenericDao<ReportPost, Integer> getDao() {
		return ReportPostDao;
	}

	@Override
	public JSONObject getJSON(ReportPost model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportPost getModel(JSONObject object) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}
}
