package com.niit.myGreatSale.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.myGreatSale.dao.CartDAO;
import com.niit.myGreatSale.model.MyCart;


@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {

		return (Session) sessionFactory.getCurrentSession();

	}

	@Transactional
	public List<MyCart> list(String userId) {
		log.debug("Starting of the method list");
		String hql = "from MyCart where user_id=" + "'" + userId + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list");
		return query.list();

	}

	@Transactional
	public boolean save(MyCart myCart) {
		log.debug("Starting of the method save");

		myCart.setId(getMaxId());
		
		try {
			sessionFactory.getCurrentSession().save(myCart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public MyCart get(String id) {
		
		return (MyCart) sessionFactory.getCurrentSession().createQuery("from Mycart where id='"+id+"'").uniqueResult();
	}

	@Transactional
	public boolean delete(MyCart myCart) {
		
		myCart.setStatus('X');
		
		return update(myCart);
	}

	@Transactional
	public boolean update(MyCart myCart) {
		
		
		try {
			sessionFactory.getCurrentSession().update(myCart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Long getTotalAmount(String userId) {
		
		log.debug("Starting of the method getTotalAmount");
		
		String hql = "select sum(price*quantity) from MyCart where user_id=" + "'" + userId + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Long) query.uniqueResult();

	}

	@Transactional
	private Long getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			log.debug("hql" + hql);
			maxID = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return maxID + 1;

	}

}
