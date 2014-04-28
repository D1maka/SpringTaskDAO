package com.epam.springTest.repository;

import com.epam.springTest.domain.PatientHistory;

public interface PatientHistoryDao {
	public void create(PatientHistory user);
	public void update(PatientHistory user);
	public void delete(PatientHistory user);
	public PatientHistory getById(Integer id);
}
