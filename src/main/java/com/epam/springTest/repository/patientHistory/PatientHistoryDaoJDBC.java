package com.epam.springTest.repository.patientHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.springTest.domain.patientHistory.PatientHistory;


public class PatientHistoryDaoJDBC implements PatientHistoryDao {

	private JdbcTemplate jdbcTemplate;

	public PatientHistoryDaoJDBC(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean create(PatientHistory history) {
		int queryResult = jdbcTemplate
				.update("insert into PatientHistory(patientCardId, doctorId, diagnosisName, diagnosisDate, diagnosisComment) values(?, ?, ?, ?, ?)",
						history.getPatientCardId(), history.getDoctorId(),
						history.getDiagnosisName(), history.getDiagnosisDate(),
						history.getDiagnosisComment());
		return queryResult > 0;
	}

	public boolean update(PatientHistory history) {
		int queryResult = jdbcTemplate
				.update("update PatientHistory set patientCardId = ?, doctorId = ?, diagnosisName = ?, diagnosisDate = ?, diagnosisComment = ? where patientHistoryId = ?",
						history.getPatientCardId(), history.getDoctorId(),
						history.getDiagnosisName(), history.getDiagnosisDate(),
						history.getDiagnosisComment(),
						history.getPatientHistoryId());
		return queryResult > 0;
	}

	public boolean delete(PatientHistory history) {
		int queryResult = jdbcTemplate.update(
				"delete from PatientHistory  where patientHistoryId = ?",
				history.getPatientHistoryId());
		return queryResult > 0;
	}

	public PatientHistory getById(Integer id) {
		try {
			return jdbcTemplate
					.queryForObject(
							"select patientHistoryId, patientCardId, doctorId, diagnosisName, diagnosisDate, diagnosisComment from PatientHistory where patientHistoryId = ?",
							new PatientHistoryMapper(), id);
		} catch (DataAccessException e) {
			return null;
		}
	}

	public List<PatientHistory> getPatientHistory(Integer patientId) {
		try {
			return jdbcTemplate
					.query("select patientHistoryId, patientCardId, doctorId, diagnosisName, diagnosisDate, diagnosisComment from PatientHistory where patientCardId = ?",
							new PatientHistoryMapper(), patientId);
		} catch (DataAccessException e) {
			return null;
		}
	}

	private static class PatientHistoryMapper implements
			RowMapper<PatientHistory> {

		public PatientHistory mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PatientHistory history = new PatientHistory();
			history.setPatientHistoryId(rs.getInt("patientHistoryId"));
			history.setPatientCardId(rs.getInt("patientCardId"));
			history.setDoctorId(rs.getInt("doctorId"));
			history.setDiagnosisName(rs.getString("diagnosisName"));
			history.setDiagnosisDate(rs.getDate("diagnosisDate"));
			history.setDiagnosisComment(rs.getString("diagnosisComment"));
			return history;
		}

	}
}
