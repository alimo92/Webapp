package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
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
import org.ws.service.GroupeService;

@Controller
@RestController
public class GroupeController {

	@Autowired
	private GroupeService G;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@RequestMapping(value="/groupe/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddGroupe(@RequestBody String json) throws JSONException{
		
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Groupe Added",200), 
				G.AddGroupe(json)).toString();
	}
	
	@RequestMapping(value="/groupe/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllGroupe() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Groupe Get All",200),G.GetAllGroupe(), 0).toString();
	}
	
	
	@RequestMapping(value="/groupe/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetGroupeById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Groupe Get By Id",200), 
				G.GetGroupeById(id)).toString();
	}
	
	
}
