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

import com.niit.collaboration.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public User get(String id) {
		log.debug("start : calling get");
		String hql = "from User where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<User> listUser = query.getResultList();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	
	@Transactional
	public boolean save(User user) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(User user) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}

	@Transactional
	public boolean delete(String id) {

		User UserToDelete = new User();
		try {
			UserToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(UserToDelete);
		return false;

	}

	@Transactional
	public List<User> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listUser;
	}

	
	

}
