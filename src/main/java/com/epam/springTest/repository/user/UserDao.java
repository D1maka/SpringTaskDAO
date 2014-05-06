package com.epam.springTest.repository.user;

import com.epam.springTest.domain.user.User;

public interface UserDao {
	public boolean create(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User getById(Integer id);
	public User getDoctorByPatientHistoryId(Integer patientHistoryId);
}
