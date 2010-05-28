package model.hibernate.test;

// Generated 28.May.2010 12:11:39 by Hibernate Tools 3.2.4.GA

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import model.MajorSlice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class Majorslýce.
 * 
 * @see test.Majorslýce
 * @author Hibernate Tools
 */
public class MajorsliceHome {

	private static final Log log = LogFactory.getLog(MajorsliceHome.class);

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

	public void persist(MajorSlice transientInstance) {
		log.debug("persisting MajorSlice instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MajorSlice instance) {
		log.debug("attaching dirty MajorSlice instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MajorSlice instance) {
		log.debug("attaching clean MajorSlice instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MajorSlice persistentInstance) {
		log.debug("deleting MajorSlice instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MajorSlice merge(MajorSlice detachedInstance) {
		log.debug("merging MajorSlice instance");
		try {
			MajorSlice result = (MajorSlice) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MajorSlice findById(java.math.BigDecimal id) {
		log.debug("getting MajorSlice instance with id: " + id);
		try {
			MajorSlice instance = (MajorSlice) sessionFactory
					.getCurrentSession().get("test.MajorSlice", id);
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

	public List<MajorSlice> findByExample(MajorSlice instance) {
		log.debug("finding MajorSlice instance by example");
		try {
			List<MajorSlice> results = (List<MajorSlice>) sessionFactory
					.getCurrentSession().createCriteria("test.MajorSlice").add(
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
