package org.ws.service;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Follower;

public interface FollowerService extends GenericService<Follower, Integer>{

	public JSONObject Follow(String json) throws JSONException;
	public JSONObject UnFollow(String json) throws JSONException;
	public Follower findFollower(int iduser,int idfollower);

}
