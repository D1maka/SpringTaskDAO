package com.epam.springTest.domain;

public class PatientCard {
	private int patientCardId;
	private String firstName;
	private String lastName;
	private String patronymic;

	public PatientCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatientCardId() {
		return patientCardId;
	}

	public void setPatientCardId(int patientCardId) {
		this.patientCardId = patientCardId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + patientCardId;
		result = prime * result
				+ ((patronymic == null) ? 0 : patronymic.hashCode());
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
		PatientCard other = (PatientCard) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (patientCardId != other.patientCardId)
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientCard [patientCardId=" + patientCardId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", patronymic="
				+ patronymic + "]";
	}

}
