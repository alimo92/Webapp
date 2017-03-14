package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.ConversationDao;
import org.ws.entities.Conversation;
import org.ws.entities.ConversationUser;
import org.ws.entities.User;
import org.ws.service.ConversationService;
import org.ws.service.ConversationUserService;
import org.ws.service.UserService;
@Service
public class ConversationServiceImpl extends GenericServiceImpl<Conversation, Integer> implements ConversationService{
	
	@Autowired
	ConversationDao ConversationDao;
	
	@Autowired
	ConversationUserService ConversationUserService;
	
	@Autowired 
	UserService UserService;
	
	@Override
	public JSONObject getJSON(Conversation model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdConversation", model.getIdConversation());
		object.put("DateCreated", model.getDateCreated());
		object.put("NameConversation", model.getNameConversation());
		object.put("Users", ConversationUserService.getConversationUsers(model.getIdConversation()));
		return object;
	}

	@Override
	public Conversation getModel(JSONObject object) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GenericDao<Conversation, Integer> getDao() {
		return ConversationDao;
	}

	@Override
	public Conversation GetConversationOfUsers(List<User> users) {
		Conversation conversation = findConversationByUsers(users);
		if(conversation!=null){
			return conversation;
		}else{
			return CreateConversationOfUsers(users);
		}
	}

	@Override
	public Conversation CreateConversationOfUsers(List<User> users) {
		Conversation conversation = new Conversation();
		String name ="-";
		for(int i=0;i<users.size();i++){
			name =name+users.get(i).getFirstNameUser()+users.get(i).getIdUser()+"-";
		}
		conversation.setNameConversation(name);
		ConversationDao.create(conversation);
		ConversationUserService.AddUsersToConversation(findConversationByName(name), users);
		return findConversationByName(name);
	}

	@Override
	public Conversation findConversationByName(String Name) {
		List<Conversation> list = ConversationDao.findWithNamedQuery("Conversation.findByNameConversation", by("NameConversation",Name).parameters());
		return list.get(0);
	}

	@Override
	public Conversation findConversationByUsers(List<User> users) {
		List<Conversation> listconversation = GetAllConversationsOfUser(users.get(0));
		int Count =0;
		int result=-1;
		for(int i=0;i<listconversation.size();i++){
			List<ConversationUser> listconversationuser = (List<ConversationUser>) listconversation.get(i).getConversationUsers();
			if(listconversationuser.size()==users.size()){
				for(int j=0;j<listconversationuser.size();j++){
					for(int k=0;k<users.size();k++){
						if(listconversationuser.get(j).getUser().getIdUser()==users.get(k).getIdUser()){
							Count++;
						}
					}
					
				}
				if(Count==users.size()){
					result=i;
					break;
				}else{
					Count=0;
				}
			}
		}
		if(result==-1){
			return null;
		}else{
			return listconversation.get(result);
		}
	}
	

	@Override
	public List<Conversation> GetAllConversationsOfUser(User user) {
		return ConversationDao.findWithNamedQuery("Conversation.findByfUser", by("IdUser",user.getIdUser()).parameters());
	}

	@Override
	public List<Conversation> GetAllConversationsOfUser(int iduser) {
		User user= UserService.find(iduser);
		return GetAllConversationsOfUser(user);
	}

	@Override
	public JSONArray GetConversationsOfUser(int iduser) throws JSONException{
		List<Conversation> list = GetAllConversationsOfUser(iduser);
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}
}
