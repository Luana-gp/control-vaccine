package com.example.controlvaccine.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlvaccine.entities.Users;
import com.example.controlvaccine.repository.UsersRepository;
import com.example.controlvaccine.service.UsersRegistrationService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRegistrationService usersRegistration;
	
	@GetMapping
	public List<Users> listar() {
		return usersRepository.findAll();
	}
	
	@GetMapping("/{usersId}")
	public ResponseEntity<Users> find(@PathVariable Long usersId) {
		Optional<Users> users = usersRepository.findById(usersId);
		
		if (users.isPresent()) {
			return ResponseEntity.ok(users.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users add(@Valid @RequestBody Users users) {
		return usersRegistration.save(users);
	}
	
	@PutMapping("/{usersId}")
	public ResponseEntity<Users> update(@Valid @PathVariable Long usersId,
			@RequestBody Users users) {
		
		if (!usersRepository.existsById(usersId)) {
			return ResponseEntity.notFound().build();
		}
		
		users.setId(usersId);
		users = usersRegistration.save(users);
		
		return ResponseEntity.ok(users);
	}
	
	@DeleteMapping("/{usersId}")
	public ResponseEntity<Void> remover(@PathVariable Long usersId) {
		if (!usersRepository.existsById(usersId)) {
			return ResponseEntity.notFound().build();
		}
		
		usersRegistration.delete(usersId);
		
		return ResponseEntity.noContent().build();
	}
}
