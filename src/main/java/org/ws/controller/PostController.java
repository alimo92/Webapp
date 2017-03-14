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
import org.ws.service.PostService;

@Controller
@RestController
public class PostController {
	
	@Autowired
	private PostService P;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"TitlePost":"title",
	 * 		"DescriptionPost":"description",
	 * 		"Location":IdLocation,
	 * 		"ImagePost":"urlimage",
	 * 		"CategoryValues":
	 * 		[
	 * 			{
	 * 				"CategoryValue": IdCategoryValue
	 * 			}
	 * 			{
	 * 				"CategoryValue": IdCategoryValue
	 * 			}
	 * 		],
	 * 		Tags:
	 * 		[
	 * 			{
	 * 				"Tagged":IdTagged,
	 * 			}
	 * 		]
	 * }
	 */
	@RequestMapping(value="/post/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddPost(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Add Post",200), P.AddPost(json)).toString();
	}
	
	/*
	 * Get All Post
	 */
	@RequestMapping(value="/post/",method=RequestMethod.GET)
	@ResponseBody
	public String getAllPosts() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Get All Posts",200), P.GetAllPosts(),0).toString();
	}
	
	/*
	 * Get All Post
	 */
	@RequestMapping(value="/post/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getAllPosts(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Get Post By Id",200), P.getJSON(P.find(id))).toString();
	}

}
