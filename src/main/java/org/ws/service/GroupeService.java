package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Groupe;
import org.ws.entities.User;

public interface GroupeService extends GenericService<Groupe, Integer>{
	public JSONObject AddGroupe(String json) throws JSONException;
	public JSONArray GetAllGroupe() throws JSONException;
	public JSONObject GetGroupeById(int id) throws JSONException;
}
