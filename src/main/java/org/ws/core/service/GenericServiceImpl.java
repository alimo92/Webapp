package org.ws.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ws.core.dao.GenericDao;
import org.ws.core.json.ResponseBuilder;
import org.ws.core.json.impl.HeaderImpl;


@Service
@Transactional
public abstract class GenericServiceImpl<M, I extends Serializable> implements GenericService<M, I>
{

	protected abstract GenericDao<M, I> getDao();


	@Override
	public void persist(final M model)
	{
		getDao().create(model);
	}

	@Override
	public M update(final M model)
	{

		return getDao().edit(model);
	}
	
	@Override
	public int count()
	{

		return getDao().count();
	}

	@Override
	public M find(final I id)
	{
		return getDao().find(id);
	}

	@Override
	public M remove(final I id)
	{
		final M model = find(id);
		getDao().remove(model);
		return model;
	}

	@Override
	public void remove(final M model)
	{
		getDao().remove(model);
	}

	@Override
	public List<M> findAll()
	{
		return getDao().findAll();
	}

	@Override
	public List<M> find(final Map<String, ? extends Object> params)
	{
		return getDao().find(params);
	}

	@Override
	public List<M> findWithNamedQuery(final String namedQueryName, final Map<String, ? extends Object> parameters)
	{
		return getDao().findWithNamedQuery(namedQueryName, parameters);
	}
	
	@Override
	public JSONObject ConvertToJSON(M model)
	{
		return getDao().ConvertToJSON(model);
	}
	
	@Override
	public M ConvertToModel(JSONObject jsonobject)
	{
		return getDao().ConvertToModel(jsonobject);
	}
	
	@Override
	public List<M> ConvertToArray(String string){
		return getDao().ConvertToArray(string);
	}
	
}
