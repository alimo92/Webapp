package org.ws.core.dao;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.ws.core.json.impl.HeaderImpl;
import org.ws.core.json.impl.ResponseBuilderImpl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public abstract class GenericDaoImpl<M,I extends Serializable> implements GenericDao<M,I>{

	private Class<M> entityClass;
	private ObjectMapper mapper;
	private ResponseBuilderImpl ResponseBuilderImpl;
	
	
    public GenericDaoImpl(Class<M> entityClass) {
	this.entityClass = entityClass;
    }

    protected Class<M> getTypeClass() {
	return entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public void create(M entity) {
	getEntityManager().persist(entity);
    }

    @Override
    public M edit(M entity) {
	return getEntityManager().merge(entity);
    }

    @Override
    public void remove(M entity) {
	getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public void remove(I id) {
	remove(find(id));
    }

    @Override
    public M find(I id) {
	return getEntityManager().find(entityClass, id);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<M> findAll() {
	javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
	return getEntityManager().createQuery(cq).getResultList();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<M> findRange(int[] range) {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
	Query q = getEntityManager().createQuery(cq);
	q.setMaxResults(range[1] - range[0] + 1);
	q.setFirstResult(range[0]);
	return q.getResultList();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public int count() {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	Root<M> rt = cq.from(entityClass);
	cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	Query q = getEntityManager().createQuery(cq);
	return ((Long) q.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<M> findWithNamedQuery(String namedQueryName, Map<String, ? extends Object> parameters) {

	Query query = getEntityManager().createNamedQuery(namedQueryName);
	for (Map.Entry<String, ? extends Object> entry : parameters.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}
	List<M> result = null;
	try {
	    result = (List<M>) query.getResultList();
	} catch (NoResultException e) {
	    return null;
	}
	return result;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<M> findWithNamedQuery(String namedQueryName, Map<String, ? extends Object> parameters,Integer maxResults, Integer firstResult) {

	Query query = getEntityManager().createNamedQuery(namedQueryName);
	if(maxResults!=null)
		query.setMaxResults(maxResults);
	if(firstResult!=null)
		query.setFirstResult(firstResult);
	for (Map.Entry<String, ? extends Object> entry : parameters.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}
	List<M> result = null;
	try {
	    result = (List<M>) query.getResultList();
	} catch (NoResultException e) {
	    return null;
	}
	return result;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<M> findWithNamedQuery(String namedQueryName) {
    	Query query = getEntityManager().createNamedQuery(namedQueryName);
    	List<M> result = null;
    	try {
    	    result = (List<M>) query.getResultList();
    		} catch (NoResultException e) {
    	    return null;
    		
    		}
    	return result;
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<M> findWithNamedQuery(String namedQueryName,Integer maxResults, Integer firstResult) {
    	Query query = getEntityManager().createNamedQuery(namedQueryName);
    	if(maxResults!=null)
    		query.setMaxResults(maxResults);
    	if(firstResult!=null)
    		query.setFirstResult(firstResult);
    	List<M> result = null;
    	try {
    	    result = (List<M>) query.getResultList();
    		} catch (NoResultException e) {
    	    return null;
    		}
    	return result;
        
    }
     
    @Override
    public List<M> find(final Map<String, ? extends Object> parameters) {
	CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	CriteriaQuery<M> cq = cb.createQuery(entityClass);
	Root<M> rt = cq.from(entityClass);
	EntityType<M> class_ = rt.getModel();
	List<Predicate> predicates = new ArrayList<Predicate>();
	for (Map.Entry<String, ? extends Object> entry : parameters.entrySet()) {
	    predicates.add(cb.equal(rt.get(class_.getSingularAttribute(entry.getKey())), entry.getValue()));
	}
	cq.where(cb.and(predicates.toArray(new Predicate[] {})));

	return getEntityManager().createQuery(cq).getResultList();
    }
    
	@Override
	public JSONObject ConvertToJSON(M model)
	{
		mapper = new ObjectMapper();
		try {
			return new JSONObject(mapper.writeValueAsString(model));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public M ConvertToModel(JSONObject jsonobject)
	{
		mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonobject.toString(), entityClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<M> ConvertToArray(String string){
		mapper = new ObjectMapper();
		try {
			return mapper.readValue(string, mapper.getTypeFactory().constructCollectionType(List.class, entityClass));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
