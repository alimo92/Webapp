package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.FollowerDao;
import org.ws.entities.Follower;
import org.ws.service.FollowerService;
import org.ws.service.UserService;

@Service
public class FollowerServiceImpl  extends GenericServiceImpl<Follower, Integer> implements FollowerService{
	@Autowired
	FollowerDao FollowerDao;
	
	@Autowired
	UserService UserService;
		
	@Override
	protected GenericDao<Follower, Integer> getDao() {
		return FollowerDao;
	}

	@Override
	public JSONObject getJSON(Follower model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("Followed", model.getFollowed().getIdUser());
		object.put("User", model.getUser().getIdUser());
		object.put("DateCreated", model.getDateCreated());
		object.put("IdFollower", model.getIdFollower());
		return object;
	}

	@Override
	public Follower getModel(JSONObject object) throws JSONException {
		Follower model = new Follower();
		model.setFollowed(UserService.find(object.getInt("Followed")));
		model.setUser(UserService.find(object.getInt("User")));
		return model;
	}

	@Override
	public JSONObject Follow(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(findFollower(object.getInt("User"),object.getInt("Followed"))==null){
			FollowerDao.create(getModel(object));
			return new JSONObject().put("Message", "User Followed");
		}else{
			return new JSONObject().put("Message", "User Already Followed");
		}
	}

	@Override
	public JSONObject UnFollow(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		Follower model = findFollower(object.getInt("User"),object.getInt("Followed"));
		if(model == null){
			return new JSONObject().put("Message", "User Already Unfollowed");
		}else{
			FollowerDao.remove(model);
			return new JSONObject().put("Message", "User Unfollowed");
		}
	}

	@Override
	public Follower findFollower(int iduser, int idfollower) {
		List<Follower> list = FollowerDao.findWithNamedQuery("Follower.findByUserAndFollowed",
				by("User",iduser).and("Followed", idfollower).parameters());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

}
