package com.rianerick.logistica.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler<Obeject> extends ResponseEntityExceptionHandler {
 
	
	//Tratando as Exececoes de erro
	@Override
	protected ResponseEntity <Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Poblema.Campo> campos = new ArrayList<>();
		
		
	   for(ObjectError error : ex.getBindingResult().getAllErrors()) {
		   
		    String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			
		   campos.add(new Poblema.Campo(nome , mensagem));
		   
	   }
		
		Poblema poblema = new Poblema();
		poblema.setStatus(status.value());
		poblema.setDataHora(LocalDateTime.now());
		poblema.setTitulo("Um Ou Mais Campos Estao Invalidos");
		poblema.setCampos(campos);
		
		return handleExceptionInternal(ex, poblema, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		
		Poblema poblema = new Poblema();
		poblema.setStatus(status.value());
		poblema.setDataHora(LocalDateTime.now());
		poblema.setTitulo(ex.getMessage());
		
		return handleExceptionInternal(null, poblema, new HttpHeaders(), status,request);
	}
	
}
