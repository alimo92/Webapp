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
import org.ws.service.MessageService;

@Controller
@RestController
public class MessageController {
	
	@Autowired
	private MessageService M;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	
	/*
	 * JSON Form :
	 * {
	 * 		"User": IdUser,
	 * 		"ContentMessage": "Content of the Message",
	 * 		"MessageReceivers":
	 * 		[
	 * 			{"IdReceiver" : Id1},
	 * 			{"IdReceiver" : Id2},
	 * 			...		
	 * 		]
	 * }
	 */
	@RequestMapping(value="/conversation/message/add",method=RequestMethod.POST)
	@ResponseBody
	public String SendMessage(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Send Message",200), M.SendMessage(json)).toString();
	}
	
	/*
	 * Get Conversation Messages
	 * i= IdConversation
	 */
	@RequestMapping(value="/conversation/{i}/message/",method=RequestMethod.GET)
	@ResponseBody
	public String GetConversationMessages(@PathVariable(value="i") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Get Conversation Messages",200), M.GetMessagesOfConversation(id),0).toString();
	}
}
