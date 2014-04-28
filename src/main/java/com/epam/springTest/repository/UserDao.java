package com.epam.springTest.repository;

import com.epam.springTest.domain.User;

public interface UserDao {
	public boolean create(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User getById(Integer id);
}
