package org.ws.service;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.service.GenericService;
import org.ws.entities.Comment;

public interface CommentService extends GenericService<Comment, Integer>{

	JSONObject CommentPost(String json) throws JSONException;

	JSONArray GetPostComments(int id) throws JSONException;

}
