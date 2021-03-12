package com.example.controlvaccine.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class VaccineApplication{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "vaccinename")
	private String vaccineName;
	
	@NotBlank
	@Column(name = "emailusers")
	private String emailUsers;
	
	@NotNull
	@Column(name = "applicationdate")
	private Date applicationDate;
	
	public VaccineApplication() {
	}

	public VaccineApplication(Long id, String vaccineName, String emailUsers, Date applicationDate) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.emailUsers = emailUsers;
		this.applicationDate = applicationDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getEmailUsers() {
		return emailUsers;
	}

	public void setEmailUsers(String emailUsers) {
		this.emailUsers = emailUsers;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccineApplication other = (VaccineApplication) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
