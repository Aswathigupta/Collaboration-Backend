package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	Logger log = LoggerFactory.getLogger(JobDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public Job get(String id) {
		log.debug("start : calling get");
		String hql = "from Job where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<Job> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Job> listJob = query.getResultList();
		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	

	@Transactional
	public boolean save(Job job) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(Job job) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}

	@Transactional
	public boolean delete(String id) {

		Job JobToDelete = new Job();
		try {
			JobToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(JobToDelete);
		return false;

	}

	@Transactional
	public List<Job> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Job> listJob = (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listJob;
	}



}
