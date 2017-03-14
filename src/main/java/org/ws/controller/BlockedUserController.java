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
import org.ws.service.BlockedUserService;

@Controller
@RestController
public class BlockedUserController {
	
	@Autowired
	private BlockedUserService B;
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form :
	 * {
	 * 		"User":IdUser,
	 * 		"BlockedUser":IdBlocked
	 * 		"ReasonBlockedUser":"reasons ..."
	 * }
	 */
	@RequestMapping(value="/user/block",method=RequestMethod.POST)
	@ResponseBody
	public String BlockUser(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Block User",200), B.BlockUser(json)).toString();
	}
	
	/*
	 * JSON Form :
	 * {
	 * 		"User":User,
	 * 		"BlockedUser":IdBlocked
	 * }
	 */
	@RequestMapping(value="/user/unblock",method=RequestMethod.POST)
	@ResponseBody
	public String UnBlockUser(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Block User",200), B.UnBlockUser(json)).toString();
	}
	
	/*
	 * Get All Blocked Users
	 */
	@RequestMapping(value="/blockeduser/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllBlockedUsers() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","GetAllBlockedUsers ",200),B.GetAllBlockedUsers(),0).toString();
	}

}
