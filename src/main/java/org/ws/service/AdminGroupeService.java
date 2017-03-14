package org.ws.service;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.AdminGroupe;
import org.ws.entities.Groupe;
import org.ws.entities.User;

public interface AdminGroupeService extends GenericService<AdminGroupe, Integer>{
	public JSONObject AddAdminToGroup(String json)throws JSONException;
	public void AddAdminToGroup(User user,Groupe groupe) throws JSONException;
	public boolean CheckIfAdminIsAlreadyAdded(int iduser,int idgroupe);

}
