package fr.diginamic.projet_final.repository;


import org.springframework.data.repository.CrudRepository;
import fr.diginamic.projet_final.model.Service;

public interface iCrudService extends CrudRepository<Service, Integer> {


}
