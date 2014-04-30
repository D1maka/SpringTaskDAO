CREATE TABLE User(
	userId IDENTITY,
	firstName varchar(30),
	lastName varchar(30), 
	patronymic varchar(30), 
	userTypeId int
);

CREATE TABLE PatientCard(
	patientCardId IDENTITY,
	firstName varchar(30),
	lastName varchar(30), 
	patronymic varchar(30), 
	dateOfBirth date
);

CREATE TABLE PatientHistory(
	patientHistoryId IDENTITY,
	patientCardId int,
	doctorId int, 
	diagnosisName varchar(30), 
	diagnosisComment varchar(90), 
	diagnosisDate date
);
