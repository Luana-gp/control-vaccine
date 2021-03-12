package com.example.controlvaccine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.controlvaccine.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByName(String name);
	List<Users> findByNameContaining(String name);
	Users findByEmail(String email);
	Users findByCpf(String cpf);
}
