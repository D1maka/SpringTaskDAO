package com.epam.springTest.domain.patientHistory;

import java.util.Date;

import com.epam.springTest.domain.patientCard.PatientCard;
import com.epam.springTest.domain.user.User;

public class PatientHistory {
	private Integer patientHistoryId;
	private PatientCard patientCard;
	private User doctor;
	private String diagnosisName;
	private String diagnosisComment;
	private Date diagnosisDate;

	public PatientHistory() {
	}

	public Integer getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(Integer patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	public PatientCard getPatientCard() {
		return patientCard;
	}

	public void setPatientCard(PatientCard patientCard) {
		this.patientCard = patientCard;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
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
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result
				+ ((patientCard == null) ? 0 : patientCard.hashCode());
		result = prime
				* result
				+ ((patientHistoryId == null) ? 0 : patientHistoryId.hashCode());
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
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (patientCard == null) {
			if (other.patientCard != null)
				return false;
		} else if (!patientCard.equals(other.patientCard))
			return false;
		if (patientHistoryId == null) {
			if (other.patientHistoryId != null)
				return false;
		} else if (!patientHistoryId.equals(other.patientHistoryId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientHistory [patientHistoryId=" + patientHistoryId
				+ ", patientCard=" + patientCard + ", doctor=" + doctor
				+ ", diagnosisName=" + diagnosisName + ", diagnosisComment="
				+ diagnosisComment + ", diagnosisDate=" + diagnosisDate + "]";
	}

	
	

}
