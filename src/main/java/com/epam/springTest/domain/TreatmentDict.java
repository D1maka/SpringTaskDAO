package com.epam.springTest.domain;

public class TreatmentDict {
	private int treatmentId;
	private String treatmentName;

	public TreatmentDict() {
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + treatmentId;
		result = prime * result
				+ ((treatmentName == null) ? 0 : treatmentName.hashCode());
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
		TreatmentDict other = (TreatmentDict) obj;
		if (treatmentId != other.treatmentId)
			return false;
		if (treatmentName == null) {
			if (other.treatmentName != null)
				return false;
		} else if (!treatmentName.equals(other.treatmentName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TreatmentDict [treatmentId=" + treatmentId + ", treatmentName="
				+ treatmentName + "]";
	}

}
