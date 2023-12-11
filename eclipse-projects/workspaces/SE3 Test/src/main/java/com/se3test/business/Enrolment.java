package com.se3test.business;

import java.time.LocalDate;

public class Enrolment {

	private LocalDate enrolmentDate;
	private Student student;
	private Module module;
	
	public Enrolment(Student student, Module module) {
		
		this.student = student;
		this.module = module;
		
		enrolmentDate = LocalDate.now();
	}	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public LocalDate getEnrolmentDate() {
		return enrolmentDate;
	}
	public void setEnrolmentDate(LocalDate enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}
	
}
