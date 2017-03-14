package org.ws.core.json.impl;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Component;
import org.ws.core.json.Header;
import org.ws.core.json.ResponseBuilder;
@Component
public class ResponseBuilderImpl implements ResponseBuilder{
	
	private Header ResponseHeader;
	private JSONArray ResponseObjectList;
	public ResponseBuilderImpl(Header responseHeader, JSONArray responseObjectList) {
		super();
		ResponseHeader = responseHeader;
		ResponseObjectList = responseObjectList;
	}
	public ResponseBuilderImpl() {
		super();
		setResponseObjectList(new JSONArray());
	}
	public Header getResponseHeader() {
		return ResponseHeader;
	}
	public void setResponseHeader(Header responseHeader) {
		ResponseHeader = responseHeader;
	}
	public JSONArray getResponseObjectList() {
		return ResponseObjectList;
	}
	public void setResponseObjectList(JSONArray responseObjectList) {
		ResponseObjectList = responseObjectList;
	}
	@Override
	public void AddObjectToResponse(JSONObject object) {
		this.ResponseObjectList.put(object);
	}
	@Override
	public void AddHeaderToResponse() {
		try {
			AddObjectToResponse(this.ResponseHeader.getJsonHeader());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public JSONArray getFinalResponse(HeaderImpl header, JSONObject jsonobject) {
		setResponseObjectList(new JSONArray());
		setResponseHeader(header);
		AddHeaderToResponse();
		AddObjectToResponse(jsonobject);
		return getResponseObjectList();
	}
	@Override
	public JSONArray getFinalResponse(HeaderImpl header, JSONArray jsonarray,int mode) {
		setResponseObjectList(new JSONArray());
		setResponseHeader(header);
		AddHeaderToResponse();
		if(mode==0){
			AddListToResponseSimple(jsonarray);
		}else{
			AddListToResponse(jsonarray);
		}
		return getResponseObjectList();
	}
	@Override
	public void AddListToResponse(JSONArray jsonarray) {
		this.ResponseObjectList.put(jsonarray);
		
	}
	@Override
	public void AddListToResponseSimple(JSONArray jsonarray) {
		for(int i=0;i<jsonarray.length();i++){
			try {
				AddObjectToResponse(jsonarray.getJSONObject(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	
}
