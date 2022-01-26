package fr.diginamic.projet_final.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.diginamic.projet_final.exception.CollaborateurNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {

	public ControllerGeneralError() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> onError(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Other Error :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {CollaborateurNotFoundException.class})
	public ResponseEntity<String> onErrorClient(CollaborateurNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CollaborateurError :" +ex.getMessage());
	}
	
	
}
