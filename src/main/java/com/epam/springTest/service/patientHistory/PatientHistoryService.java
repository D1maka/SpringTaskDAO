package com.epam.springTest.service.patientHistory;

import java.util.List;

import com.epam.springTest.domain.patientHistory.PatientHistory;

public interface PatientHistoryService {
	List<PatientHistory> getPatientHistory(Integer patientId);
}
