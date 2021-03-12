package com.example.controlvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controlvaccine.entities.VaccineApplication;
import com.example.controlvaccine.repository.VaccineApplicationRepository;

@Service
public class VaccineApplicationManagementService {

	@Autowired
	private VaccineApplicationRepository vaccineApplicationRepository;
	
	public VaccineApplication create(VaccineApplication vaccineApplication) {
		return vaccineApplicationRepository.save(vaccineApplication);
	}
}
