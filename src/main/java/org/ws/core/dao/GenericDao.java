package org.ws.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.impl.HeaderImpl;
	

public interface GenericDao<M, I extends Serializable> {
	

	void create(M model);

	M edit(M model);

	void remove(M model);

	M find(I id);

	List<M> findAll();

	List<M> findRange(int[] range);

	int count();

	void remove(I id);

	List<M> findWithNamedQuery(String namedQueryName, Map<String, ? extends Object> parameters);

	List<M> findWithNamedQuery(String namedQueryName);

	List<M> find(Map<String, ? extends Object> parameters);

	List<M> findWithNamedQuery(String namedQueryName, Integer maxResults,
			Integer firstResult);

	List<M> findWithNamedQuery(String namedQueryName,
			Map<String, ? extends Object> parameters, Integer maxResults,
			Integer firstResult);
	
    public JSONObject ConvertToJSON(M model);
    
    public M ConvertToModel(JSONObject jsonobject);
    
    public List<M> ConvertToArray(String string);
    

}
