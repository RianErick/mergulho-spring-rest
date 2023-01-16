package com.rianerick.logistica.api.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rianerick.logistica.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List <Cliente> listar() {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Rian Erick Menezes Silva");
		cliente1.setEmail("rianzx26@gmail.com");
		cliente1.setTelefone("85 9 8822-9471");
		
		cliente2.setId(2L);
		cliente2.setNome("Ayko Erick Menezes Silva");
		cliente2.setEmail("aykozx26@gmail.com");
		cliente2.setTelefone("85 9 8822-9472");
	
		return Arrays.asList(cliente1,cliente2);
		
		
	}
	
}
