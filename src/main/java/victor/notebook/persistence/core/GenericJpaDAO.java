package victor.notebook.persistence.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class GenericJpaDAO<T,ID extends Serializable> implements IGenericJpaDAO<T, ID> {

	protected Class<T> entityClass;
	
	@PersistenceContext
    protected EntityManager entityManager;

	public GenericJpaDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>)genericSuperclass.getActualTypeArguments()[0];
	}
	
	public T create(T t) {
		// TODO Auto-generated method stub
		this.entityManager.persist(t);
		return t;
	}

	public T read(ID id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(entityClass, id);
	}

	public List<T> readAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder crtBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> crtQuery = crtBuilder.createQuery(entityClass); 
		Root<T> qryRoot = crtQuery.from(entityClass);
		crtQuery.select(qryRoot);
		return this.entityManager.createQuery(crtQuery).getResultList();
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		return this.entityManager.merge(t);
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.entityManager.flush();
	}

	public void refresh(T t) {
		// TODO Auto-generated method stub
		this.entityManager.refresh(t);
	}

}
