package fr.diginamic.projet_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.projet_final.model.Role;
import fr.diginamic.projet_final.model.enumeration.ERole;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
	
	Optional<Role> findByName(ERole name);
	
}
