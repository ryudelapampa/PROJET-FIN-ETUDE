package fr.diginamic.projet_final.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.projet_final.model.Collaborateur;
import fr.diginamic.projet_final.model.Role;
import fr.diginamic.projet_final.model.enumeration.ERole;


public interface iCrudRole extends CrudRepository<Role, Integer> {

	@Query("select c from Collaborateur c where :role MEMBER OF c.roles")
	public Iterable<Collaborateur> findByRolesCollaborateurs(Role role);

	
}
