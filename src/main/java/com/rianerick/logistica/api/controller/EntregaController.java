package com.rianerick.logistica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rianerick.logistica.domain.model.Entrega;
import com.rianerick.logistica.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
     
	
	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //responde um 201 quando for sucesso !
	public Entrega solicitar(@RequestBody Entrega entrega) { //ResquestBody trasforma obj json no tipo solicitado
		return solicitacaoEntregaService.solicitar(entrega);
	}
	

}
