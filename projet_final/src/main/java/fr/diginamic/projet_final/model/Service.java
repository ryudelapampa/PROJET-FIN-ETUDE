package fr.diginamic.projet_final.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Service")
public class Service {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="LIBELLE")
	private String libelle;
	
	public Service() {
		// TODO Auto-generated constructor stub
	}

	public Service(@NotNull String libelle) {
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
