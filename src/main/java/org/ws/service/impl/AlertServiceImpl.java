package org.ws.service.impl;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.AlertDao;
import org.ws.entities.Alert;
import org.ws.service.AlertService;

@Service
public class AlertServiceImpl extends GenericServiceImpl<Alert, Integer> implements AlertService{
	@Autowired
	AlertDao AlertDao;
		
	@Override
	protected GenericDao<Alert, Integer> getDao() {
		return AlertDao;
	}

	@Override
	public JSONObject getJSON(Alert model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alert getModel(JSONObject object) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
