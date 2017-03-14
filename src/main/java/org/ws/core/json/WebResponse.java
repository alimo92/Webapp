package org.ws.core.json;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.impl.HeaderImpl;

public interface WebResponse {
	void AddItemToList(JSONObject object);
	void AddItemToList(JSONArray array) throws JSONException;
	void AddHeaderToList() throws JSONException;
	String getResponse(HeaderImpl header , JSONObject object) throws JSONException;
	String getResponse(HeaderImpl header , JSONArray array) throws JSONException;

}
