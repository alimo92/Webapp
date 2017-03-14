package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Notification;

public interface NotificationService extends GenericService<Notification, Integer>{
	public void AddNotification(String json) throws JSONException;
	public JSONArray GetAllNotification() throws JSONException;
	public JSONObject GetNotificationById(int id) throws JSONException;
}
