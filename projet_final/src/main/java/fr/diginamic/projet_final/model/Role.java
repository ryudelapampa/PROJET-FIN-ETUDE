package fr.diginamic.projet_final.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Role")
public class Role {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="LIBELLE")
	private String libelle;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(@NotNull String libelle) {
		super();
		this.libelle = libelle;
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
