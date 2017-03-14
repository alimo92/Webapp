package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.CommentDao;
import org.ws.entities.Comment;
import org.ws.service.CommentService;
import org.ws.service.PostService;
import org.ws.service.UserService;
@Service
public class CommentServiceImpl extends GenericServiceImpl<Comment, Integer> implements CommentService{
	@Autowired
	CommentDao CommentDao;
	
	@Autowired
	PostService PostService;
	
	@Autowired
	UserService UserService; 
		
	@Override
	protected GenericDao<Comment, Integer> getDao() {
		return CommentDao;
	}

	@Override
	public JSONObject getJSON(Comment model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdComment", model.getIdComment());
		object.put("User", model.getUser().getIdUser());
		object.put("Post", model.getPost().getIdPost());
		object.put("ContentComment", model.getContentComment());
		object.put("DateCreated",model.getDateCreated());
		return object;
	}

	@Override
	public Comment getModel(JSONObject object) throws JSONException {
		Comment model = new Comment();
		model.setUser(UserService.find(object.getInt("User")));
		model.setPost(PostService.find(object.getInt("Post")));
		model.setContentComment(object.getString("ContentComment"));
		return model;
	}

	@Override
	public JSONObject CommentPost(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		CommentDao.create(getModel(object));
		return new JSONObject().put("Message", "Post was Commented");
	}

	@Override
	public JSONArray GetPostComments(int id) throws JSONException {
		List<Comment> list = (List<Comment>) PostService.find(id).getCommentsPost();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

}
