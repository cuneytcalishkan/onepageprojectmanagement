package model.hibernate.test;

// Generated 28.May.2010 12:11:39 by Hibernate Tools 3.2.4.GA

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
 * @see test.Subjectývetask
 * @author Hibernate Tools
 */
public class SubjectivetaskHome {

	private static final Log log = LogFactory.getLog(SubjectivetaskHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDi", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDi");
		}
	}

	public void persist(SubjectiveTask transientinstance) {
		log.debug("persisting SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().persist(transientinstance);
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

	public void delete(SubjectiveTask persistentinstance) {
		log.debug("deleting SubjectiveTask instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentinstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectiveTask merge(SubjectiveTask detachedinstance) {
		log.debug("merging SubjectiveTask instance");
		try {
			SubjectiveTask result = (SubjectiveTask) sessionFactory
					.getCurrentSession().merge(detachedinstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubjectiveTask findByid(java.math.BigDecimal id) {
		log.debug("getting SubjectiveTask instance with id: " + id);
		try {
			SubjectiveTask instance = (SubjectiveTask) sessionFactory
					.getCurrentSession().get("test.SubjectiveTask", id);
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
					.getCurrentSession().createCriteria("test.SubjectiveTask")
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
