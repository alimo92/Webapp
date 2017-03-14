package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.opensaml.xml.signature.G;
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
import org.ws.service.GroupeMessageService;

@Controller
@RestController
public class GroupeMessageController {

	@Autowired
	private GroupeMessageService GM; 
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@RequestMapping(value="/groupemessage/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddGroupeMessage(@RequestBody String json) throws JSONException{
		
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","GroupeMessage Added",200), 
				GM.AddGroupeMessage(json)).toString();
	}
	
	@RequestMapping(value="/groupemessage/groupe/{idgroupe}",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllGroupeMessage(@PathVariable(value="idgroupe") int idgroupe) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"GroupeMessage in a Groupe Get All",200),GM.GetAllGroupeMessage(idgroupe), 0).toString();
	}
	
	
	@RequestMapping(value="/groupemessage/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetGroupeMessageById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"GroupeMessage Get By Id",200), 
				GM.GetGroupeMessageById(id)).toString();
	}
}
