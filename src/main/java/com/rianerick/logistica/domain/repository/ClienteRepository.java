package com.rianerick.logistica.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rianerick.logistica.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	

	
	List <Cliente> findByNomeContaining(String nome); 
	
	Optional<Cliente> findByEmail(String email);
	
	
} 
