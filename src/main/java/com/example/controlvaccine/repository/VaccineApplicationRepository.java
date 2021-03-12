package com.example.controlvaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.controlvaccine.entities.VaccineApplication;

@Repository
public interface VaccineApplicationRepository extends JpaRepository<VaccineApplication, Long>{

}
