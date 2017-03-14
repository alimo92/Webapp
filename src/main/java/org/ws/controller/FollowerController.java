package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ws.core.json.ResponseBuilder;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.service.FollowerService;

@Controller
@RestController
public class FollowerController {
	@Autowired
	private FollowerService F;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"Followed":IdFollower
	 * }
	 */
	@RequestMapping(value="/user/follow",method=RequestMethod.POST)
	@ResponseBody
	public String Follow(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Follow User",200), F.Follow(json)).toString();
	}
	
	/*
	 * JSON Form:
	 * {
	 * 		"User":IdUser,
	 * 		"Followed":IdFollower
	 * }
	 */
	@RequestMapping(value="/user/unfollow",method=RequestMethod.POST)
	@ResponseBody
	public String UnFollow(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Follow User",200), F.UnFollow(json)).toString();
	}

}
