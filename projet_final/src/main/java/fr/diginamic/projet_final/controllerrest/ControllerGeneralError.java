package fr.diginamic.projet_final.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.diginamic.projet_final.exception.AbsenceNotFoundException;
import fr.diginamic.projet_final.exception.CollaborateurNotFoundException;
import fr.diginamic.projet_final.exception.JourFerieNotFoundException;
import fr.diginamic.projet_final.exception.RoleNotFoundException;
import fr.diginamic.projet_final.exception.ServiceNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {

	public ControllerGeneralError() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(value = { AbsenceNotFoundException.class })
	public ResponseEntity<String> onErrorAbsence(AbsenceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" + ex.getMessage());
	}

	@ExceptionHandler(value = { CollaborateurNotFoundException.class })
	public ResponseEntity<String> onErrorCollaborateur(CollaborateurNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CollaborateurError :" + ex.getMessage());
	}

	@ExceptionHandler(value = { JourFerieNotFoundException.class })
	public ResponseEntity<String> onErrorJourFerie(JourFerieNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" + ex.getMessage());
	}

	@ExceptionHandler(value = { RoleNotFoundException.class })
	public ResponseEntity<String> onErrorRole(RoleNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" + ex.getMessage());
	}

	@ExceptionHandler(value = { ServiceNotFoundException.class })
	public ResponseEntity<String> onErrorService(ServiceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AbsenceError :" + ex.getMessage());
	}

}
