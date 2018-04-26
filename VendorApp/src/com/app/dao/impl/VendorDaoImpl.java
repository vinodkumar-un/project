package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveVendor(Vendor vendor) {
		return (Integer) ht.save(vendor);
	}

	@Override
	public Vendor getVendorById(int venId) {
		return ht.get(Vendor.class, venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

	@Override
	public void deleteVendorById(int venId) {
		ht.delete(new Vendor(venId));
	}

	@Override
	public void updateVendor(Vendor vendor) {
		ht.update(vendor);
	}
}
