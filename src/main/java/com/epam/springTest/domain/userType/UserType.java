package com.epam.springTest.domain.userType;

public enum UserType {
	ADMIN(0), DOCTOR(1), NURSE(2);
	
	private int userTypeId;
	
	private UserType(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public int getUserTypeId() {
		return userTypeId;
	}
}
