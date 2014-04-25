package com.epam.springTest.domain;

public class DoctorTreatmentPrice {
	private int doctorTreatmentPriceId;
	private int doctorId;
	private int treatmentId;
	private float cost;

	public DoctorTreatmentPrice() {
	}

	public int getDoctorTreatmentPriceId() {
		return doctorTreatmentPriceId;
	}

	public void setDoctorTreatmentPriceId(int doctorTreatmentPriceId) {
		this.doctorTreatmentPriceId = doctorTreatmentPriceId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + doctorId;
		result = prime * result + doctorTreatmentPriceId;
		result = prime * result + treatmentId;
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
		DoctorTreatmentPrice other = (DoctorTreatmentPrice) obj;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (doctorTreatmentPriceId != other.doctorTreatmentPriceId)
			return false;
		if (treatmentId != other.treatmentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DoctorTreatmentPrice [doctorTreatmentPriceId="
				+ doctorTreatmentPriceId + ", doctorId=" + doctorId
				+ ", treatmentId=" + treatmentId + ", cost=" + cost + "]";
	}

}
