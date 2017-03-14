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
import org.ws.service.AdminGroupeService;

@Controller
@RestController
public class AdminGroupeController {
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@Autowired
	private AdminGroupeService A;
	
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddAdminToGroup(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Login",200), A.AddAdminToGroup(json)).toString();
	}

}
