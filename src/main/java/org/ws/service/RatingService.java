package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Rating;

public interface RatingService extends GenericService<Rating, Integer>{

	public JSONObject RatePost(String json) throws JSONException;

	public JSONArray GetPostRatings(int id) throws JSONException;

	public float GetAverageRating(int id) throws JSONException;

	public JSONObject GetAverageRatingJSON(int id) throws JSONException;
	
	public boolean CheckRatingAvailable(int iduser,int idpost);
	
	public Rating findRating(int iduser,int idpost);

}
