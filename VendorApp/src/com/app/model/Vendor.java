package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ven_tab")
public class Vendor {
	@Id
	@Column(name = "ven_id")
	@GeneratedValue(generator = "ven", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ven", sequenceName = "ven_seq")
	private int venId;
	@Column(name = "ven_name")
	private String venName;
	@Column(name = "ven_mail")
	private String venMail;

	@ManyToOne
	@JoinColumn(name = "loc_id_fk")
	private Location loc;

	public Vendor() {
		System.out.println("default constructor");
	}

	public Vendor(int venId) {
		System.out.println("key constructor()");
		this.venId = venId;
	}

	public Vendor(int venId, String venName, String venMail, Location loc) {
		System.out.println("parameterized constructor()");
		this.venId = venId;
		this.venName = venName;
		this.venMail = venMail;
		this.loc = loc;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenMail() {
		return venMail;
	}

	public void setVenMail(String venMail) {
		this.venMail = venMail;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venMail="
				+ venMail + ", loc=" + loc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + venId;
		result = prime * result + ((venMail == null) ? 0 : venMail.hashCode());
		result = prime * result + ((venName == null) ? 0 : venName.hashCode());
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
		Vendor other = (Vendor) obj;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (venId != other.venId)
			return false;
		if (venMail == null) {
			if (other.venMail != null)
				return false;
		} else if (!venMail.equals(other.venMail))
			return false;
		if (venName == null) {
			if (other.venName != null)
				return false;
		} else if (!venName.equals(other.venName))
			return false;
		return true;
	}

}
