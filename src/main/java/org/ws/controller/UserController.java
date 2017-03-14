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
import org.ws.service.UserService;

@Controller
@RestController
public class UserController {

	@Autowired
	private UserService U; 
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	
	/*
	 * JSON Form:
	 * {
	 * 		"FirstNameUser":"firstname",
	 * 		"LastNameUser":"lastname",
	 * 		"PasswordUser":"password",
	 * 		"EmailUser":"email"
	 * }
	 */
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public String Register(@RequestBody String json) throws JSONException{
		//return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Register",200), U.Register(json)).toString();
		return U.Register(json);
	}
	
	/*
	 * JSON Form:
	 * {
	 * 		"EmailUser":"email",
	 * 		"PasswordUser":"password"
	 * }
	 */
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public String Login(@RequestBody String json) throws JSONException{
		//return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Login",200), U.Login(json)).toString();
		return U.Login(json);
	}
	
}
