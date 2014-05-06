package com.epam.springTest.repository.patientCard;

import com.epam.springTest.domain.patientCard.PatientCard;

public interface PatientCardDao {
	public boolean create(PatientCard card);
	public boolean update(PatientCard card);
	public boolean delete(PatientCard card);
	public PatientCard getById(Integer id);
	public PatientCard getByPatientHistoryId(Integer patientHistoryId);
}
