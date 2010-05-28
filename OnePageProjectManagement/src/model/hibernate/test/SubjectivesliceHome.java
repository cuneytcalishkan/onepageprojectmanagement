package model.hibernate.test;

// Generated 28.May.2010 12:11:39 by Hibernate Tools 3.2.4.GA

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import model.SubjectiveSlice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class Subjectýveslýce.
 * @see test.Subjectýveslýce
 * @author Hibernate Tools
 */
public class SubjectivesliceHome {

	private static final Log log = LogFactory.getLog(SubjectivesliceHome.class);

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

	public void persist(SubjectiveSlice transientInstance) {
		log.debug("persisting SubjectiveSlice instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SubjectiveSlice instance) {
		log.debug("attaching dirty SubjectiveSlice instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubjectiveSlice instance) {
		log.debug("attaching clean SubjectiveSlice instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SubjectiveSlice persistentInstance) {
		log.debug("deleting SubjectiveSlice instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectiveSlice merge(SubjectiveSlice detachedInstance) {
		log.debug("merging SubjectiveSlice instance");
		try {
			SubjectiveSlice result = (SubjectiveSlice) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubjectiveSlice findById(java.math.BigDecimal id) {
		log.debug("getting SubjectiveSlice instance with id: " + id);
		try {
			SubjectiveSlice instance = (SubjectiveSlice) sessionFactory
					.getCurrentSession().get("test.SubjectiveSlice", id);
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

	public List<SubjectiveSlice> findByExample(SubjectiveSlice instance) {
		log.debug("finding SubjectiveSlice instance by example");
		try {
			List<SubjectiveSlice> results = (List<SubjectiveSlice>) sessionFactory
					.getCurrentSession().createCriteria("test.SubjectiveSlice")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
