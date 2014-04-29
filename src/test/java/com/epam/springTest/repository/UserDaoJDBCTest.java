package com.epam.springTest.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springTest.domain.User;


public class UserDaoJDBCTest extends DaoTestTemplate {
	
	
	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		jdbcTemplate.execute("truncate table User");
		jdbcTemplate.execute("ALTER TABLE User ALTER COLUMN userId RESTART WITH 1");
	}

	@Test
	public void addUserToDbSuccessful() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);
		
		boolean actualResult = userDao.create(user);
		
		assertTrue(actualResult);
	}
	
	@Test
	public void selectUserByCorrectIdSuccess() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);
		
		userDao.create(user);
		int correctId = 1;
		User selectedUser = userDao.getById(correctId);
		
		assertNotNull(selectedUser);
	}
	
	@Test
	public void selectUserByUncorrectIdFail() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);
		
		userDao.create(user);
		int uncorrectId = 2;
		User selectedUser = userDao.getById(uncorrectId);
		
		assertNull(selectedUser);
	}
	
	@Test
	public void deleteInsertedUserSuccess() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);	
		user.setUserId(1);
		userDao.create(user);
		
		boolean result = userDao.delete(user);
		assertTrue(result);
	}
	
	@Test
	public void deleteNotExistingUserFail() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);	
		user.setUserId(1);
		
		boolean result = userDao.delete(user);
		assertFalse(result);
	}
	
	@Test
	public void updateUserToDbSuccessful() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserTypeId(1);		
		userDao.create(user);
		User newUser = new User();
		newUser.setFirstName("test1");
		newUser.setLastName("test1");
		newUser.setPatronymic("test1");
		newUser.setUserTypeId(1);
		newUser.setUserId(1);
		
		boolean result = userDao.update(newUser);
		
		assertTrue(result);
	}
}
