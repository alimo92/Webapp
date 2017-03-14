package org.ws.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.Header;
import org.ws.core.json.impl.HeaderImpl;

public interface GenericService<M, I extends Serializable> {

    /**
     * 
     * Save or Update object
     * 
     * @param m
     */
    public void persist(M m);

    /**
     * 
     * Save or Update object
     * 
     * @param m
     */
    M update(M m);

    /**
     * get object by PK
     * 
     * @param pk
     * @return target object
     */
    M find(I id);

    /**
     * remove object
     * 
     * @param model
     */
    M remove(I id);

    /**
     * remove object
     * 
     * @param model
     */
    public void remove(M model);

    /**
     * Searches for all instances of model given as a generic type.
     * 
     * @return List of all instances of model given as a generic type.
     */
    List<M> findAll();

    List<M> findWithNamedQuery(String namedQueryName, Map<String, ? extends Object> parameters);

    List<M> find(final Map<String, ? extends Object> params);
    
    public int count(); 
    
    public JSONObject getJSON(M model) throws JSONException;
    
    public M getModel(JSONObject object) throws JSONException;
    
    public JSONObject ConvertToJSON(M model);
    
    public M ConvertToModel(JSONObject jsonobject);
    
    public List<M> ConvertToArray(String string);
}
