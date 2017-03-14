package org.ws.vo.convert;


import java.util.ArrayList;
import java.util.List;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Component;
import org.ws.entities.User;
import org.ws.vo.UserVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class UserConvert {
	
	public UserVO ConvertToUserVO(User user){
		UserVO uservo = new UserVO();
		uservo.setEmailUser(user.getEmailUser());
		uservo.setFirstNameUser(user.getFirstNameUser());
		uservo.setLastNameUser(user.getLastNameUser());
		uservo.setIdUser(user.getIdUser());
		return uservo;
	}
	
	public List<UserVO> ConvertToUserVO(List<User> listuser){
		List<UserVO> list = new ArrayList<>();
		for(int i=0;i<listuser.size();i++){
			list.add(ConvertToUserVO(listuser.get(i)));
		}
		return list;
	}
	
	public User ConvertToUser(UserVO uservo){
		User user = new User();
		user.setFirstNameUser(uservo.getFirstNameUser());
		user.setLastNameUser(uservo.getLastNameUser());
		user.setEmailUser(uservo.getEmailUser());
		return user;
	}
	
}
