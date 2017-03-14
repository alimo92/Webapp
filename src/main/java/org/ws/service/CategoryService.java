package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Category;

public interface CategoryService extends GenericService<Category, Integer>{
	public JSONObject AddCategory(String json) throws JSONException;
	public JSONArray GetAllCategory() throws JSONException;
	public JSONObject GetCategoryById(int id) throws JSONException;

}
