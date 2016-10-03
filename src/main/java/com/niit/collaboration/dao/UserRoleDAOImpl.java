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

import com.niit.collaboration.model.UserRole;


@Repository("userRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {

	Logger log = LoggerFactory.getLogger(UserRoleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserRoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public UserRole get(String id) {
		log.debug("start : calling get");
		String hql = "from UserRole where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<UserRole> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<UserRole> listUserRole = query.getResultList();
		if (listUserRole != null && !listUserRole.isEmpty()) {
			return listUserRole.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	

	@Transactional
	public boolean save(UserRole userRole) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userRole);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(UserRole userRole) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userRole);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	

	@Transactional
	public boolean delete(String id) {

		UserRole UserRoleToDelete = new UserRole();
		try {
			UserRoleToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(UserRoleToDelete);
		return false;

	}

	@Transactional
	public List<UserRole> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<UserRole> listUserRole = (List<UserRole>) sessionFactory.getCurrentSession().createCriteria(UserRole.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listUserRole;
	}


}
