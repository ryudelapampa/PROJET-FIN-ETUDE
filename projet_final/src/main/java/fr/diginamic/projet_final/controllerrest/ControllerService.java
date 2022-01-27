package fr.diginamic.projet_final.controllerrest;

import java.util.Optional;

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

import fr.diginamic.projet_final.exception.ServiceNotFoundException;
import fr.diginamic.projet_final.model.Service;
import fr.diginamic.projet_final.repository.iCrudService;

@RestController
@CrossOrigin
@RequestMapping("api/service")
public class ControllerService {

	@Autowired
	iCrudService cs;
	
	public ControllerService() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<Service> getService(){
		return cs.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Service> getService(@PathVariable("id") Integer pid) throws Exception {
		if (cs.findById(pid).isEmpty()){
			String s = "Service non trouveé , id: "+pid+" !!";
			throw new ServiceNotFoundException(s);
		}
		return cs.findById(pid);
	}
	
	@PostMapping
	public Service addService(@Valid @RequestBody Service service, BindingResult result) throws ServiceNotFoundException {
		if ( result.hasErrors()) {
			String s = result.toString();
			throw new ServiceNotFoundException(s);
		}
		return cs.save(service);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteService(@PathVariable("id") Integer pid) throws ServiceNotFoundException {
		if ( cs.findById(pid).isEmpty()) {
			String s = "Service non trouvé, id:"+pid+" !!";
			throw new ServiceNotFoundException(s);
		}
		cs.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Service supprimé !");
	}
	
	@PutMapping("{id}")
	public Service updateService(@PathVariable("id") Integer pid,@RequestBody Service service) throws ServiceNotFoundException {
		if (pid != service.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le Service JSON "+service+" !!";
			throw new ServiceNotFoundException(s);
		}
		if(cs.findById(pid).isEmpty()) {
			String s = "Service non trouvé, id: "+pid+" !!";
			throw new ServiceNotFoundException(s);
		}
		return cs.save(service);
	}

}
