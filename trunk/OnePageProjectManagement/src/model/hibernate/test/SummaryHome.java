package model.hibernate.test;

// Generated 28.May.2010 12:11:39 by Hibernate Tools 3.2.4.GA

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import model.Summary;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class Summary.
 * @see test.Summary
 * @author Hibernate Tools
 */
public class SummaryHome {

	private static final Log log = LogFactory.getLog(SummaryHome.class);

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

	public void persist(Summary transientInstance) {
		log.debug("persisting Summary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Summary instance) {
		log.debug("attaching dirty Summary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Summary instance) {
		log.debug("attaching clean Summary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Summary persistentInstance) {
		log.debug("deleting Summary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Summary merge(Summary detachedInstance) {
		log.debug("merging Summary instance");
		try {
			Summary result = (Summary) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Summary findById(java.math.BigDecimal id) {
		log.debug("getting Summary instance with id: " + id);
		try {
			Summary instance = (Summary) sessionFactory.getCurrentSession()
					.get("test.Summary", id);
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

	public List<Summary> findByExample(Summary instance) {
		log.debug("finding Summary instance by example");
		try {
			List<Summary> results = (List<Summary>) sessionFactory
					.getCurrentSession().createCriteria("test.Summary").add(
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
