package com.example.curso.resources.exceptions;

import java.time.Instant;

import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.curso.services.exceptions.ResourceNotFoundException;

//vai interceptar as excecoes que acontecerem
//para que essa classe possa implementar um possivel tratamento
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
			HttpServletRequest request) {
		String erro = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
