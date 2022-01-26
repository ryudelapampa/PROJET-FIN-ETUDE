package fr.diginamic.projet_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.diginamic.projet_final.model.Collaborateur;

public interface UserRepository extends JpaRepository<Collaborateur, Integer> {

	@Query("select u from Collaborateur u where u.username = :username")
	Optional<Collaborateur> findUserWithName(String username);

}
