package com.epam.springTest.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springTest.domain.PatientHistory;

public class PatientHistoryDaoJDBCTest extends DaoTestTemplate{
	
	@Autowired
	private PatientHistoryDao patientHistoryDao;

	@Before
	public void setUp() throws Exception {
		jdbcTemplate.execute("truncate table PatientHistory");
		jdbcTemplate.execute("ALTER TABLE PatientHistory ALTER COLUMN patientHistoryId RESTART WITH 1");
	}

	@Test
	public void addUserToDbSuccessful() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		
		boolean actualResult = patientHistoryDao.create(history);
		
		assertTrue(actualResult);
	}
	
	@Test
	public void selectUserByCorrectIdSuccess() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		
		patientHistoryDao.create(history);
		int correctId = 1;
		PatientHistory selectedHistory = patientHistoryDao.getById(correctId);
		
		assertNotNull(selectedHistory);
	}
	
	@Test
	public void selectUserByUncorrectIdFail() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		
		patientHistoryDao.create(history);
		int uncorrectId = 2;
		PatientHistory selectedHistory = patientHistoryDao.getById(uncorrectId);
		
		assertNull(selectedHistory);
	}
	
	@Test
	public void deleteInsertedUserSuccess() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		history.setPatientHistoryId(1);
		patientHistoryDao.create(history);
		
		boolean result = patientHistoryDao.delete(history);
		assertTrue(result);
	}
	
	@Test
	public void deleteNotExistingUserFail() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		history.setPatientHistoryId(1);
		
		boolean result = patientHistoryDao.delete(history);
		assertFalse(result);
	}
	
	@Test
	public void updateUserToDbSuccessful() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		PatientHistory newHistory = new PatientHistory();
		newHistory.setPatientCardId(1);
		newHistory.setDoctorId(1);
		newHistory.setDiagnosisName("test");
		newHistory.setDiagnosisDate(new Date());
		newHistory.setDiagnosisComment("test");
		newHistory.setPatientHistoryId(1);
		
		boolean result = patientHistoryDao.update(newHistory);
		
		assertTrue(result);
	}
	
	@Test
	public void updateUserWithWrongIdFail() {
		PatientHistory history = new PatientHistory();
		history.setPatientCardId(1);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		PatientHistory newHistory = new PatientHistory();
		newHistory.setPatientCardId(1);
		newHistory.setDoctorId(1);
		newHistory.setDiagnosisName("test");
		newHistory.setDiagnosisDate(new Date());
		newHistory.setDiagnosisComment("test");
		newHistory.setPatientHistoryId(2);
		
		boolean result = patientHistoryDao.update(newHistory);
		
		assertFalse(result);
	}
	
	@Test
	public void getPatientHistoryCorrectPatientIdSuccess() {
		PatientHistory history = new PatientHistory();
		int correctPatientId = 1;
		history.setPatientCardId(correctPatientId);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		
		List<PatientHistory> histories = patientHistoryDao.getPatientHistory(correctPatientId);
		
		assertEquals(histories.get(0), history);
	}
	
	@Test
	public void getPatientHistoryNotCorrectPatientIdFail() {
		PatientHistory history = new PatientHistory();
		int notCorrectPatientId = 2;
		history.setPatientCardId(notCorrectPatientId);
		history.setDoctorId(1);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		
		List<PatientHistory> histories = patientHistoryDao.getPatientHistory(notCorrectPatientId);
		
		assertNotEquals(histories.get(0), history);
	}
}
