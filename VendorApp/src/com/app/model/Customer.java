package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cust_tab")
public class Customer {

	@Id
	@GeneratedValue(generator = "cust", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cust", sequenceName = "cust_seq")
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "cust_name")
	private String custName;
	@Column(name = "cust_email")
	private String custEmail;
	@Column(name = "cust_reg_num")
	private int custRegNum;
	@Column(name = "cust_addrss")
	private String custAddrss;
	@Column(name = "cust_type")
	private String custType;
	@Column(name = "cust_pwd")
	private String custPwd;
	@Column(name = "cust_tkn")
	private String custToken;

	public Customer() {
		System.out.println("default constructor()");
	}

	public Customer(int custId) {
		System.out.println("key constructor()");
		this.custId = custId;
	}

	public Customer(int custId, String custName, String custEmail,
			int custRegNum, String custAddrss, String custType, String custPwd,
			String custToken) {
		System.out.println("parameterized constructor()");
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custRegNum = custRegNum;
		this.custAddrss = custAddrss;
		this.custType = custType;
		this.custPwd = custPwd;
		this.custToken = custToken;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getCustRegNum() {
		return custRegNum;
	}

	public void setCustRegNum(int custRegNum) {
		this.custRegNum = custRegNum;
	}

	public String getCustAddrss() {
		return custAddrss;
	}

	public void setCustAddrss(String custAddrss) {
		this.custAddrss = custAddrss;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustPwd() {
		return custPwd;
	}

	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}

	public String getCustToken() {
		return custToken;
	}

	public void setCustToken(String custToken) {
		this.custToken = custToken;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custRegNum=" + custRegNum
				+ ", custAddrss=" + custAddrss + ", custType=" + custType
				+ ", custPwd=" + custPwd + ", custToken=" + custToken + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((custAddrss == null) ? 0 : custAddrss.hashCode());
		result = prime * result
				+ ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custId;
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custPwd == null) ? 0 : custPwd.hashCode());
		result = prime * result + custRegNum;
		result = prime * result
				+ ((custToken == null) ? 0 : custToken.hashCode());
		result = prime * result
				+ ((custType == null) ? 0 : custType.hashCode());
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
		Customer other = (Customer) obj;
		if (custAddrss == null) {
			if (other.custAddrss != null)
				return false;
		} else if (!custAddrss.equals(other.custAddrss))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custPwd == null) {
			if (other.custPwd != null)
				return false;
		} else if (!custPwd.equals(other.custPwd))
			return false;
		if (custRegNum != other.custRegNum)
			return false;
		if (custToken == null) {
			if (other.custToken != null)
				return false;
		} else if (!custToken.equals(other.custToken))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		return true;
	}

}
