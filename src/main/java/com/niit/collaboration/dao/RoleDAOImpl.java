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

import com.niit.collaboration.model.Role;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {
	
	Logger log = LoggerFactory.getLogger(RoleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public RoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public Role get(String id) {
		log.debug("start : calling get");
		String hql = "from Role where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<Role> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Role> listRole = query.getResultList();
		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		log.debug("end : calling get");
		return null;

	}
	
	

	@Transactional
	public boolean save(Role role) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(role);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}
	
	@Transactional
	public boolean update(Role role) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(role);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("ending of the method saveOrUpdate");
		return false;
	}

	@Transactional
	public boolean delete(String id) {

		Role RoleToDelete = new Role();
		try {
			RoleToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(RoleToDelete);
		return false;

	}

	@Transactional
	public List<Role> list() {
		log.debug("start : calling list");
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Role> listRole = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("end : calling list");
		return listRole;
	}




}
