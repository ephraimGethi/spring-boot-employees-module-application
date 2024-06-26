package net.ephraim.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column(name = "first_name")
private String firstName;
	@Column(name = "last_name")
private String lastName;
	@Column(name = "email_id")
private String EmailId;

public Employee(Long id, String firstName, String lastName, String emailId) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	EmailId = emailId;
}

public Employee() {
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}


}
