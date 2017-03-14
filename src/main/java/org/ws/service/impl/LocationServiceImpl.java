package org.ws.service.impl;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.LocationDao;
import org.ws.entities.Location;
import org.ws.service.LocationService;

@Service
public class LocationServiceImpl  extends GenericServiceImpl<Location, Integer> implements LocationService{
	@Autowired
	LocationDao LocationDao;
		
	@Override
	protected GenericDao<Location, Integer> getDao() {
		return LocationDao;
	}

	@Override
	public JSONObject getJSON(Location model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdLocation", model.getIdLocation());
		object.put("DateCreated", model.getDateCreated());
		object.put("LatitudeLocation", model.getLatitudeLocation());
		object.put("LongitudeLocation", model.getLongitudeLocation());
		object.put("NameLocation", model.getNameLocation());
		return object;
	}

	@Override
	public Location getModel(JSONObject object) throws JSONException {
		Location model = new Location();
		model.setNameLocation(object.getString("NameLocation"));
		model.setLatitudeLocation(object.getDouble("LatitudeLocation"));
		model.setLongitudeLocation(object.getDouble("LongitudeLocation"));
		return model;
	}

	@Override
	public JSONObject AddNewLocation(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		LocationDao.create(getModel(object));
		return new JSONObject().put("Message", "New Location Added"); 
		
	}
}
