package fr.diginamic.projet_final.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import fr.diginamic.projet_final.model.Absence;

public interface iCrudAbsence extends CrudRepository<Absence, Integer> {

	@Query("select a from Absence a where a.type = 'RTT_EMPLOYEUR' ")
	public Iterable<Absence> getAllRttEmployeur();

	@Query("select a from Absence a where a.type = 'RTT_EMPLOYEUR' and a.statut = 'INITIAL'")
	public Iterable<Absence> getAllRttEmployeurInitiale();
	
}
