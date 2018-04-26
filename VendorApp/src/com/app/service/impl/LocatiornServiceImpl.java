package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;

@Service
public class LocatiornServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao dao;

	@Override
	public int saveLocation(Location location) {
		return dao.saveLocation(location);
	}

	@Override
	public Location showLocById(int id) {
		return dao.showLocById(id);
	}

	@Override
	public List<Location> viewAllLocations() {
		return dao.viewAllLocations();
	}

	@Override
	public void updateLoc(Location loc) {
		dao.updateLoc(loc);
	}

	@Override
	public void deleteLocById(int locId) {
		dao.deleteLocById(locId);
	}

	@Override
	public List<Object[]> getLocationWiseCount() {
		return dao.getLocationWiseCount();
	}

	@Override
	public boolean isLocNameExist(String locName) {
		return dao.isLocNameExist(locName);
	}
}
