package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.CategoryValue;

public interface CategoryValueService extends GenericService<CategoryValue, Integer>{
	public JSONObject AddCategoryValue(String json) throws JSONException;
	public JSONArray GetAllCategoryValue() throws JSONException;
	public JSONObject GetCategoryValueById(int id) throws JSONException;

}
