package org.ws.core.json.impl;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.springframework.stereotype.Component;
import org.ws.core.json.WebResponse;
@Component
public class WebResponseImpl implements WebResponse {
	private HeaderImpl Header ;
	private JSONArray ItemList;
	public WebResponseImpl() {
		super();
		setItemList(new JSONArray());
	}
	public WebResponseImpl(HeaderImpl header, JSONArray itemList) {
		super();
		Header = header;
		ItemList = itemList;
	}
	public HeaderImpl getHeader() {
		return Header;
	}
	public void setHeader(HeaderImpl header) {
		Header = header;
	}
	public JSONArray getItemList() {
		return ItemList;
	}
	public void setItemList(JSONArray itemList) {
		ItemList = itemList;
	}
	@Override
	public void AddItemToList(JSONObject object) {
		this.ItemList.put(object);
	}
	@Override
	public void AddItemToList(JSONArray array) throws JSONException {
		for(int i=0;i<array.length();i++){
			this.ItemList.put(array.getJSONObject(i));
		}
	}
	@Override
	public String getResponse(HeaderImpl header, JSONObject object) throws JSONException {
		setHeader(header);
		this.ItemList = new JSONArray();
		AddHeaderToList();
		if(object.length()!=0) {AddItemToList(object);}
		return getItemList().toString();
	}
	@Override
	public void AddHeaderToList() throws JSONException {
		getItemList().put(this.Header.getJsonHeader());
		
	}
	@Override
	public String getResponse(HeaderImpl header, JSONArray array) throws JSONException {
		setHeader(header);
		this.ItemList = new JSONArray();
		AddHeaderToList();
		if(array.length()!=0){AddItemToList(array);}
		return getItemList().toString();
	}
	
	
	

}
