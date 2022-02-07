package fr.diginamic.projet_final.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.diginamic.projet_final.model.Absence;
import fr.diginamic.projet_final.model.Collaborateur;

public class CollaborateurDTO {
	
	private Integer id;
	
	private String nom;

	private String prenom;
	
	private Date dateEmbauche;

	private String email;

	private Integer telephone;

	private RoleDTO role;

	private Set<AbsenceDTO> absences;

	private ServiceDTO service;
	
	public CollaborateurDTO() {
		
	}

	/*
	 * CONSTRUCTEUR COMPLET
	 */
	public CollaborateurDTO( String nom,  String prenom,  Date dateEmbauche,  String email,
			 Integer telephone,  RoleDTO role, Set<AbsenceDTO> absences,  ServiceDTO service) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.absences = absences;
		this.service = service;

	}
	
	public CollaborateurDTO(Collaborateur collaborateur) {
		this.id = collaborateur.getId();
		this.nom = collaborateur.getNom();
		this.prenom = collaborateur.getPrenom();
		this.email = collaborateur.getEmail();
		if (collaborateur.getRole() != null) {
			this.role = new RoleDTO(collaborateur.getRole());
		}
		this.absences = new HashSet<AbsenceDTO>();
		for(Absence abs : collaborateur.getAbsences()) {
			AbsenceDTO absDTO = new AbsenceDTO(abs.getId(),abs.getDateJour(),abs.getType(),abs.getMotif(),abs.getStatut());
			this.absences.add(absDTO);
		}
		if (collaborateur.getService() != null) {
			this.service = new ServiceDTO(collaborateur.getService());
		}
	}
	
	/*
	 * CONSTRUCTEUR avec liste absence vide 
	 */
	public CollaborateurDTO( String nom,  String prenom,  Date dateEmbauche,  String email,
			 Integer telephone, RoleDTO role, ServiceDTO service)  {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.absences = new HashSet<AbsenceDTO>();
		this.service = service;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public Set<AbsenceDTO> getAbsences() {
		return absences;
	}

	public void setAbsence(Set<AbsenceDTO> absences) {
		this.absences = absences;
	}
	
	public ServiceDTO getService() {
		return service;
	}

	public void setService(ServiceDTO service) {
		this.service = service;
	}
}
