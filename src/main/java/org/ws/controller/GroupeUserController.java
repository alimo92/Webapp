package org.ws.controller;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ws.core.json.ResponseBuilder;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.service.GroupeUserService;

@Controller
@RestController
public class GroupeUserController {
	@Autowired
	private GroupeUserService GU;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@RequestMapping(value="/groupeuser/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddGroupe(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Add User to Group",200), 
				GU.AddUserToGroupe(json)).toString();
	}

}
