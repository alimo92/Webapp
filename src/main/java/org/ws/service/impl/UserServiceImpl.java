package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.json.WebResponse;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.UserDao;
import org.ws.entities.User;
import org.ws.service.ConversationService;
import org.ws.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService{

	@Autowired
	UserDao UserDao;
	
	@Autowired
	ConversationService ConversationService;
	
	@Autowired
	WebResponse WebResponse;
		
	@Override
	protected GenericDao<User, Integer> getDao() {
		return UserDao;
	}

	@Override
	public List<User> findUserByEmail(String EmailUser) {
		List<User> u = UserDao.findWithNamedQuery("User.FindByEmail", by("EmailUser",EmailUser).parameters());
		return u;
	}

	@Override
	public Boolean UserCheckAvailable(String EmailUser) {
		if(findUserByEmail(EmailUser).size()==0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<User> findUserByEmailAndPassword(String EmailUser, String PasswordUser) {
		List<User> listuser = UserDao.findWithNamedQuery("User.FindByEmailAndPassWord", by("EmailUser",EmailUser).and("PasswordUser", PasswordUser).parameters());
		return listuser;
	}

	@Override
	public JSONObject getJSON(User model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("EmailUser", model.getEmailUser());
		object.put("FirstNameUser", model.getFirstNameUser());
		object.put("IdUser", model.getIdUser());
		object.put("LastNameUser", model.getLastNameUser());
		object.put("DateCreated", model.getDateCreated());
		return object;
	}

	@Override
	public User getModel(JSONObject object) throws JSONException {
		User user = new User();
		user.setPasswordUser(object.getString("PasswordUser"));
		user.setEmailUser(object.getString("EmailUser"));
		user.setFirstNameUser(object.getString("FirstNameUser"));
		user.setLastNameUser(object.getString("LastNameUser"));
		return user;
	}

	@Override
	public String Register(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(UserCheckAvailable(object.getString("EmailUser"))){
			UserDao.create(getModel(object));
			User newaccount = findUserByEmailAndPassword(object.getString("EmailUser"), object.getString("PasswordUser")).get(0);
			return WebResponse.getResponse(new HeaderImpl("Success" ,"Register : new Account",200),getJSON(newaccount));
		}else{
			return WebResponse.getResponse(new HeaderImpl("Failed ","Register : Email Already User" ,400),new JSONObject());
		}
	}

	@Override
	public String Login(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		List<User> list = findUserByEmailAndPassword(object.getString("EmailUser"), object.getString("PasswordUser"));
		if(list.size()==1){
			return WebResponse.getResponse(new HeaderImpl("Succed","Login : Connected",200),getJSON(list.get(0)));
		}
		return WebResponse.getResponse(new HeaderImpl("Failed","Login : Wrong Password",400), new JSONObject());
	}

}
