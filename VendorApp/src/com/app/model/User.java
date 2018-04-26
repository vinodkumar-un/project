package com.app.model;

public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private String mobileNum;
	private String address;
	private String userPwd;

	public User() {
		System.out.println("default constructor()");
	}

	public User(int userId) {
		System.out.println("key constructor()");
		this.userId = userId;
	}

	public User(int userId, String userName, String userEmail,
			String mobileNum, String address, String userPwd) {
		System.out.println("parameterized constructor()");
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.mobileNum = mobileNum;
		this.address = address;
		this.userPwd = userPwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", mobileNum=" + mobileNum
				+ ", address=" + address + ", userPwd=" + userPwd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((mobileNum == null) ? 0 : mobileNum.hashCode());
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (mobileNum == null) {
			if (other.mobileNum != null)
				return false;
		} else if (!mobileNum.equals(other.mobileNum))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPwd == null) {
			if (other.userPwd != null)
				return false;
		} else if (!userPwd.equals(other.userPwd))
			return false;
		return true;
	}

}
