package org.ws.core.json;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.impl.HeaderImpl;

public interface ResponseBuilder{
	public void AddHeaderToResponse();
	public void AddObjectToResponse(JSONObject jsonobject);
	public void AddListToResponse(JSONArray jsonarray);
	public void AddListToResponseSimple(JSONArray jsonarray);
	public JSONArray getFinalResponse(HeaderImpl header, JSONObject jsonobject);
	public JSONArray getFinalResponse(HeaderImpl header, JSONArray jsonarray,int mode);
}
