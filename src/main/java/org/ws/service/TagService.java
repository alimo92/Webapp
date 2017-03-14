package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Post;
import org.ws.entities.Tag;

public interface TagService extends GenericService<Tag, Integer>{
	public JSONObject TagUser(String json) throws JSONException;
	public JSONObject UnTagUser(String json) throws JSONException;
	public void AddTag(int idpost, int iduser, int idtagged);
	public Tag findTag(int iduser,int idtagged,int idpost);
	public JSONArray getAllTagsOfPost(int id) throws JSONException;
	public JSONArray getTagsOfPost(Post post);
}
