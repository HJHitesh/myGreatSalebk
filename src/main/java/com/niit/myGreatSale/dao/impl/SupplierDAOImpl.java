package com.niit.myGreatSale.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.myGreatSale.dao.SupplierDAO;
import com.niit.myGreatSale.model.Product;
import com.niit.myGreatSale.model.Supplier;


@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl  implements SupplierDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {

		return (Session) sessionFactory.getCurrentSession();

	}


	public List<Supplier> list() {
		
		return getSession().createQuery("from Supplier").list();
	}

	public Supplier getSupplierByID(String id) {
		
		return (Supplier) getSession().createQuery(" from Supplier where id='"+id+"'").uniqueResult();
	}

	public boolean save(Supplier supplier) {
		try {
			getSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			getSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteById(String id) {
		try {
			getSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	

}
