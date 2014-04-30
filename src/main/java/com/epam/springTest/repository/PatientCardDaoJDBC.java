package com.epam.springTest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.springTest.domain.PatientCard;

public class PatientCardDaoJDBC implements PatientCardDao {

	private JdbcTemplate jdbcTemplate;

	public PatientCardDaoJDBC(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean create(PatientCard card) {
		int queryResult = jdbcTemplate
				.update("insert into PatientCard(firstName, lastName, patronymic, dateOfBirth) values(?, ?, ?, ?)",
						card.getFirstName(), card.getLastName(),
						card.getPatronymic(), card.getDateOfBirth());
		return queryResult > 0;
	}

	public boolean update(PatientCard card) {
		int queryResult = jdbcTemplate
				.update("update PatientCard set firstName = ?, lastName = ?, patronymic = ?, dateOfBirth = ? where patientCardId = ?",
						card.getFirstName(), card.getLastName(),
						card.getPatronymic(), card.getDateOfBirth(),
						card.getPatientCardId());
		return queryResult > 0;
	}

	public boolean delete(PatientCard card) {
		int queryResult = jdbcTemplate.update(
				"delete from PatientCard where patientCardId = ?",
				card.getPatientCardId());
		return queryResult > 0;
	}

	public PatientCard getById(Integer id) {
		try {
			return jdbcTemplate
					.queryForObject(
							"select patientCardId, firstName, lastName, patronymic, dateOfBirth from PatientCard where patientCardId = ?",
							new PatientCardMapper(), id);
		} catch (DataAccessException e) {
			return null;
		}
	}

	private static class PatientCardMapper implements RowMapper<PatientCard> {

		public PatientCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			PatientCard card = new PatientCard();
			card.setPatientCardId(rs.getInt("patientCardId"));
			card.setFirstName(rs.getString("firstName"));
			card.setLastName(rs.getString("lastName"));
			card.setPatronymic(rs.getString("patronymic"));
			card.setDateOfBirth(rs.getDate("dateOfBrth"));
			return card;
		}

	}

}
