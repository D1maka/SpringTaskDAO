package com.epam.springTest.repository;

import java.util.List;

import com.epam.springTest.domain.PatientHistory;

public interface PatientHistoryDao {
	public boolean create(PatientHistory user);
	public boolean update(PatientHistory user);
	public boolean delete(PatientHistory user);
	public PatientHistory getById(Integer id);
	public List<PatientHistory> getPatientHistory(Integer patientId);
}
