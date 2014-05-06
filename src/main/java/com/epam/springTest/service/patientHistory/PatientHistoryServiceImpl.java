package com.epam.springTest.service.patientHistory;

import java.util.ArrayList;
import java.util.List;

import com.epam.springTest.domain.patientCard.PatientCard;
import com.epam.springTest.domain.patientHistory.PatientHistory;
import com.epam.springTest.domain.user.User;
import com.epam.springTest.repository.patientCard.PatientCardDao;
import com.epam.springTest.repository.patientHistory.PatientHistoryDao;
import com.epam.springTest.repository.user.UserDao;

public class PatientHistoryServiceImpl implements PatientHistoryService {
	
	private PatientCardDao patientCardDao;
	private UserDao userDao;
	private PatientHistoryDao patientHistoryDao;
	
	public PatientHistoryServiceImpl() {
		
	}

	public List<PatientHistory> getPatientHistory(Integer patientId) {
		List<PatientHistory> histories = new ArrayList<PatientHistory>();
		histories = patientHistoryDao.getPatientHistory(patientId);
		PatientCard patientCard = patientCardDao.getById(patientId);
		for(PatientHistory history: histories) {
			User doctor = userDao.getDoctorByPatientHistoryId(history.getPatientHistoryId());
			history.setDoctor(doctor);		
			history.setPatientCard(patientCard);
		}
		return null;
	}

	public void setPatientCardDao(PatientCardDao patientCardDao) {
		this.patientCardDao = patientCardDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPatientHistoryDao(PatientHistoryDao patientHistoryDao) {
		this.patientHistoryDao = patientHistoryDao;
	}

	
}
