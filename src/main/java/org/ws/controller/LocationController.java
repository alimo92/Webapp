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
import org.ws.service.LocationService;

@Controller
@RestController
public class LocationController {
	
	@Autowired
	private LocationService L;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form:
	 * {
	 * 		"NameLocation":"name",
	 * 		"LongitudeLocation":"longitude",
	 * 		"LatitudeLocation":"latitude"
	 * }
	 */
	@RequestMapping(value="/location/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddNewLocation(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Add Location",200), L.AddNewLocation(json)).toString();
	}
	
	/*
	 * Get Location By id
	 *id=IdLocation
	 */
	@RequestMapping(value="/location/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetLocation(@PathVariable(value="id") int id ) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("Success","Get Location",200), L.getJSON(L.find(id))).toString();
	}

}
