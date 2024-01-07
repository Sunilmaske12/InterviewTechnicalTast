package com.oakland.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "name should not be null")
	private String name;
	
	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dateOfBirth;
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of Birth cannot be null")
    private Date dateOfBirth;
	
	@NotBlank(message = "address must not be null")
	private String address;

	@NotNull(message = "gender must not be null")
	private String gender;
	
	@NotBlank(message = "city should not be null")
	private String city;
	
	@NotBlank(message = "state should not be null")
	private String state;

	@NotBlank(message = "login-id should not be null")
	@Size(min = 8, message = "login-id length should be atleast 8")
	private String loginId;
	
	@NotBlank(message = "password should not be null")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{6,20})", message = "Your password is weak")
	private String password;
	
	
	//getters and setter	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String getDateOfBirth() { DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy"); String formattedDate=null; //
	 * Format the LocalDate using the formatter if(dateOfBirth!=null) {
	 * formattedDate = dateOfBirth.format(formatter); } return formattedDate; }
	 * 
	 * public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth =
	 * dateOfBirth; }
	 */

	public String getAddress() {
		return address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
