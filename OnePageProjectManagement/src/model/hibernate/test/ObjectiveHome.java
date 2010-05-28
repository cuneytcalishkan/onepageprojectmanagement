package model.hibernate.test;

// Generated 28.May.2010 12:11:39 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.Objective;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Object�ve.
 * 
 * @see test.Object�ve
 * @author Hibernate Tools
 */
public class ObjectiveHome {

	private static final Log log = LogFactory.getLog(ObjectiveHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Objective transientInstance) {
		log.debug("persisting Object�ve instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Objective instance) {
		log.debug("attaching dirty Object�ve instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Objective instance) {
		log.debug("attaching clean Object�ve instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Objective persistentInstance) {
		log.debug("deleting Object�ve instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Objective merge(Objective detachedInstance) {
		log.debug("merging Object�ve instance");
		try {
			Objective result = (Objective) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Objective findById(java.math.BigDecimal id) {
		log.debug("getting Object�ve instance with id: " + id);
		try {
			Objective instance = (Objective) sessionFactory.getCurrentSession()
					.get("test.Object�ve", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Objective> findByExample(Objective instance) {
		log.debug("finding Object�ve instance by example");
		try {
			List<Objective> results = (List<Objective>) sessionFactory
					.getCurrentSession().createCriteria("test.Object�ve").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
