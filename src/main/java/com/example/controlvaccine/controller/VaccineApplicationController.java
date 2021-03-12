package com.example.controlvaccine.controller;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlvaccine.entities.VaccineApplication;
import com.example.controlvaccine.repository.VaccineApplicationRepository;
import com.example.controlvaccine.service.VaccineApplicationManagementService;

@RestController
@RequestMapping("/vaccine-application")
public class VaccineApplicationController {

	@Autowired
	private VaccineApplicationManagementService vaccineApplicationManagement;
	
	@Autowired
	private VaccineApplicationRepository vaccineApplicationRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VaccineApplication create(@Valid @RequestBody VaccineApplication vaccineApplication) {
		return vaccineApplicationManagement.create(vaccineApplication);
	}
	
	@GetMapping
	public List<VaccineApplication> list() {
		return vaccineApplicationRepository.findAll();
	}
	
	@GetMapping("/{vaccineApplicationId}")
	public ResponseEntity<VaccineApplication> search(@PathVariable Long vaccineApplicationId) {
		Optional<VaccineApplication> vaccineAppication = vaccineApplicationRepository.findById(vaccineApplicationId);
		
		if (vaccineAppication.isPresent()) {
			return ResponseEntity.ok(vaccineAppication.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
