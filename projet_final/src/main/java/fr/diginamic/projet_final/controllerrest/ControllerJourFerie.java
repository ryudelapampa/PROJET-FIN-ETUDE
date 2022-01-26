package fr.diginamic.projet_final.controllerrest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.diginamic.projet_final.exception.JourFerieNotFoundException;
import fr.diginamic.projet_final.model.JourFerie;
import fr.diginamic.projet_final.repository.iCrudJourFerie;

@RestController
@CrossOrigin
@RequestMapping("api/jourferie")
public class ControllerJourFerie {
	
	@Autowired
	iCrudJourFerie cj;

	public ControllerJourFerie() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<JourFerie> getJourFerie(){
		return cj.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<JourFerie> getJourFerie(@PathVariable("id") Integer pid) throws Exception {
		if (cj.findById(pid).isEmpty()){
			String s = "JourFerieorateur non trouveé , id: "+pid+" !!";
			throw new JourFerieNotFoundException(s);
		}
		return cj.findById(pid);
	}
	
	@PostMapping
	public JourFerie addJourFerie(@Valid @RequestBody JourFerie jourFerie, BindingResult result) throws JourFerieNotFoundException {
		if ( result.hasErrors()) {
			String s = result.toString();
			throw new JourFerieNotFoundException(s);
		}
		return cj.save(jourFerie);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteJourFerie(@PathVariable("id") Integer pid) throws JourFerieNotFoundException {
		if ( cj.findById(pid).isEmpty()) {
			String s = "JourFerie non trouvé, id:"+pid+" !!";
			throw new JourFerieNotFoundException(s);
		}
		cj.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("JourFerie supprimé !");
	}
	
	@PutMapping("{id}")
	public JourFerie updateClient(@PathVariable("id") Integer pid,@RequestBody JourFerie jourFerie) throws JourFerieNotFoundException {
		if (pid != jourFerie.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le JourFerie JSON " + jourFerie + " !!";
			throw new JourFerieNotFoundException(s);
		}
		if(cj.findById(pid).isEmpty()) {
			String s = "JourFerie non trouvé, id: " + pid + " !!";
			throw new JourFerieNotFoundException(s);
		}
		return cj.save(jourFerie);
	}

}
