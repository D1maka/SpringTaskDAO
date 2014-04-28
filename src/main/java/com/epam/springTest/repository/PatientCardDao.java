package com.epam.springTest.repository;

import com.epam.springTest.domain.PatientCard;

public interface PatientCardDao {
	public boolean create(PatientCard card);
	public boolean update(PatientCard card);
	public boolean delete(PatientCard card);
	public PatientCard getById(Integer id);
}
