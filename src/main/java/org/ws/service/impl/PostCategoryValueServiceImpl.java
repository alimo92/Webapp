package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.PostCategoryValueDao;
import org.ws.entities.PostCategoryValue;
import org.ws.service.CategoryValueService;
import org.ws.service.PostCategoryValueService;
import org.ws.service.PostService;
@Service
public class PostCategoryValueServiceImpl extends GenericServiceImpl<PostCategoryValue, Integer> implements PostCategoryValueService{
	
	@Autowired
	PostCategoryValueDao PostCategoryValueDao;
	
	@Autowired
	PostService PostService;
	
	@Autowired
	CategoryValueService CategoryValueService;
	
	@Override
	public JSONObject getJSON(PostCategoryValue model) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostCategoryValue getModel(JSONObject object) throws JSONException {
		PostCategoryValue model = new PostCategoryValue();
		model.setPost(PostService.find(object.getInt("Post")));
		model.setCategoryValue(CategoryValueService.find(object.getInt("CategoryValue")));
		return model;
	}

	@Override
	protected GenericDao<PostCategoryValue, Integer> getDao() {
		return PostCategoryValueDao;
	}

	@Override
	public void AddPostCategoryValue(int idpost, int idcategoryvalue) {
		PostCategoryValue model = new PostCategoryValue();
		model.setPost(PostService.find(idpost));
		model.setCategoryValue(CategoryValueService.find(idcategoryvalue));
		PostCategoryValueDao.create(model);
	}

	@Override
	public JSONArray GetCategoryValuesOfPost(int idpost) throws JSONException {
		List<PostCategoryValue> list = (List<PostCategoryValue>) PostService.find(idpost).getPostCategoryValues();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(new JSONObject().put("CategoryValue", list.get(i).getCategoryValue().getIdCategoryValue()).put("Category", list.get(i).getCategoryValue().getCategory().getIdCategory()));
		}
		return array;
	}

}
