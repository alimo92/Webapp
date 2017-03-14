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
import org.ws.service.NotificationTypeService;

@Controller
@RestController
public class NotificationTypeController {

	@Autowired
	private NotificationTypeService NT;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	
	
	@RequestMapping(value="/notificationtype/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddNotificationType(@RequestBody String json) throws JSONException{

		NT.AddNotificationType(json);
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","NotificationType Added",200), 
						new JSONObject().put("Message", "NotificationType Added Successfully")).toString();
	}
	
	
	@RequestMapping(value="/notificationtype/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllNotificationType() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"NotificationType Get All",200), NT.GetAllNotificationType(), 0).toString();
	}
	
	
	
	@RequestMapping(value="/notificationtype/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetNotificationTypeById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"NotificationType Get By Id",200), 
				NT.getJSON(NT.find(id))).toString();
	}
}
