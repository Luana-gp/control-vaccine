package com.example.controlvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controlvaccine.entities.Users;
import com.example.controlvaccine.exception.BusinessException;
import com.example.controlvaccine.repository.UsersRepository;

@Service
public class UsersRegistrationService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Users save(Users users) {
		Users usersExisting = usersRepository.findByEmail(users.getEmail());
		
		if (usersExisting != null && !usersExisting.equals(users)) {
			throw new BusinessException("There is already a customer registered with this email");
		}
		
		usersExisting = usersRepository.findByCpf(users.getCpf());
		
		if (usersExisting != null && !usersExisting.equals(users)) {
			throw new BusinessException("There is already a customer registered with this cpf");
		}
		
		return usersRepository.save(users);
	}
	
	public void delete(Long usersId) {
		usersRepository.deleteById(usersId);
	}
}
