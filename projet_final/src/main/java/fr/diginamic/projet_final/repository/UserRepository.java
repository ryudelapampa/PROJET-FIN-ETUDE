package fr.diginamic.projet_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.projet_final.model.Collaborateur;

@Repository
public interface UserRepository extends JpaRepository<Collaborateur, Integer> {
	
	Optional<Collaborateur> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);

}
