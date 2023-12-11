package com.se3test.business;

import java.util.List;
import java.util.ArrayList; // used for this.enrolments

public class Student{

	private String studentNumber;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private List<Module> modules;
	private List<Enrolment> enrolments;
	
	
	public Student(String studentNumber, String firstName, String lastName,
			String emailAddress, List<Module> modules) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.modules = modules;
		this.enrolments = new ArrayList<>(); // enrolments is instantiated here otherwise enrol() will cause a nullpointerexception
	}

	public void enrol(Module module) {
		// a new enrolment object is created and added to the enrolments list
		Enrolment e = new Enrolment(this, module);
		this.addEnrolment(e);
	}
	
	public void addEnrolment(Enrolment e) {
		enrolments.add(e);
	}

	public  String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber( String studentNumber) {
		this.studentNumber = studentNumber;
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

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}
	
}
