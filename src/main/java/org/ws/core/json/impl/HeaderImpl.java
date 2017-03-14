package org.ws.core.json.impl;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.Header;


public class HeaderImpl implements Header{
	private String HeaderStatus;
	private String HeaderLabel;
	private int HeaderCode;
	
	public HeaderImpl() {
		super();
	}
	public HeaderImpl(String headerStatus, String headerLabel, int headerCode) {
		super();
		HeaderStatus = headerStatus;
		HeaderLabel = headerLabel;
		HeaderCode = headerCode;
	}
	public String getHeaderStatus() {
		return HeaderStatus;
	}
	public void setHeaderStatus(String headerStatus) {
		HeaderStatus = headerStatus;
	}
	public String getHeaderLabel() {
		return HeaderLabel;
	}
	public void setHeaderLabel(String headerLabel) {
		HeaderLabel = headerLabel;
	}
	public int getHeaderCode() {
		return HeaderCode;
	}
	public void setHeaderCode(int headerCode) {
		HeaderCode = headerCode;
	}
	
	public JSONObject getJsonHeader() throws JSONException{
		JSONObject result = new JSONObject();
		result.put("HeaderStatus", this.HeaderStatus);
		result.put("HeaderCode", this.HeaderCode);
		result.put("HeaderLabel", this.HeaderLabel);
		return result;
		
	}
	
}
