package com.revature.seniorcare.dataobjects;

import com.revature.seniorcare.beans.User;

public class UserInfo {
	int userId;
	String userrole;
	String username;
	
	public UserInfo(User u) {
		this.userId = u.getId();
		this.username = u.getEmail();
		this.userrole = u.getUserrole();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
