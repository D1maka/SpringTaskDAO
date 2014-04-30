package com.epam.springTest.repository;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springTest.domain.PatientCard;

public class PatientCardDaoJDBCTest extends DaoTestTemplate{
	
	@Autowired
	private PatientCardDao patientCardDao;

	@Before
	public void setUp() throws Exception {
		jdbcTemplate.execute("truncate table PatientCard");
		jdbcTemplate.execute("ALTER TABLE PatientCard ALTER COLUMN patientCardId RESTART WITH 1");
	}

	@Test
	public void addCardToDbSuccess() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		
		boolean result = patientCardDao.create(card);
		
		assertTrue(result);
	}

	@Test
	public void deleteExistingCardSuccess() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		patientCardDao.create(card);
		
		boolean result = patientCardDao.delete(card);
		
		assertTrue(result);
	}
	
	@Test
	public void deleteNotExistingCardFail() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		
		boolean result = patientCardDao.delete(card);
		
		assertFalse(result);
	}
	
	@Test
	public void updateExistingCardSuccess() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		patientCardDao.create(card);
		
		PatientCard newCard = new PatientCard();
		newCard.setDateOfBirth(new Date());
		newCard.setFirstName("test1");
		newCard.setLastName("test1");
		newCard.setPatronymic("test1");
		newCard.setPatientCardId(1);
		
		boolean result = patientCardDao.update(newCard);
		
		assertTrue(result);
	}
	
	@Test
	public void updateNotExistingCardFail() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		patientCardDao.create(card);
		
		PatientCard newCard = new PatientCard();
		newCard.setDateOfBirth(new Date());
		newCard.setFirstName("test1");
		newCard.setLastName("test1");
		newCard.setPatronymic("test1");
		newCard.setPatientCardId(2);
		
		boolean result = patientCardDao.update(newCard);
		
		assertFalse(result);
	}
	
	@Test
	public void getByCorrectIdSuccess() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		patientCardDao.create(card);
		int correctId = 1;
		
		PatientCard selectedCard = patientCardDao.getById(correctId);
		
		assertNotNull(selectedCard);
	}
	
	@Test
	public void getByNotCorrectIdSuccess() {
		PatientCard card = new PatientCard();
		card.setDateOfBirth(new Date());
		card.setFirstName("test");
		card.setLastName("test");
		card.setPatronymic("test");
		card.setPatientCardId(1);
		patientCardDao.create(card);
		int notCorrectId = 2;
		
		PatientCard selectedCard = patientCardDao.getById(notCorrectId);
		
		assertNull(selectedCard);
	}
}
