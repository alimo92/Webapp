package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.GroupeUserDao;
import org.ws.entities.Groupe;
import org.ws.entities.GroupeUser;
import org.ws.entities.User;
import org.ws.service.GroupeService;
import org.ws.service.GroupeUserService;
import org.ws.service.UserService;

@Service
public class GroupeUserServiceImpl extends GenericServiceImpl<GroupeUser, Integer> implements GroupeUserService{
	
	@Autowired
	GroupeUserDao GroupeUserDao;
	
	@Autowired
	GroupeService GroupeService;
	
	@Autowired
	UserService UserService;
	
	@Override
	public JSONObject getJSON(GroupeUser model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("DateCreated", model.getDateCreated());
		object.put("IdGroupeUser", model.getIdGroupeUser());
		object.put("Groupe", model.getGroupe().getIdGroup());
		object.put("User", model.getUser().getIdUser());
		return object;
	}

	@Override
	public GroupeUser getModel(JSONObject object) throws JSONException {
		GroupeUser model = new GroupeUser();
		model.setGroupe(GroupeService.find(object.getInt("Groupe")));
		model.setUser(UserService.find(object.getInt("User")));
		return model;
	}

	@Override
	protected GenericDao<GroupeUser, Integer> getDao() {
		return GroupeUserDao;
	}

	@Override
	public JSONObject AddUserToGroupe(String json) throws JSONException{
		JSONObject object = new JSONObject(json);
		if(!CheckIfUserAlreadyAdded(object.getInt("User"), object.getInt("Groupe"))){
			GroupeUserDao.create(getModel(object));
			return  new JSONObject().put("Message", "User added to the Group Successfully");
		}else{
			return new JSONObject().put("Message","User Already in The group");
		}
	}

	@Override
	public boolean CheckIfUserAlreadyAdded(int iduser, int idgroup) {
		List<GroupeUser> list = GroupeUserDao.findWithNamedQuery("GroupeUser.findUserAdded", by("IdGroup",idgroup).and("IdUser", iduser).parameters());
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void addUserToGroupe(User user,Groupe groupe) throws JSONException {
		GroupeUser gu = new GroupeUser();
		gu.setGroupe(groupe);
		gu.setUser(user);
		GroupeUserDao.create(gu);
	}

}
