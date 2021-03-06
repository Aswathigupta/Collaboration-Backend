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

import com.niit.collaboration.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public Blog get(String id) {
		log.debug("start : calling get");
		String hql = "from Blog where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<Blog> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Blog> listBlog = query.getResultList();
		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	

	@Transactional
	public boolean save(Blog blog) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().save(blog);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(Blog blog) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().update(blog);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}

	@Transactional
	public boolean delete(String id) {

		Blog BlogToDelete = new Blog();
		try {
			BlogToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(BlogToDelete);
		return false;

	}

	@Transactional
	public List<Blog> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Blog> listBlog = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listBlog;
	}


}
