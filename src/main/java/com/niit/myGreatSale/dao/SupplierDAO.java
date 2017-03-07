package com.niit.myGreatSale.dao;

import java.util.List;

import com.niit.myGreatSale.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	public Supplier getSupplierByID(String id);

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean deleteById(String id);

}
