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
import org.ws.dao.GroupeDao;
import org.ws.entities.Groupe;
import org.ws.entities.User;
import org.ws.service.AdminGroupeService;
import org.ws.service.GroupeService;
import org.ws.service.GroupeUserService;
import org.ws.service.UserService;

@Service
public class GroupeServiceImpl  extends GenericServiceImpl<Groupe, Integer> implements GroupeService{
	@Autowired
	GroupeDao GroupeDao;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	GroupeUserService GroupeUserService;
	
	@Autowired
	AdminGroupeService AdminGroupeService;
	
	@Override
	protected GenericDao<Groupe, Integer> getDao() {
		return GroupeDao;
	}

	@Override
	public JSONObject getJSON(Groupe model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdGroup", model.getIdGroup());
		object.put("CreatorGroup", model.getCreatorGroup());
		object.put("NameGroup", model.getNameGroup());
		object.put("DateCreated", model.getDateCreated());
		return object;
	}

	@Override
	public Groupe getModel(JSONObject object) throws JSONException {
		Groupe model = new Groupe();
		model.setCreatorGroup(object.getInt("CreatorGroup"));
		model.setNameGroup(object.getString("NameGroup"));
		return model;
	}

	@Override
	public JSONObject AddGroupe(String json) throws JSONException {
		JSONObject j = new JSONObject(json);
		GroupeDao.create(getModel(j));
		List<Groupe> list = GroupeDao.findWithNamedQuery("Groupe.findCreatedByUser", by("CreatorGroup",j.get("CreatorGroup")).parameters());
		User user = UserService.find(j.getInt("CreatorGroup"));
		GroupeUserService.addUserToGroupe(user, list.get(0));
		AdminGroupeService.AddAdminToGroup(user, list.get(0));
		return new JSONObject().put("Message", "Group added , Creator Added to the group Created, Creator is Admin in the group");
	}

	@Override
	public JSONArray GetAllGroupe() throws JSONException {
		List<Groupe> list = GroupeDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetGroupeById(int id) throws JSONException {
		Groupe model = GroupeDao.find(id);
		return getJSON(model);
	}
}
