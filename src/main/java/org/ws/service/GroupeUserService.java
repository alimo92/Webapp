package org.ws.service;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Groupe;
import org.ws.entities.GroupeUser;
import org.ws.entities.User;

public interface GroupeUserService  extends GenericService<GroupeUser, Integer>{
	public JSONObject AddUserToGroupe(String json)throws JSONException;
	public void addUserToGroupe(User user,Groupe groupe) throws JSONException;
	public boolean CheckIfUserAlreadyAdded(int iduser,int idgroup);
}
