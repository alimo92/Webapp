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
import org.ws.service.NotificationService;

@Controller
@RestController
public class NotificationController {

	@Autowired
	private NotificationService N;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	@RequestMapping(value="/notification/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddNotification(@RequestBody String json) throws JSONException{
		N.AddNotification(json);
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Notification Added",200), 
					new JSONObject().put("Message", "Notification Added Successfully")).toString();

	}
	
	@RequestMapping(value="/notification/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllNotification() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Notification Get All",200), N.GetAllNotification(), 0).toString();
	}
	
	
	@RequestMapping(value="/notification/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetNotificationById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Notification Get By Id",200), 
				N.GetNotificationById(id)).toString();
	}
}
