package com.training.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student11")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long stuId;

public long getStuId() {
	return stuId;
}
public void setStuId(long stuId) {
	this.stuId = stuId;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
private String firstName,lastName;
private int age;


}
