package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.NotificationType;

public interface NotificationTypeService extends GenericService<NotificationType, Integer>{
	public void AddNotificationType(String json) throws JSONException;
	public JSONArray GetAllNotificationType() throws JSONException;
	public JSONObject GetNotificationTypeById(int id) throws JSONException;
}
