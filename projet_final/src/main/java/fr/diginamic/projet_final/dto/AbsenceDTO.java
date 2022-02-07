package fr.diginamic.projet_final.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fr.diginamic.projet_final.model.Absence;


public class AbsenceDTO {
	

	private Integer id;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateJour;

	private String type;

	private String motif;
	
	private String statut;

	private CollaborateurDTO collaborateur;
	
	public AbsenceDTO() {
		// TODO Auto-generated constructor stub
	}

	public AbsenceDTO(Integer id, Date dateJour, String type,  String motif,
			 String statut) {
		super();
		this.id = id;
		this.dateJour = dateJour;
		this.type = type;
		this.motif = motif;
		this.statut = statut;
	}
	
	public AbsenceDTO(Absence absence) {
		this.id = absence.getId();
		this.dateJour = absence.getDateJour();
		this.type = absence.getType();
		this.motif = absence.getMotif();
		this.statut = absence.getStatut();
		this.collaborateur = new CollaborateurDTO(absence.getCollaborateur());
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public CollaborateurDTO getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(CollaborateurDTO collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
}
