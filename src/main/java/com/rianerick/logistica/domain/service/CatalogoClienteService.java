package com.rianerick.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rianerick.logistica.api.exceptionhandler.NegocioException;
import com.rianerick.logistica.domain.model.Cliente;
import com.rianerick.logistica.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
	//ver se tem um email existente no banco 
	boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
		           .stream()
		           .anyMatch(clienteExistentente -> !clienteExistentente.equals(cliente));
	
	if(emailEmUso) {
		throw new NegocioException("Ja existe um cliente cadastrado com este email.");
	}
		return clienteRepository.save(cliente);
}
	@Transactional
	public void deletar (Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
