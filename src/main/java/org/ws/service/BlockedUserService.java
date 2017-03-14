package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.BlockedUser;

public interface BlockedUserService extends GenericService<BlockedUser, Integer>{
	public JSONObject BlockUser(String json) throws JSONException;
	public JSONObject UnBlockUser(String json) throws JSONException;
	public BlockedUser findBlockedUser(int iduser,int idblocked);
	public JSONArray GetAllBlockedUsers() throws JSONException;
	

}
