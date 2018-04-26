package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author user
 * 
 */
@Entity
@Table(name = "loc_tab")
public class Location {

	@Id
	@Column(name = "loc_id")
	@GeneratedValue(generator = "loc", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "loc", sequenceName = "loc_seq")
	private int locId;
	@Column(name = "loc_name")
	private String locName;
	@Column(name = "loc_type")
	private String locType;

	public Location() {
		System.out.println("default constructor()");
	}

	public Location(int locId) {
		System.out.println("key constructor()");
		this.locId = locId;
	}

	public Location(int locId, String locName, String locType) {
		System.out.println("parameterized constructor()");
		this.locId = locId;
		this.locName = locName;
		this.locType = locType;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + locId;
		result = prime * result + ((locName == null) ? 0 : locName.hashCode());
		result = prime * result + ((locType == null) ? 0 : locType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locId != other.locId)
			return false;
		if (locName == null) {
			if (other.locName != null)
				return false;
		} else if (!locName.equals(other.locName))
			return false;
		if (locType == null) {
			if (other.locType != null)
				return false;
		} else if (!locType.equals(other.locType))
			return false;
		return true;
	}

}