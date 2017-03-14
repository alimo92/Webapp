package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.ws.core.service.GenericService;
import org.ws.entities.PostCategoryValue;

public interface PostCategoryValueService extends GenericService<PostCategoryValue, Integer>{
	public void AddPostCategoryValue(int idpost, int idcategoryvalue);
	public JSONArray GetCategoryValuesOfPost(int idpost) throws JSONException;

}
