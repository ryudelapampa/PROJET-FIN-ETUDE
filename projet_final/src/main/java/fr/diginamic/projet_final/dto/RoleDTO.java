package fr.diginamic.projet_final.dto;

import fr.diginamic.projet_final.model.Role;

public class RoleDTO {

	private Integer id;

	private String libelle;

	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public RoleDTO( String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		this.libelle = role.getLibelle();
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
	
	

}
