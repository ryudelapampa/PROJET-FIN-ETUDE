package fr.diginamic.projet_final.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.diginamic.projet_final.exception.AbsenceNotFoundException;
import fr.diginamic.projet_final.exception.CollaborateurNotFoundException;
import fr.diginamic.projet_final.exception.JourFerieNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {

	public ControllerGeneralError() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> onError(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Other Error :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {AbsenceNotFoundException.class})
	public ResponseEntity<String> onErrorAbsence(AbsenceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {JourFerieNotFoundException.class})
	public ResponseEntity<String> onErrorJourFerie(JourFerieNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {CollaborateurNotFoundException.class})
	public ResponseEntity<String> onErrorClient(CollaborateurNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CollaborateurError :" +ex.getMessage());
	}
	
	
}
