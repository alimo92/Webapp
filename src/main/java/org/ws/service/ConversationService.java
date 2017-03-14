package org.ws.service;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.ws.core.service.GenericService;
import org.ws.entities.Conversation;
import org.ws.entities.User;

public interface ConversationService extends GenericService<Conversation, Integer>{
	public Conversation GetConversationOfUsers(List<User> users);
	public Conversation CreateConversationOfUsers(List<User> users);
	public Conversation findConversationByName(String Name);
	public Conversation findConversationByUsers(List<User> users);
	public List<Conversation> GetAllConversationsOfUser(User user);
	public List<Conversation> GetAllConversationsOfUser(int iduser);
	JSONArray GetConversationsOfUser(int iduser) throws JSONException;

}
