package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.NotificationDao;
import org.ws.entities.Notification;
import org.ws.entities.NotificationType;
import org.ws.entities.User;
import org.ws.service.NotificationService;
import org.ws.service.NotificationTypeService;
import org.ws.service.UserService;

@Service
public class NotificationServiceImpl extends GenericServiceImpl<Notification, Integer> implements NotificationService{
	
	@Autowired
	NotificationDao NotificationDao;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	NotificationTypeService NotificationTypeService;
	@Override
	protected GenericDao<Notification, Integer> getDao() {
		return NotificationDao;
	}

	@Override
	public void AddNotification(String json) throws JSONException {
		NotificationDao.create(getModel( new JSONObject(json)));
	}

	@Override
	public JSONArray GetAllNotification() throws JSONException {
		List<Notification> list = NotificationDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetNotificationById(int id) throws JSONException {
		return getJSON(NotificationDao.find(id));
	}

	@Override
	public JSONObject getJSON(Notification model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdNotification", model.getIdNotification());
		object.put("ContentNotification", model.getContentNotification());
		object.put("User", model.getUser().getIdUser());
		object.put("NotificationType", model.getNotificationType().getIdNotificationType());
		object.put("DateCreated",model.getDateCreated());
		return object;
	}

	@Override
	public Notification getModel(JSONObject object) throws JSONException {
		Notification notification = new Notification();
		notification.setContentNotification(object.getString("ContentNotification"));
		notification.setUser(UserService.find(object.getInt("User")));
		notification.setNotificationType(NotificationTypeService.find(object.getInt("NotificationType")));
		return notification;
	}
}
