package org.ws.core.json;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;

public interface Header {
	public JSONObject getJsonHeader() throws JSONException;
}
