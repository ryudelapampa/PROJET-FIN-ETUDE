package fr.diginamic.projet_final.controllerrest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.diginamic.projet_final.exception.AbsenceNotFoundException;
import fr.diginamic.projet_final.model.Absence;
import fr.diginamic.projet_final.repository.iCrudAbsence;

@RestController
@CrossOrigin
@RequestMapping("api/absence")
public class ControllerAbsence {

	@Autowired
	iCrudAbsence ca;

	public ControllerAbsence() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("all")
	public Iterable<Absence> getAbsence() {
		return ca.findAll();
	}
	
	@GetMapping("rttemployeur")
	public Iterable<Absence> getRttEmployeur(){
		return ca.getAllRttEmployeur();
	}

	@GetMapping("{id}")
	public Optional<Absence> getAbsence(@PathVariable("id") Integer pid) throws Exception {
		if (ca.findById(pid).isEmpty()) {
			String s = "Absence non trouveé , id: " + pid + " !!";
			throw new AbsenceNotFoundException(s);
		}
		return ca.findById(pid);
	}

	@PostMapping
	public Absence addAbsence(@Valid @RequestBody Absence absence, BindingResult result)
			throws AbsenceNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new AbsenceNotFoundException(s);
		}
		return ca.save(absence);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAbsence(@PathVariable("id") Integer pid) throws AbsenceNotFoundException {
		if (ca.findById(pid).isEmpty()) {
			String s = "Absence non trouvé, id:" + pid + " !!";
			throw new AbsenceNotFoundException(s);
		}
		ca.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Absence supprimé !");
	}

	@PutMapping("{id}")
	public Absence updateAbsence(@PathVariable("id") Integer pid, @RequestBody Absence absence)
			throws AbsenceNotFoundException {
		if (pid != absence.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et l'Absence JSON " + absence + " !!";
			throw new AbsenceNotFoundException(s);
		}
		if (ca.findById(pid).isEmpty()) {
			String s = "Absence non trouvé, id: " + pid + " !!";
			throw new AbsenceNotFoundException(s);
		}
		return ca.save(absence);
	}

}
