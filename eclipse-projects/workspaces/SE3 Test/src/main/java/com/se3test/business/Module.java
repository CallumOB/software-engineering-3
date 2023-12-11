package com.se3test.business;

import java.util.List;

public class Module {

	private String moduleCode;
	private String moduleTitle;
	private List<Enrolment> enrolments;
	
	public Module (String code, String title) {
		this.moduleCode = code;
		this.moduleTitle = title;
	}
	
	public String getModuleCode() {
		return moduleCode;
	}
	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleTitle() {
		return moduleTitle;
	}
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	
}
