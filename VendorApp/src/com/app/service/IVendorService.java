package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {

	public int saveVendor(Vendor vendor);

	public Vendor getVendorById(int venId);

	public List<Vendor> getAllVendors();

	public void deleteVendorById(int venId);

	public void updateVendor(Vendor vendor);

}
