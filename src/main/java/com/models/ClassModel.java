package com.models;

public class ClassModel {
	private String timinings;
	private String classTeacher;
	private int classNumber;
	private String subjectName;
	public String getTiminings() {
		return timinings;
	}

	public void setTiminings(String timinings) {
		this.timinings = timinings;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public ClassModel(String timinings, String classTeacher, int classNumber, String subjectName) {
		super();
		this.timinings = timinings;
		this.classTeacher = classTeacher;
		this.classNumber = classNumber;
		this.subjectName = subjectName;
	}
}
