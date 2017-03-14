package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ws.core.json.ResponseBuilder;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.service.ConversationService;

@Controller
@RestController
public class ConversationController {
	
	
	@Autowired
	ConversationService C;
	
	@Autowired
	ResponseBuilder ResponseBuilder;
	
	/*
	 * id=IdUser
	 */
	@RequestMapping(value="/user/{id}/conversation/",method=RequestMethod.GET)
	@ResponseBody
	public String GetUserConversations(@PathVariable ( value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Conversations of User",200), C.GetConversationsOfUser(id),0).toString();
	}

}
