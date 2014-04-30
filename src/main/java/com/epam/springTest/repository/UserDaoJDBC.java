package com.epam.springTest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.springTest.domain.User;

public class UserDaoJDBC implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDaoJDBC(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean create(User user) {
		int queryResult = jdbcTemplate
				.update("insert into User(firstName, lastName, patronymic, userTypeId) values(?, ?, ?, ?)",
						user.getFirstName(), user.getLastName(),
						user.getPatronymic(), user.getUserTypeId());
		return queryResult > 0;
	}

	public boolean update(User user) {
		int queryResult = jdbcTemplate
				.update("update User set firstName = ?, lastName = ?, patronymic = ?, userTypeId = ? where userId = ?",
						user.getFirstName(), user.getLastName(),
						user.getPatronymic(), user.getUserTypeId(),
						user.getUserId());
		return queryResult > 0;
	}

	public boolean delete(User user) {
		int queryResult = jdbcTemplate.update(
				"delete from User  where userId = ?", user.getUserId());
		return queryResult > 0;
	}

	public User getById(Integer id) {
		try {
			return jdbcTemplate
				.queryForObject(
						"select userId, firstName, lastName, patronymic, userTypeId from User where userId = ?",
						new UserMapper(), id);
		} catch(DataAccessException e) {
			return null;
		}
	}

	private static class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setPatronymic(rs.getString("patronymic"));
			user.setUserTypeId(rs.getInt("userTypeId"));
			return user;
		}
	}
}
