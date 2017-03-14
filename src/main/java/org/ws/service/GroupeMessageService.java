package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Groupe;
import org.ws.entities.GroupeMessage;
import org.ws.entities.User;

public interface GroupeMessageService extends GenericService<GroupeMessage, Integer> {
	public JSONObject AddGroupeMessage(String json) throws JSONException;
	public JSONArray GetAllGroupeMessage(int groupeid) throws JSONException;
	public JSONObject GetGroupeMessageById(int id) throws JSONException;
}
