package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.RatingDao;
import org.ws.entities.Post;
import org.ws.entities.Rating;
import org.ws.entities.User;
import org.ws.service.PostService;
import org.ws.service.RatingService;
import org.ws.service.UserService;
import static org.ws.core.search.QueryParameter.by;;
@Service
public class RatingServiceImpl  extends GenericServiceImpl<Rating, Integer> implements RatingService{
	@Autowired
	RatingDao RatingDao;
	
	@Autowired
	PostService PostService;
	
	@Autowired
	UserService UserService;
		
	@Override
	protected GenericDao<Rating, Integer> getDao() {
		return RatingDao;
	}

	@Override
	public JSONObject getJSON(Rating model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdRating", model.getIdRating());
		object.put("DateCreated", model.getDateCreated());
		object.put("User", model.getUser().getIdUser());
		object.put("Post", model.getPostRating().getIdPost());
		object.put("RatingValue", model.getRatingValue());
		return object;
	}

	@Override
	public Rating getModel(JSONObject object) throws JSONException {
		Rating model = new Rating();
		model.setPostRating(PostService.find(object.getInt("Post")));
		model.setUser(UserService.find(object.getInt("User")));
		model.setRatingValue(object.getInt("RatingValue"));
		return model;
	}
	
	@Override
	public Rating findRating(int iduser, int idpost) {
		List<Rating> list = RatingDao.findWithNamedQuery("Rating.findByUserPost",by("IdUser",iduser).and("IdPost", idpost).parameters());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public boolean CheckRatingAvailable(int iduser, int idpost) {
		User user = UserService.find(iduser);
		Post post = PostService.find(idpost);
		
		if(findRating(iduser,idpost)==null){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public JSONObject RatePost(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(CheckRatingAvailable(object.getInt("User"), object.getInt("Post"))){
			RatingDao.create(getModel(object));
			return new JSONObject().put("Message","Post Rated by User");
		}else{
			return new JSONObject().put("Message", "User Already Rated this Post");
		}
	}

	@Override
	public JSONArray GetPostRatings(int id) throws JSONException {
		List<Rating> list = (List<Rating>) PostService.find(id).getRatingsPost();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public float GetAverageRating(int id) throws JSONException {
		float average=0;
		List<Rating> list = (List<Rating>) PostService.find(id).getRatingsPost();
		if(list.size()!=0){
			for(int i=0;i<list.size();i++){
				average+=list.get(i).getRatingValue();
			}
			average=average/list.size();
		}
		return average;
	}

	@Override
	public JSONObject GetAverageRatingJSON(int id) throws JSONException {
		float average = GetAverageRating(id);
		return new JSONObject().put("AverageRating", average);
	}




}
