package org.ws.service;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.User;

public interface UserService extends GenericService<User, Integer>{
	public List<User> findUserByEmail(String EmailUser);
	public Boolean UserCheckAvailable(String EmailUser);
	public List<User> findUserByEmailAndPassword(String EmailUser,String PasswordUser);
	public String Register(String json) throws JSONException;
	public String Login(String json) throws JSONException;

}
