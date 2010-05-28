package model.hibernate.test;

// Generated 28.May.2010 13:59:15 by Hibernate Tools 3.2.4.GA

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import model.SubjectiveTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class Subjectývetask.
 * @see model.hibernate.test.Subjectývetask
 * @author Hibernate Tools
 */
public class SubjectiveTtaskHome {

	private static final Log log = LogFactory.getLog(SubjectiveTtaskHome.class);

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

	public void persist(SubjectiveTask transientInstance) {
		log.debug("persisting SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SubjectiveTask instance) {
		log.debug("attaching dirty SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubjectiveTask instance) {
		log.debug("attaching clean SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SubjectiveTask persistentInstance) {
		log.debug("deleting SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectiveTask merge(SubjectiveTask detachedInstance) {
		log.debug("merging SubjectiveTask instance");
		try {
			SubjectiveTask result = (SubjectiveTask) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubjectiveTask findById(java.math.BigDecimal id) {
		log.debug("getting SubjectiveTask instance with id: " + id);
		try {
			SubjectiveTask instance = (SubjectiveTask) sessionFactory
					.getCurrentSession().get(
							"model.hibernate.test.SubjectiveTask", id);
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

	public List<SubjectiveTask> findByExample(SubjectiveTask instance) {
		log.debug("finding SubjectiveTask instance by example");
		try {
			List<SubjectiveTask> results = (List<SubjectiveTask>) sessionFactory
					.getCurrentSession().createCriteria(
							"model.hibernate.test.SubjectiveTask").add(
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
