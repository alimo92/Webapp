package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Post;

public interface PostService extends GenericService<Post, Integer>{

	public JSONObject AddPost(String json) throws JSONException;
	public Post findLastPostOfUser(int iduser);
	public JSONArray GetAllPosts() throws JSONException;
}
