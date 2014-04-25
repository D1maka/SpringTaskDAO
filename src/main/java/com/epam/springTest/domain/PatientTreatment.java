package com.epam.springTest.domain;

public class PatientTreatment {
	private int patientTreatmentId;
	private int patientHistoryId;
	private int doctorTreatmentId;
	private String treatmentCommentary;

	public PatientTreatment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatientTreatmentId() {
		return patientTreatmentId;
	}

	public void setPatientTreatmentId(int patientTreatmentId) {
		this.patientTreatmentId = patientTreatmentId;
	}

	public int getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(int patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	public int getDoctorTreatmentId() {
		return doctorTreatmentId;
	}

	public void setDoctorTreatmentId(int doctorTreatmentId) {
		this.doctorTreatmentId = doctorTreatmentId;
	}

	public String getTreatmentCommentary() {
		return treatmentCommentary;
	}

	public void setTreatmentCommentary(String treatmentCommentary) {
		this.treatmentCommentary = treatmentCommentary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doctorTreatmentId;
		result = prime * result + patientHistoryId;
		result = prime * result + patientTreatmentId;
		result = prime
				* result
				+ ((treatmentCommentary == null) ? 0 : treatmentCommentary
						.hashCode());
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
		PatientTreatment other = (PatientTreatment) obj;
		if (doctorTreatmentId != other.doctorTreatmentId)
			return false;
		if (patientHistoryId != other.patientHistoryId)
			return false;
		if (patientTreatmentId != other.patientTreatmentId)
			return false;
		if (treatmentCommentary == null) {
			if (other.treatmentCommentary != null)
				return false;
		} else if (!treatmentCommentary.equals(other.treatmentCommentary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientTreatment [patientTreatmentId=" + patientTreatmentId
				+ ", patientHistoryId=" + patientHistoryId
				+ ", doctorTreatmentId=" + doctorTreatmentId
				+ ", treatmentCommentary=" + treatmentCommentary + "]";
	}

}
