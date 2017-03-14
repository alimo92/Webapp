package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ws.core.json.ResponseBuilder;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.service.RatingService;

@Controller
@RestController
public class RatingController {
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@Autowired
	private RatingService R;
	
	
	/*
	 * JSON Form :
	 * {
	 * 		"User":IdUser,
	 * 		"Post":IdPost,
	 * 		"RatingValue":ratingvalue 
	 * }
	 */
	@RequestMapping(value="/user/rate",method=RequestMethod.POST)
	@ResponseBody
	public String RatePost(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Rate Post",200), R.RatePost(json)).toString();
	}
	
	/*
	 * Get Post Ratings
	 * id=IdPost
	 */
	@RequestMapping(value="/post/{id}/rating/",method=RequestMethod.GET)
	@ResponseBody
	public String GetPostRating(@PathVariable ( value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Get Post Ratings",200),R.GetPostRatings(id),0).toString();
	}
	
	
	/*
	 * Get Average Ratings of a Post
	 * id=IdPost
	 */
	@RequestMapping(value="/post/{id}/rating/average/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAverageRating(@PathVariable ( value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Get Post AverageRating",200),R.GetAverageRatingJSON(id)).toString();
	}

}
