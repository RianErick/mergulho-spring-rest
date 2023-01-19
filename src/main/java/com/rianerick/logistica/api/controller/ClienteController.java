package com.rianerick.logistica.api.controller;
import java.util.List;
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
import com.rianerick.logistica.domain.model.Cliente;
import com.rianerick.logistica.domain.repository.ClienteRepository;
import com.rianerick.logistica.domain.service.CatalogoClienteService;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CatalogoClienteService catalogoClienteService;
	
	@GetMapping("/listar")
	public List <Cliente> listarClientes() {
        return clienteRepository.findAll();
	}
	
	
	@GetMapping("/nomeCliente")
	public List <Cliente> listarNomes(){
		return clienteRepository.findByNomeContaining("R");
	}
	
	
	@GetMapping("/{clienteId}")
	 public ResponseEntity <Cliente> buscar( @PathVariable Long clienteId) {
         return clienteRepository.findById(clienteId)
        		 .map(cliente -> ResponseEntity.ok(cliente))
        		 .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar (@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
	
	
	@PutMapping("/{clienteId}")
	public ResponseEntity <Cliente> atualizar(@PathVariable Long clienteId,
		@Valid @RequestBody Cliente cliente ){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
	    cliente = catalogoClienteService.salvar(cliente);

	    return ResponseEntity.ok(cliente);
	}
	 
	@DeleteMapping("/{clienteId}")
	public ResponseEntity <Void> remover(@PathVariable Long clienteId){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		catalogoClienteService.deletar(clienteId);
		
		return ResponseEntity.noContent().build();
	}

}  











