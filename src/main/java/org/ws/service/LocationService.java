package org.ws.service;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Location;

public interface LocationService extends GenericService<Location, Integer>{

	JSONObject AddNewLocation(String json) throws JSONException;

}
