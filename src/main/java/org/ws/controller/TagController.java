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
import org.ws.service.TagService;

@Controller
@RestController
public class TagController {
	
	@Autowired
	private TagService T;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"Post":IdPost,
	 * 		"Tagged":IdTagged
	 * }
	 */
	@RequestMapping(value="/user/tag",method=RequestMethod.POST)
	@ResponseBody
	public String TagUser(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Tag User",200), T.TagUser(json)).toString();
	}
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"Post":IdPost,
	 * 		"Tagged":IdTagged
	 * }
	 */
	@RequestMapping(value="/user/untag",method=RequestMethod.POST)
	@ResponseBody
	public String UnTagUser(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Tag User",200), T.UnTagUser(json)).toString();
	}
	
	/*
	 * Get Post Tags
	 * id=IdPost
	 */
	@RequestMapping(value="/post/{id}/tag/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllTagsOfPost(@PathVariable ( value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Get All Tags of Post",200), T.getAllTagsOfPost(id),0).toString();
	}

}
