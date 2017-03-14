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
import org.ws.service.CategoryValueService;

@Controller
@RestController
public class CategoryValueController {
	
	@Autowired
	private CategoryValueService CV;

	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form:
	 * {
	 * 		"CategoryValue":"categoryvalue",
	 * 		"Category":IdCategory
	 * }
	 */
	@RequestMapping(value="/categoryvalue/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddCategoryValue(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Add CategoryValue",200), 
				CV.AddCategoryValue(json)).toString();

	}
	
	/*
	 * Get All CategoryValues
	 */
	@RequestMapping(value="/categoryvalue/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllCategoryValue() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Get All CategoryValues",200),CV.GetAllCategoryValue(), 0).toString();
	}
	
	/*
	 * Get CategoryValue By id
	 */
	@RequestMapping(value="/categoryvalue/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetCategoryValueById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Get CategoryValue By Id ",200), 
				CV.GetCategoryValueById(id)).toString();
	}
}
