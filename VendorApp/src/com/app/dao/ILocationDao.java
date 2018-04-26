package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {

	int saveLocation(Location location);

	Location showLocById(int id);

	List<Location> viewAllLocations();

	void updateLoc(Location loc);

	void deleteLocById(int locId);

	List<Object[]> getLocationWiseCount();

	public boolean isLocNameExist(String locName);

}
