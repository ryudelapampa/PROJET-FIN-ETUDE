package fr.diginamic.projet_final.repository;

import org.springframework.data.jpa.repository.Query;

import fr.diginamic.projet_final.model.enumeration.StatutAbsence;

public interface BatchManager {

	@Query("UPDATE Absence a SET a.statut = :updatestatut WHERE a.type = 'RTT_EMPLOYEUR' AND a.statut = 'INITIALE")
	public void updateRttEmployeurInitiale(StatutAbsence statut);
	
}
