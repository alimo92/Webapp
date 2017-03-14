package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.PostDao;
import org.ws.entities.Post;
import org.ws.service.CommentService;
import org.ws.service.LocationService;
import org.ws.service.PostCategoryValueService;
import org.ws.service.PostService;
import org.ws.service.RatingService;
import org.ws.service.TagService;
import org.ws.service.UserService;
@Service
public class PostServiceImpli  extends GenericServiceImpl<Post, Integer> implements PostService{
	@Autowired
	PostDao PostDao;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	LocationService LocationService;
	
	@Autowired
	PostCategoryValueService PostCategoryValueService;
	
	@Autowired
	TagService TagService;
	
	@Autowired
	RatingService RatingService;
	
	@Autowired
	CommentService CommentService;
		
	@Override
	protected GenericDao<Post, Integer> getDao() {
		return PostDao;
	}

	@Override
	public JSONObject getJSON(Post model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("CategoryValues", PostCategoryValueService.GetCategoryValuesOfPost(model.getIdPost()));
		object.put("IdPost", model.getIdPost());
		object.put("TitlePost", model.getTitlePost());
		object.put("DateCreated", model.getDateCreated());
		object.put("Location", model.getLocationPost().getIdLocation());
		object.put("User", model.getUser().getIdUser());
		object.put("DescriptionPost", model.getDescriptionPost());
		object.put("ImagePost", model.getImagePost());
		object.put("Tags",TagService.getAllTagsOfPost(model.getIdPost()));
		object.put("Ratings",RatingService.GetPostRatings(model.getIdPost()));
		object.put("Comments", CommentService.GetPostComments(model.getIdPost()));
		object.put("AverageRating", RatingService.GetAverageRating(model.getIdPost()));
		return object;
	}
	
	@Override
	public Post getModel(JSONObject object) throws JSONException {
		Post model = new Post();
		model.setTitlePost(object.getString("TitlePost"));
		model.setLocationPost(LocationService.find(object.getInt("Location")));
		model.setDescriptionPost(object.getString("DescriptionPost"));
		model.setUser(UserService.find(object.getInt("User")));
		model.setImagePost(object.getString("ImagePost"));
		return model;
	}

	@Override
	public JSONObject AddPost(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		PostDao.create(getModel(object));
		Post post = findLastPostOfUser(object.getInt("User"));
		
		JSONArray array = object.getJSONArray("CategoryValues");
		JSONArray arraytags = object.getJSONArray("Tags");
		
		for(int i=0;i<array.length();i++){
			JSONObject temp = array.getJSONObject(i);
			PostCategoryValueService.AddPostCategoryValue(post.getIdPost(), temp.getInt("CategoryValue"));
		}
		
		for(int i=0;i<arraytags.length();i++){
			JSONObject temp2 = arraytags.getJSONObject(i);
			TagService.AddTag(post.getIdPost(), object.getInt("User"), temp2.getInt("Tagged"));
		}
		
		return new JSONObject().put("Message", "Post Added"); 
	}

	@Override
	public Post findLastPostOfUser(int iduser) {
		List<Post> list = PostDao.findWithNamedQuery("Post.findLastPostOfUser", by("IdUser",iduser).parameters());
		return list.get(0);
	}

	@Override
	public JSONArray GetAllPosts() throws JSONException {
		List<Post> list = PostDao.findAll();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}
}
