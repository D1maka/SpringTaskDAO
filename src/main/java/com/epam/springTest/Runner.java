package com.epam.springTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.springTest.domain.user.User;
import com.epam.springTest.domain.userType.UserType;
import com.epam.springTest.repository.user.UserDao;


public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("persistanceContext.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setPatronymic("test");
		user.setUserType(UserType.ADMIN);
		userDao.create(user);
		
		User searchUser = userDao.getById(1);
		System.out.println(searchUser.toString());
	}

}
