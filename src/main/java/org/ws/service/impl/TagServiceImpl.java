package org.ws.service.impl;

import static org.ws.core.search.QueryParameter.by;

import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.core.dao.GenericDao;
import org.ws.core.service.GenericServiceImpl;
import org.ws.dao.TagDao;
import org.ws.entities.Post;
import org.ws.entities.Tag;
import org.ws.service.PostService;
import org.ws.service.TagService;
import org.ws.service.UserService;

import scala.annotation.meta.setter;
@Service
public class TagServiceImpl  extends GenericServiceImpl<Tag, Integer> implements TagService{
	@Autowired
	TagDao TagDao;
	
	@Autowired
	PostService PostService;
	
	@Autowired
	UserService UserService;
		
	@Override
	protected GenericDao<Tag, Integer> getDao() {
		return TagDao;
	}

	@Override
	public JSONObject getJSON(Tag model) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("DateCreated", model.getDateCreated());
		object.put("User", model.getUser().getIdUser());
		object.put("Post", model.getPost().getIdPost());
		object.put("Tagged", model.getTagged().getIdUser());
		object.put("IdTag", model.getIdTag());
		return object;
	}

	@Override
	public Tag getModel(JSONObject object) throws JSONException {
		Tag model = new Tag();
		model.setPost(PostService.find(object.getInt("Post")));
		model.setUser(UserService.find(object.getInt("User")));
		model.setTagged(UserService.find(object.getInt("Tagged")));
		return model;
	}

	@Override
	public JSONObject TagUser(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		if(findTag(object.getInt("User"), object.getInt("Tagged"), object.getInt("Post"))==null){
			TagDao.create(getModel(object));
			return new JSONObject().put("Message", "User Tagged");
		}else{
			return new JSONObject().put("Message", "User Already tagged in this post");
		}
	}

	@Override
	public Tag findTag(int iduser, int idtagged, int idpost) {
		List<Tag> list = TagDao.findWithNamedQuery("Tag.findTagByUserTaggedPost", by("IdUser",iduser).and("IdTagged", idtagged).and("IdPost", idpost).parameters());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public JSONArray getAllTagsOfPost(int id) throws JSONException {
		List<Tag> list = (List<Tag>) PostService.find(id).getTagsPost();
		JSONArray array = new JSONArray();
		for(int i=0;i<list.size();i++){
			array.put(getJSON(list.get(i)));
		}
		return array;
	}

	@Override
	public JSONArray getTagsOfPost(Post post) {
		return null;
	}

	@Override
	public void AddTag(int idpost, int iduser, int idtagged) {
		Tag model = new Tag();
		model.setPost(PostService.find(idpost));
		model.setTagged(UserService.find(idtagged));
		model.setUser(UserService.find(iduser));
		TagDao.create(model);
	}

	@Override
	public JSONObject UnTagUser(String json) throws JSONException {
		JSONObject object = new JSONObject(json);
		Tag model = findTag(object.getInt("User"), object.getInt("Tagged"), object.getInt("Post"));
		if(model!=null){
			TagDao.remove(model);
			return new JSONObject().put("Message", "User UnTagged");
		}else{
			return new JSONObject().put("Message", "User wasn't tagged in the first place");
		}
	}
}
