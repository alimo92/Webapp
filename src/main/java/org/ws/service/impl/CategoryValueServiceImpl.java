package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.CategoryValueDao;
import org.ws.entities.CategoryValue;
import org.ws.service.CategoryService;
import org.ws.service.CategoryValueService;
import org.ws.service.PostService;

@Service
public class CategoryValueServiceImpl extends GenericServiceImpl<CategoryValue, Integer> implements CategoryValueService{
	@Autowired
	CategoryValueDao CategoryValueDao;
	
	@Autowired
	CategoryService CategoryService;
	
	@Autowired
	PostService PostService;
	
	@Override
	protected GenericDao<CategoryValue, Integer> getDao() {
		return CategoryValueDao;
	}

	@Override
	public JSONObject getJSON(CategoryValue model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdCategoryValue", model.getIdCategoryValue());
		object.put("CategoryValue", model.getCategoryValue());
		object.put("Category", model.getCategory().getIdCategory());
		object.put("DateCreated", model.getDateCreated());
		return object;
	}

	@Override
	public CategoryValue getModel(JSONObject object) throws JSONException {
		CategoryValue model = new CategoryValue();
		model.setCategoryValue(object.getString("CategoryValue"));
		model.setCategory(CategoryService.find(object.getInt("Category")));
		return model;		
	}

	@Override
	public JSONObject AddCategoryValue(String json) throws JSONException {
		JSONObject j = new JSONObject(json);
		CategoryValueDao.create(getModel(j));
		return new JSONObject().put("Message", "CategoryValue Added");
	}

	@Override
	public JSONArray GetAllCategoryValue() throws JSONException {
		List<CategoryValue> list = CategoryValueDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetCategoryValueById(int id) throws JSONException {
		CategoryValue model = CategoryValueDao.find(id);
		return getJSON(model);
	}
}
