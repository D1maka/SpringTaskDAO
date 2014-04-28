package com.epam.springTest.repository;

import com.epam.springTest.domain.PatientTreatment;

public interface PatientTreatmentDao {
	public void create(PatientTreatment user);
	public void update(PatientTreatment user);
	public void delete(PatientTreatment user);
	public PatientTreatment getById(Integer id);
}
