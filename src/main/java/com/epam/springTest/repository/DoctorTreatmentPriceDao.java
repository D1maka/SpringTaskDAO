package com.epam.springTest.repository;

import com.epam.springTest.domain.DoctorTreatmentPrice;

public interface DoctorTreatmentPriceDao {
	public void create(DoctorTreatmentPrice user);
	public void update(DoctorTreatmentPrice user);
	public void delete(DoctorTreatmentPrice user);
	public DoctorTreatmentPrice getById(Integer id);
}
