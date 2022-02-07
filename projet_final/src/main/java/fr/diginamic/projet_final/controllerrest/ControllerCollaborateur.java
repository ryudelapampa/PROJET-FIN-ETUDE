package fr.diginamic.projet_final.controllerrest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.projet_final.dto.CollaborateurDTO;
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
	
	@GetMapping("/all")
	public Iterable<Collaborateur> getCollaborateur(){
		return cc.findAll();
	}
	
	@GetMapping("{id}")
	public CollaborateurDTO getCollaborateur(@PathVariable("id") Integer pid) throws Exception {
		if (cc.findById(pid).isEmpty()){
			String s = "Collaborateur non trouveé , id: "+pid+" !!";
			throw new CollaborateurNotFoundException(s);
		}
		Collaborateur monCollab = cc.findById(pid).get();
		CollaborateurDTO monCollabDTO = new CollaborateurDTO(monCollab);
		return monCollabDTO;
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
