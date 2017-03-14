package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.CategoryDao;
import org.ws.entities.Category;
import org.ws.service.CategoryService;
@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, Integer> implements CategoryService {
	@Autowired
	CategoryDao CategoryDao;
		
	@Override
	protected GenericDao<Category, Integer> getDao() {
		return CategoryDao;
	}

	@Override
	public JSONObject getJSON(Category model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdCategory", model.getIdCategory());
		object.put("DateCreated", model.getDateCreated());
		object.put("Category", model.getCategory());
		return object;
	}

	@Override
	public Category getModel(JSONObject object) throws JSONException {
		Category model = new Category();
		model.setCategory(object.getString("Category"));
		return model;
	}

	@Override
	public JSONObject AddCategory(String json) throws JSONException {
		JSONObject j = new JSONObject(json);
		CategoryDao.create(getModel(j));
		return new JSONObject().put("Message", "Category Added");
	}

	@Override
	public JSONArray GetAllCategory() throws JSONException {
		List<Category> list = CategoryDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject GetCategoryById(int id) throws JSONException {
		Category model = CategoryDao.find(id);
		return getJSON(model);
	}

}
