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
import org.ws.service.CategoryService;
import org.ws.service.NotificationService;

@Controller
@RestController
public class CategoryController {

	@Autowired
	private CategoryService C;
	
	@Autowired
	private ResponseBuilder ResponseBuilder;
	
	/*
	 * JSON Form:
	 * {
	 * 		"Category":"category"
	 * }
	 */
	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	@ResponseBody
	public String AddCategory(@RequestBody String json) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS","Add Category",200), C.AddCategory(json)).toString();
	}
	
	/*
	 * Get All Categories
	 */
	@RequestMapping(value="/category/",method=RequestMethod.GET)
	@ResponseBody
	public String GetAllCategory() throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Category Get ALl",200),C.GetAllCategory(), 0).toString();
	}
	
	/*
	 * Get Category By id
	 * id=IdCategory
	 */
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String GetCategoryById(@PathVariable(value="id") int id) throws JSONException{
		return ResponseBuilder.getFinalResponse(new HeaderImpl("SUCCESS" ,"Category Get By Id",200), 
				C.GetCategoryById(id)).toString();
	}
}
