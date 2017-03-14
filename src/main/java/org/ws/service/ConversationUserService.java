package org.ws.service;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.ws.core.service.GenericService;
import org.ws.entities.Conversation;
import org.ws.entities.ConversationUser;
import org.ws.entities.User;

public interface ConversationUserService extends GenericService<ConversationUser, Integer> {
	public void AddUserToConversation(Conversation conversation, User user);
	public void AddUsersToConversation(Conversation conversation,List<User> users);
	JSONArray getConversationUsers(int idconversation) throws JSONException;

}
