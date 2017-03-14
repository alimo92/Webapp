package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.NotificationTypeDao;
import org.ws.entities.NotificationType;
import org.ws.service.NotificationTypeService;
@Service
public class NotificationTypeServiceImpl extends GenericServiceImpl<NotificationType, Integer> implements NotificationTypeService{

	@Autowired
	NotificationTypeDao NotificationTypeDao;
	
	@Override
	protected GenericDao<NotificationType, Integer> getDao() {
		return NotificationTypeDao;
	}

	@Override
	public void AddNotificationType(String json) throws JSONException {
		NotificationTypeDao.create(getModel(new JSONObject(json)));
	}

	@Override
	public JSONArray GetAllNotificationType() throws JSONException {
		List<NotificationType> list= NotificationTypeDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetNotificationTypeById(int id) throws JSONException {
		NotificationType notificationtype = NotificationTypeDao.find(id);
		return getJSON(notificationtype);
	}
	
	@Override
	public JSONObject getJSON(NotificationType model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdNotificationType", model.getIdNotificationType());
		object.put("TypeNotification", model.getTypeNotification());
		object.put("DateCreated", model.getDateCreated());
		return object;
	}

	@Override
	public NotificationType getModel(JSONObject object) throws JSONException {
		NotificationType notificationtype = new NotificationType();
		notificationtype.setTypeNotification(object.getString("TypeNotification"));
		return notificationtype;
	}
}
