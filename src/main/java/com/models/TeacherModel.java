package com.models;

public class TeacherModel {
	private String name;
	private int age;
	private String subjectName;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TeacherModel(String name, int age, String subjectName, int id) {
		super();
		this.name = name;
		this.age = age;
		this.subjectName = subjectName;
		this.id = id;
	}
}
