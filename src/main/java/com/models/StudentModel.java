package com.models;

public class StudentModel {
	String name;
	int age;
	int classNumber;
	char section;
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
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public StudentModel(String name, int age, int classNumber, char section) {
		super();
		this.name = name;
		this.age = age;
		this.classNumber = classNumber;
		this.section = section;
	}
	
}
