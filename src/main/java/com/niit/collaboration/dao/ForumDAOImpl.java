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

import com.niit.collaboration.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{
	Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public Forum get(String id) {
		log.debug("start : calling get");
		String hql = "from Forum where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<Forum> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Forum> listForum = query.getResultList();
		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	

	@Transactional
	public boolean save(Forum forum) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(Forum forum) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}

	@Transactional
	public boolean delete(String id) {

		Forum ForumToDelete = new Forum();
		try {
			ForumToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(ForumToDelete);
		return false;

	}

	@Transactional
	public List<Forum> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Forum> listForum = (List<Forum>) sessionFactory.getCurrentSession().createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listForum;
	}



}
