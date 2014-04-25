package com.epam.springTest.domain;

import java.util.Date;

public class PatientHistory {
	private int patientHistoryId;
	private int patientCardId;
	private int doctorId;
	private String diagnosisName;
	private String diagnosisComment;
	private Date diagnosisDate;

	public PatientHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(int patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	public int getPatientCardId() {
		return patientCardId;
	}

	public void setPatientCardId(int patientCardId) {
		this.patientCardId = patientCardId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getDiagnosisComment() {
		return diagnosisComment;
	}

	public void setDiagnosisComment(String diagnosisComment) {
		this.diagnosisComment = diagnosisComment;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((diagnosisComment == null) ? 0 : diagnosisComment.hashCode());
		result = prime * result
				+ ((diagnosisDate == null) ? 0 : diagnosisDate.hashCode());
		result = prime * result
				+ ((diagnosisName == null) ? 0 : diagnosisName.hashCode());
		result = prime * result + doctorId;
		result = prime * result + patientCardId;
		result = prime * result + patientHistoryId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientHistory other = (PatientHistory) obj;
		if (diagnosisComment == null) {
			if (other.diagnosisComment != null)
				return false;
		} else if (!diagnosisComment.equals(other.diagnosisComment))
			return false;
		if (diagnosisDate == null) {
			if (other.diagnosisDate != null)
				return false;
		} else if (!diagnosisDate.equals(other.diagnosisDate))
			return false;
		if (diagnosisName == null) {
			if (other.diagnosisName != null)
				return false;
		} else if (!diagnosisName.equals(other.diagnosisName))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (patientCardId != other.patientCardId)
			return false;
		if (patientHistoryId != other.patientHistoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientHistory [patientHistoryId=" + patientHistoryId
				+ ", patientCardId=" + patientCardId + ", doctorId=" + doctorId
				+ ", diagnosisName=" + diagnosisName + ", diagnosisComment="
				+ diagnosisComment + ", diagnosisDate=" + diagnosisDate + "]";
	}

}
