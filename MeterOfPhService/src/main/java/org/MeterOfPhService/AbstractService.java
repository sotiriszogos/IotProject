package org.MeterOfPhService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractService<T> {

	@PersistenceContext(unitName = "phmeter")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected T save(T entity) {
		T merge = entityManager.merge(entity);
		return merge;
	}

	protected void delete(Object entity) {
		if (isAttached(entity)) {
			entityManager.remove(entity);
		} else {
			entityManager.remove(entityManager.merge(entity));
		}
	}

	protected  T find(Class<T> entityClass, Object id) {
		return entityManager.find(entityClass, id);
	}

	protected boolean isAttached(Object entity) {
		return entityManager.contains(entity);
	}

	protected List<T> findAll(Class<T> entityClass) {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}

	protected int count(Class<T> entityClass) {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		Root<T> rt = cq.from(entityClass);
		cq.select(entityManager.getCriteriaBuilder().count(rt));
		javax.persistence.Query q = entityManager.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

}
