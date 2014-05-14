package com.epam.springTest.domain.patientCard;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "PatientCard")
public class PatientCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientCardId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="patronymic")
	private String patronymic;
	
	@Column(name="dateofbirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public PatientCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatientCardId() {
		return patientCardId;
	}

	public void setPatientCardId(Integer patientCardId) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
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
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
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
				+ patronymic + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
