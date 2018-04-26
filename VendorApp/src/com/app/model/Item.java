package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_tab")
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_code")
	private double itemCode;
	@Column(name = "item_margin")
	private int marginValue;
	@Column(name = "cust_id")
	private int custId;

	public Item() {
		System.out.println("zero argument constructor()");
	}

	public Item(int itemId) {
		System.out.println("key constructor()s");
		this.itemId = itemId;
	}

	public Item(int itemId, String itemName, double itemCode, int marginValue,
			int custId) {
		System.out.println("parameterized constructor()");
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.marginValue = marginValue;
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCode=" + itemCode + ", marginValue=" + marginValue
				+ ", custId=" + custId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		long temp;
		temp = Double.doubleToLongBits(itemCode);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + marginValue;
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
		Item other = (Item) obj;
		if (custId != other.custId)
			return false;
		if (Double.doubleToLongBits(itemCode) != Double
				.doubleToLongBits(other.itemCode))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (marginValue != other.marginValue)
			return false;
		return true;
	}

}
