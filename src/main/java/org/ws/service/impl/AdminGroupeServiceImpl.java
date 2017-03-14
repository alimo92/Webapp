package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.AdminGroupeDao;
import org.ws.entities.AdminGroupe;
import org.ws.entities.Groupe;
import org.ws.entities.User;
import org.ws.service.AdminGroupeService;
import org.ws.service.GroupeService;
import org.ws.service.GroupeUserService;
import org.ws.service.UserService;
@Service
public class AdminGroupeServiceImpl extends GenericServiceImpl<AdminGroupe, Integer> implements AdminGroupeService{
	@Autowired
	AdminGroupeDao AdminGroupeDao;
	
	@Autowired
	GroupeService GroupeService;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	GroupeUserService GroupeUserService;
	
	@Override
	protected GenericDao<AdminGroupe, Integer> getDao() {
		return AdminGroupeDao;
	}

	@Override
	public JSONObject getJSON(AdminGroupe model)throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdAdminGroupe", model.getIdAdminGroup());
		object.put("DateCreated", model.getDateCreated());
		object.put("Groupe", model.getGroupe().getIdGroup());
		object.put("AdminUser", model.getAdminUser().getIdUser());
		return object;
	}

	@Override
	public AdminGroupe getModel(JSONObject object) throws JSONException {
		AdminGroupe admingroupe = new AdminGroupe();
		admingroupe.setGroupe(GroupeService.find(object.getInt("Groupe")));
		admingroupe.setAdminUser(UserService.find(object.getInt("AdminUser")));
		return admingroupe;
	}

	@Override
	public JSONObject AddAdminToGroup(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(GroupeUserService.CheckIfUserAlreadyAdded(object.getInt("AdminUser"), object.getInt("Groupe"))){
			if(!CheckIfAdminIsAlreadyAdded(object.getInt("AdminUser"), object.getInt("Groupe"))){
				AdminGroupeDao.create(getModel(object));
				return new JSONObject().put("Message", "new Admin Added in the group");				
			}else{
				return new JSONObject().put("Message", "User is Already an Admin in this group");
			}

		}else{
			return new JSONObject().put("Message", "User not part of the group");
		}
	}

	@Override
	public void AddAdminToGroup(User user, Groupe groupe) throws JSONException {
		AdminGroupe model = new AdminGroupe();
		model.setGroupe(groupe);
		model.setAdminUser(user);
		AdminGroupeDao.create(model);
	}

	@Override
	public boolean CheckIfAdminIsAlreadyAdded(int iduser, int idgroupe) {
		List<AdminGroupe> list = AdminGroupeDao.findWithNamedQuery("AdminGroupe.findByAdminUserGroupe", by("IdUser",iduser).and("IdGroup", idgroupe).parameters());
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}

}
