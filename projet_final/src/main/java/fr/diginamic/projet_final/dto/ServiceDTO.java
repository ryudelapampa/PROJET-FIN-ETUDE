package fr.diginamic.projet_final.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.projet_final.model.Service;


public class ServiceDTO {

	
	private Integer id;

	private String libelle;

	private List<CollaborateurDTO> collaborateurs;
	
	public ServiceDTO() {
		// TODO Auto-generated constructor stub
	}

	public ServiceDTO(Service service) {
		super();
		this.libelle = service.getLibelle();
		this.collaborateurs = new ArrayList<CollaborateurDTO>();
		this.id = service.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<CollaborateurDTO> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<CollaborateurDTO> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
	
	

}
