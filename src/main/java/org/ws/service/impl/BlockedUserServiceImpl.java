package org.ws.service.impl;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.BlockedUserDao;
import org.ws.entities.BlockedUser;
import org.ws.service.BlockedUserService;
import org.ws.service.UserService;
import static org.ws.core.search.QueryParameter.by;

@Service
public class BlockedUserServiceImpl extends GenericServiceImpl<BlockedUser, Integer> implements BlockedUserService{
	@Autowired
	BlockedUserDao BlockedUserDao;
	
	@Autowired
	UserService UserService;
		
	@Override
	protected GenericDao<BlockedUser, Integer> getDao() {
		return BlockedUserDao;
	}

	@Override
	public JSONObject getJSON(BlockedUser model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("IdBlockedUser",model.getIdBlockedUser());
		object.put("User", model.getUser().getIdUser());
		object.put("ReasonBlockeduser", model.getReasonBlockedUser());
		object.put("DateCreated", model.getDateCreated());
		object.put("BlockedUser", model.getBlockedUser().getIdUser());
		return object;
	}

	@Override
	public BlockedUser getModel(JSONObject object) throws JSONException {
		BlockedUser model = new BlockedUser();
		model.setBlockedUser(UserService.find(object.getInt("BlockedUser")));
		model.setUser(UserService.find(object.getInt("User")));
		model.setReasonBlockedUser(object.getString("ReasonBlockedUser"));
		return model;
	}

	@Override
	public JSONObject BlockUser(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(findBlockedUser(object.getInt("User"), object.getInt("BlockedUser"))==null){
			BlockedUserDao.create(getModel(object));
			return new JSONObject().put("Message", "User Blocked");
		}else{
			return new JSONObject().put("Message", "User Already Blocked");
		}
	}

	@Override
	public JSONArray GetAllBlockedUsers() throws JSONException {
		JSONArray array = new JSONArray();
		List<BlockedUser> list = BlockedUserDao.findAll();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONObject UnBlockUser(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		BlockedUser model = findBlockedUser(object.getInt("User"), object.getInt("BlockedUser"));
		if(model==null){
			return new JSONObject().put("Message", "User is Already UnBlocked");
		}else{
			BlockedUserDao.remove(model);
			return new JSONObject().put("Message", "User UnBlocked");
		}
	}

	@Override
	public BlockedUser findBlockedUser(int iduser, int idblocked) {
		List<BlockedUser> list = BlockedUserDao.findWithNamedQuery("BlockedUser.findByUserAndBlocked", by("IdUser",iduser).and("IdBlocked",idblocked).parameters());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
}
