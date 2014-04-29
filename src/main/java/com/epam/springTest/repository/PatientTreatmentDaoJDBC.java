package com.epam.springTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.springTest.domain.PatientTreatment;

@Repository("patientTreatmentDao")
public class PatientTreatmentDaoJDBC implements PatientTreatmentDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PatientTreatmentDaoJDBC(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(PatientTreatment user) {
		// TODO Auto-generated method stub

	}

	public void update(PatientTreatment user) {
		// TODO Auto-generated method stub

	}

	public void delete(PatientTreatment user) {
		// TODO Auto-generated method stub

	}

	public PatientTreatment getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
