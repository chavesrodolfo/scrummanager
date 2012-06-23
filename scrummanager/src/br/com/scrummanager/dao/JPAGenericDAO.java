package br.com.scrummanager.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAGenericDAO {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static JPAGenericDAO instance = new JPAGenericDAO ();

	private JPAGenericDAO(){  
        
    }  
    public static JPAGenericDAO getInstance() {  
        return instance;  
    } 
    
	private static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("scrummanagerPU");
		}
		em = emf.createEntityManager();
		return em;
	}

	/**
	 * create entity
	 * 
	 * @param <T>
	 * @param entity
	 * @throws Exception
	 */
	public <T> void persist(T entity) throws Exception {
		EntityManager em = getEntityManager();
		Exception e = null;
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(entity);
			t.commit();
		} catch (Exception ex) {
			if (t.isActive()) {
				em.getTransaction().rollback();
			}
			e = ex;
		}
		if (e != null) {
			throw e;
		}
	}

	/**
	 * update entity
	 * 
	 * @param <T>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public <T> T merge(T entity) throws Exception {
		EntityManager em = getEntityManager();
		Exception e = null;
		T retornoEntity = null;
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			retornoEntity = em.merge(entity);
			t.commit();
		} catch (Exception ex) {
			if (t.isActive()) {
				t.rollback();
			}
			e = ex;
		}
		if (e != null) {
			throw e;
		}
		return retornoEntity;
	}

	/**
	 * delete entity
	 * 
	 * @param <T>
	 * @param entity
	 * @throws Exception
	 */
	public <T> void remove(T entity) throws Exception {
		EntityManager em = getEntityManager();
		Exception e = null;
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			entity = em.merge(entity);
			em.remove(entity);
			t.commit();
		} catch (Exception ex) {
			if (t.isActive()) {
				t.rollback();
			}
			e = ex;
		}
		if (e != null) {
			throw e;
		}
	}

	/**
	 * retrieve entity
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T find(Class<T> entityClass, Object id) throws Exception {
		EntityManager em = getEntityManager();
		Exception e = null;
		T retorno = null;
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			retorno = (T) em.find(entityClass, id);
			t.commit();
		} catch (Exception ex) {
			if (t.isActive()) {
				t.rollback();
			}
			e = ex;
		}
		if (e != null) {
			throw e;
		}
		return retorno;
	}

	public <T> List<T> listAllDistinct(Class<T> entityClass) throws Exception {
		Collection<T> result = null;
		try {
			result = new LinkedHashSet<T>(listAll(entityClass));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null) {
			return new ArrayList<T>(result);
		}
		return null;
	}

	public <T> List<T> listAll(Class<T> entityClass, String... orderbys)
			throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			String query = "SELECT o FROM " + entityClass.getSimpleName()
					+ "  o  ORDER BY ";

			for (String order : orderbys) {
				query += order + " , ";
			}
			query = query.substring(0, query.length() - 2);
			Query q = em.createQuery(query);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> listAll(Class<T> entityClass) throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			String query = "SELECT o FROM "  + entityClass.getSimpleName()
					+ "  o ";
			Query q = em.createQuery(query);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> listByProperty(Class<T> entityClass,
			String propertyName, Object propertyValue) throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			String query = "SELECT o FROM " + entityClass.getSimpleName()
					+ "  o  WHERE o." + propertyName + "  = :propertyValue ";
			Query q = em.createQuery(query).setParameter("propertyValue",
					propertyValue);

			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> listByProperty(Class<T> entityClass,
			String propertyName, Object propertyValue, String operador,
			String... orderbys) throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			String query = null;
			if (!operador.equalsIgnoreCase("LIKE")) {
				query = "SELECT o FROM "  + entityClass.getSimpleName()
						+ "  o  WHERE o." + propertyName + "  " + operador
						+ " :propertyValue ";
			} else {
				query = "SELECT o FROM " + entityClass.getSimpleName()
						+ "  o  WHERE UPPER(o." + propertyName + ")  "
						+ operador + " UPPER(:propertyValue) ";
			}

			if (orderbys != null && orderbys.length > 0) {
				query += " ORDER BY ";
				for (String order : orderbys) {
					query += "o." + order + " , ";
				}
				query = query.substring(0, query.length() - 2);
			}

			Query q = em.createQuery(query).setParameter("propertyValue",
					propertyValue);

			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

	public <T> List<T> listByProperty(Class<T> entityClass,
			String propertyName, Object propertyValue, String operador)
			throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			String query = "SELECT o FROM " + entityClass.getSimpleName()
					+ "  o  WHERE o." + propertyName + "  " + operador
					+ " :propertyValue ";
			Query q = em.createQuery(query).setParameter("propertyValue",
					propertyValue);

			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public <T> List<T> findHql(Class<T> entityClass, String hql) throws Exception {
		EntityManager em = getEntityManager();
		List<T> retorno = null;
		try {
			Query q = em.createQuery(hql);
			retorno = q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}

}
