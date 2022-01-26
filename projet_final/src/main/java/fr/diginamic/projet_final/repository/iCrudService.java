package fr.diginamic.projet_final.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.projet_final.model.Collaborateur;
import fr.diginamic.projet_final.model.Service;

public interface iCrudService extends CrudRepository<Service, Integer> {

//	@Query("select c from Collaborateur c where :service MEMBER OF c.services")
//	public Iterable<Collaborateur> findByServiceCollaborateurs(Service service);

}
