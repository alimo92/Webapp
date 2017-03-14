package org.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.MessageDao;
import org.ws.entities.Conversation;
import org.ws.entities.Message;
import org.ws.entities.User;
import org.ws.service.ConversationService;
import org.ws.service.MessageService;
import org.ws.service.UserService;
@Service
public class MessageServiceImpl  extends GenericServiceImpl<Message, Integer> implements MessageService{
	@Autowired
	MessageDao MessageDao;
	
	@Autowired
	ConversationService ConversationService;
	
	@Autowired
	UserService UserService;
	
	@Override
	protected GenericDao<Message, Integer> getDao() {
		return MessageDao;
	}

	@Override
	public JSONObject getJSON(Message model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdMessage", model.getIdMessage());
		object.put("DateCreated", model.getDateCreated());
		object.put("Conversation", model.getConversation().getIdConversation());
		object.put("User", model.getUser().getIdUser());
		object.put("ContentMessage", model.getContentMessage());
		return object;
	}

	@Override
	public Message getModel(JSONObject object) throws JSONException {
		Message model = new Message();
		model.setContentMessage(object.getString("ContentMessage"));
		model.setUser(UserService.find(object.getInt("User")));
		return model;
	}

	@Override
	public JSONObject SendMessage(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		Conversation conversation = ConversationService.GetConversationOfUsers(getUsers(object));
		Message message = getModel(object);
		message.setConversation(conversation);
		MessageDao.create(message);
		return new JSONObject().put("Message", "Message Sent");
	}
	
	private List<User> getUsers(JSONObject object) throws JSONException{
		List<User> listuser = new ArrayList<User>();
		listuser.add(UserService.find(object.getInt("User")));
		JSONArray array = object.getJSONArray("MessageReceivers");
		for(int i=0;i<array.length();i++){
			User user = UserService.find(array.getJSONObject(i).getInt("IdReceiver"));
			listuser.add(user);
		}
		return listuser;
	}

	@Override
	public JSONArray GetMessagesOfConversation(int i) throws JSONException {
		JSONArray array = new JSONArray();
		Conversation conversation = ConversationService.find(i);
		List<Message> messages = (List<Message>) conversation.getMessages();
		for(int j=0;j<messages.size();j++){
			array.put(getJSON(messages.get(j)));
		}
		return array;
	}
}
