package org.ws.test;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Temperature {

	
	@RequestMapping(value="/temperature/",method=RequestMethod.GET)
	@ResponseBody
	public String getTemperature() throws JSONException{
		
		JSONObject object = new JSONObject();
		
		object.put("ValueTemp","17");
		object.put("IdTemp","2");
		object.put("DateTemp", "17-03-1992");
		
		return object.toString();
	}
}
