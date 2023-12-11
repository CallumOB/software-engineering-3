CREATE TABLE module (
  CODE varchar(10) NOT NULL,
  TITLE varchar(50) NOT NULL,
  PRIMARY KEY  (CODE)
);
  
CREATE TABLE student (
  NUMBER varchar(10) NOT NULL,
  FIRST_NAME varchar(50) NOT NULL,
  LAST_NAME varchar(50) NOT NULL,
  EMAIL varchar(100) NOT NULL,  
  PRIMARY KEY  (NUMBER)
);
  
CREATE TABLE enrolment (
  DATE_ENROLLED date NOT NULL,
  MODULE_CODE varchar(10) NOT NULL,
  STUDENT_NUMBER varchar(10) NOT NULL,
  PRIMARY KEY  (MODULE_CODE, STUDENT_NUMBER),
  FOREIGN KEY (MODULE_CODE) REFERENCES module(CODE),
  FOREIGN KEY (STUDENT_NUMBER) REFERENCES student(NUMBER)
);

INSERT INTO module VALUES ("CMPU3038", "Software Engineering III"),
						  ("SENG9810", "Software Design");
			  
INSERT INTO student VALUES ("Z01234567", "John", "Smith", "smithj@email.com");		

INSERT INTO enrolment VALUES ("2023-11-29", "CMPU3038", "Z01234567"),
							 ("2023-11-29", "SENG9810", "Z01234567");
			
		