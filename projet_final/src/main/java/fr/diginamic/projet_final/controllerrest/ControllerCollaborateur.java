package fr.diginamic.projet_final.controllerrest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.diginamic.projet_final.exception.CollaborateurNotFoundException;
import fr.diginamic.projet_final.model.Collaborateur;
import fr.diginamic.projet_final.repository.iCrudCollaborateur;

@RestController
@CrossOrigin
@RequestMapping("api/collaborateur")
public class ControllerCollaborateur {
	
	@Autowired
	iCrudCollaborateur cc;

	public ControllerCollaborateur() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<Collaborateur> getCollaborateur(){
		return cc.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Collaborateur> getCollaborateur(@PathVariable("id") Integer pid) throws Exception {
		if (cc.findById(pid).isEmpty()){
			String s = "Collaborateur non trouveé , id: "+pid+" !!";
			throw new CollaborateurNotFoundException(s);
		}
		return cc.findById(pid);
	}
	
	@PostMapping
	public Collaborateur addCollaborateur(@Valid @RequestBody Collaborateur collaborateur, BindingResult result) throws CollaborateurNotFoundException {
		if ( result.hasErrors()) {
			String s = result.toString();
			throw new CollaborateurNotFoundException(s);
		}
		return cc.save(collaborateur);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCollaborateur(@PathVariable("id") Integer pid) throws CollaborateurNotFoundException {
		if ( cc.findById(pid).isEmpty()) {
			String s = "Collaborateur non trouvé, id:"+pid+" !!";
			throw new CollaborateurNotFoundException(s);
		}
		cc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Collaborateur supprimé !");
	}
	
	@PutMapping("{id}")
	public Collaborateur updateCollaborateur(@PathVariable("id") Integer pid,@RequestBody Collaborateur collaborateur) throws CollaborateurNotFoundException {
		if (pid != collaborateur.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le Collaborateur JSON "+collaborateur+" !!";
			throw new CollaborateurNotFoundException(s);
		}
		if(cc.findById(pid).isEmpty()) {
			String s = "Collaborateur non trouvé, id: "+pid+" !!";
			throw new CollaborateurNotFoundException(s);
		}
		return cc.save(collaborateur);
	}

}
