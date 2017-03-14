package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.ConversationUserDao;
import org.ws.entities.Conversation;
import org.ws.entities.ConversationUser;
import org.ws.entities.User;
import org.ws.service.ConversationService;
import org.ws.service.ConversationUserService;
import org.ws.service.UserService;
@Service
public class ConversationUserServiceImpl extends GenericServiceImpl<ConversationUser, Integer> implements ConversationUserService {
	@Autowired
	ConversationUserDao ConversationUserDao;
	
	@Autowired
	ConversationService ConversationService;
	
	@Autowired
	UserService UserService;
	
	@Override
	public JSONObject getJSON(ConversationUser model) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConversationUser getModel(JSONObject object) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GenericDao<ConversationUser, Integer> getDao() {
		return ConversationUserDao;
	}

	@Override
	public void AddUserToConversation(Conversation conversation, User user) {
		ConversationUser conversationuser = new ConversationUser();
		conversationuser.setConversation(conversation);
		conversationuser.setUser(user);
		ConversationUserDao.create(conversationuser);
	}

	@Override
	public void AddUsersToConversation(Conversation conversation, List<User> users) {
		for(int i=0;i<users.size();i++){
			AddUserToConversation(conversation,users.get(i));
		}
	}

	@Override
	public JSONArray getConversationUsers(int idconversation) throws JSONException{
		JSONArray array = new JSONArray();
		Conversation model = ConversationService.find(idconversation);
		List<ConversationUser> list = (List<ConversationUser>) model.getConversationUsers();
		for(int i=0;i<list.size();i++){
			array.put(UserService.getJSON(list.get(i).getUser()));
		}
		return array;
	}
}
