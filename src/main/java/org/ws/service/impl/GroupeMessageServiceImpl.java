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
import org.ws.dao.GroupeMessageDao;
import org.ws.entities.GroupeMessage;
import org.ws.service.GroupeMessageService;
import org.ws.service.GroupeService;
import org.ws.service.GroupeUserService;
import org.ws.service.UserService;
@Service
public class GroupeMessageServiceImpl  extends GenericServiceImpl<GroupeMessage, Integer> implements GroupeMessageService {
	@Autowired
	GroupeMessageDao GroupeMessageDao;
	
	@Autowired
	GroupeService GroupeService;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	GroupeUserService GroupeUserService;
		
	@Override
	protected GenericDao<GroupeMessage, Integer> getDao() {
		return GroupeMessageDao;
	}

	@Override
	public JSONObject getJSON(GroupeMessage model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdGroupMessage", model.getIdGroupMessage());
		object.put("ContentGroupMessage", model.getContentGroupMessage());
		object.put("DateCreated",model.getDateCreated());
		object.put("Groupe",model.getGroupe().getIdGroup());
		object.put("User", model.getUser().getIdUser());
		return object;
	}

	@Override
	public GroupeMessage getModel(JSONObject object) throws JSONException {
		GroupeMessage model = new GroupeMessage();
		model.setContentGroupMessage(object.getString("ContentGroupMessage"));
		model.setGroupe(GroupeService.find(object.getInt("Groupe")));
		model.setUser(UserService.find(object.getInt("User")));
		return model;
	}

	@Override
	public JSONObject AddGroupeMessage(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(GroupeUserService.CheckIfUserAlreadyAdded(object.getInt("User"), object.getInt("Groupe"))){
			GroupeMessageDao.create(getModel(object));
			return new JSONObject().put("Message", "GroupeMessage Added");
		}else{
			return new JSONObject().put("Message", "User do not have the right to write the message in this group");
		}
	}

	@Override
	public JSONArray GetAllGroupeMessage(int Groupe) throws JSONException {
		List<GroupeMessage> list = GroupeMessageDao.findWithNamedQuery("GroupeMessage.findByGroupe", by("Groupe",Groupe).parameters());
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetGroupeMessageById(int id) throws JSONException {
		GroupeMessage model = GroupeMessageDao.find(id);
		return getJSON(model);
	}
	
}
