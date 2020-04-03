package fr.iocean.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;

public abstract class AbstractEntityService <T> {
	
	@Inject
	EntityManager em;
	
	protected Class<T> entityClass;
	
	@PostConstruct
	public void init() {
		entityClass = getEntityClass();
	}
	
	protected abstract Class<T> getEntityClass();
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	@Transactional
	public T createEntity(T t) {
		em.persist(t);
		return t;
	}
	
	@Transactional
	public List<T> listAll() {
		return getSession().createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}

}
