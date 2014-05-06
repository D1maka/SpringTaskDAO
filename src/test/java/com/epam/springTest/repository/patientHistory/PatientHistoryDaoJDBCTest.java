package com.epam.springTest.repository.patientHistory;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springTest.domain.patientCard.PatientCard;
import com.epam.springTest.domain.patientHistory.PatientHistory;
import com.epam.springTest.domain.user.User;
import com.epam.springTest.repository.DaoTestTemplate;
import com.epam.springTest.repository.patientHistory.PatientHistoryDao;

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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");
		
		boolean actualResult = patientHistoryDao.create(history);
		
		assertTrue(actualResult);
	}
	
	@Test
	public void selectUserByCorrectIdSuccess() {
		PatientHistory history = new PatientHistory();
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		PatientHistory newHistory = new PatientHistory();
		newHistory.setPatientCard(patientCard);
		newHistory.setDoctor(doctor);
		newHistory.setDiagnosisName("test1");
		newHistory.setDiagnosisDate(new Date());
		newHistory.setDiagnosisComment("test1");
		newHistory.setPatientHistoryId(1);
		
		boolean result = patientHistoryDao.update(newHistory);
		
		assertTrue(result);
	}
	
	@Test
	public void updateUserWithWrongIdFail() {
		PatientHistory history = new PatientHistory();
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		PatientHistory newHistory = new PatientHistory();
		newHistory.setPatientCard(patientCard);
		newHistory.setDoctor(doctor);
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
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		history.setPatientCard(null);
		history.setDoctor(null);
		
		List<PatientHistory> histories = patientHistoryDao.getPatientHistory(correctPatientId);
		
		assertNotNull(histories);
	}
	
	@Test
	public void getPatientHistoryNotCorrectPatientIdFail() {
		PatientHistory history = new PatientHistory();
		int notCorrectPatientId = 2;
		PatientCard patientCard = new PatientCard();
		patientCard.setPatientCardId(1);
		history.setPatientCard(patientCard);
		User doctor = new User();
		doctor.setUserId(1);
		history.setDoctor(doctor);
		history.setDiagnosisName("test");
		history.setDiagnosisDate(new Date());
		history.setDiagnosisComment("test");		
		patientHistoryDao.create(history);
		
		List<PatientHistory> histories = patientHistoryDao.getPatientHistory(notCorrectPatientId);
		int expectedSize = 0;
		boolean expectedResult = histories.size() == expectedSize;
		
		assertTrue(expectedResult);
	}
}
