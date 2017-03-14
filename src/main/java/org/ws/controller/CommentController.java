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
import org.ws.service.CommentService;

@Controller
@RestController
public class CommentController {
	
	@Autowired
	private CommentService C;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"Post":IdPost,
	 * 		"ContentComment":""contentcomment",
	 * }
	 */
	@RequestMapping(value="/user/post/comment",method=RequestMethod.POST)
	@ResponseBody
	public String CommentPost(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Comment Post",200),C.CommentPost(json)).toString();
	}
	
	@RequestMapping(value="/post/{id}/comment/",method=RequestMethod.GET)
	@ResponseBody
	public String GetPostComments(@PathVariable ( value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Get Post Comment",200),C.GetPostComments(id),0).toString();
	}

}
