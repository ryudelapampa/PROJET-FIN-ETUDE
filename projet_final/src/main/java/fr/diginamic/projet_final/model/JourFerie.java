package fr.diginamic.projet_final.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Jour_Ferie")
public class JourFerie {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="DATE_JOUR")
	private Date dateJour;
	
	@NotNull
	@Column(name="LIBELLE")
	private String libelle;

	public JourFerie() {
		// TODO Auto-generated constructor stub
	}

	public JourFerie(@NotNull Date dateJour, @NotNull String libelle) {
		super();
		this.dateJour = dateJour;
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
