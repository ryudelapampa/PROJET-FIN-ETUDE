package fr.diginamic.projet_final.repository;

import org.springframework.data.repository.CrudRepository;

import fr.diginamic.projet_final.model.Role;


public interface iCrudRole extends CrudRepository<Role, Integer> {

//	@Query("select c from Collaborateur c where :role MEMBER OF c.role")
//	public Iterable<Collaborateur> findByRolesCollaborateurs(Role role);
	
}
