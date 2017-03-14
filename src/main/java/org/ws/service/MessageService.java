package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Message;

public interface MessageService extends GenericService<Message, Integer>{
	public JSONObject SendMessage(String json) throws JSONException;
	public JSONArray GetMessagesOfConversation(int i) throws JSONException;

}
