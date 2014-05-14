package com.epam.springTest.repository.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.springTest.domain.user.User;
import com.epam.springTest.domain.userType.UserType;
import com.epam.springTest.repository.DaoTestTemplate;
import com.epam.springTest.repository.user.UserDao;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/persistenceContextTests.xml"})
//public class UserDaoJDBCTest extends DaoTestTemplate {
public class UserDaoJDBCTest{
	private JdbcTemplate jdbcTemplate;
//	@Autowired
	private UserDao userDao;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/test/resources/persistenceContextTests.xml");
		jdbcTemplate = context.getBean(JdbcTemplate.class);
		userDao = context.getBean(UserDao.class);
		jdbcTemplate.execute("truncate table User");
		jdbcTemplate.execute("ALTER TABLE User ALTER COLUMN userId RESTART WITH 1");
	}

	@Test
	public void addUserToDbSuccessful() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserType(UserType.ADMIN);
		
		boolean actualResult = userDao.create(user);
		
		assertTrue(actualResult);
	}
	
	@Test
	public void selectUserByCorrectIdSuccess() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserType(UserType.ADMIN);
		
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
		user.setUserType(UserType.ADMIN);
		
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
		user.setUserType(UserType.ADMIN);	
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
		user.setUserType(UserType.ADMIN);	
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
		user.setUserType(UserType.ADMIN);		
		userDao.create(user);
		User newUser = new User();
		newUser.setFirstName("test1");
		newUser.setLastName("test1");
		newUser.setPatronymic("test1");
		newUser.setUserType(UserType.ADMIN);
		newUser.setUserId(1);
		
		boolean result = userDao.update(newUser);
		
		assertTrue(result);
	}
	
	@Test
	public void updateUserWithWrongIdFail() {
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserType(UserType.ADMIN);		
		userDao.create(user);
		User newUser = new User();
		newUser.setFirstName("test1");
		newUser.setLastName("test1");
		newUser.setPatronymic("test1");
		newUser.setUserType(UserType.ADMIN);
		newUser.setUserId(2);
		
		boolean result = userDao.update(newUser);
		
		assertFalse(result);
	}
}
