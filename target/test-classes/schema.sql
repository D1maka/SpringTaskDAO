CREATE TABLE User(
	userId IDENTITY,
	firstName varchar(30),
	lastName varchar(30), 
	patronymic varchar(30), 
	userTypeId int
);

CREATE TABLE PatientCard(
	patientCardOd IDENTITY,
	firstName varchar(30),
	lastName varchar(30), 
	patronymic varchar(30), 
	dateOfBirth date
)