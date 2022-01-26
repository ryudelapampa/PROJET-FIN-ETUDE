package fr.diginamic.projet_final.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Collaborateur")
public class Collaborateur {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@NotNull
	@Column(name="NOM")
	private String nom;
	
	@NotNull
	@Column(name="PRENOM")
	private String prenom;
	
	@NotNull
	@Column(name="DATE_EMBAUCHE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateEmbauche;
	
	@NotNull
	@Column(name="E_MAIL")
	private String email;
	
	@NotNull
	@Column(name="TELEPHONE")
	private Integer telephone;
	
	@NotNull
	@ManyToMany
	@JoinTable(name="COLAB_ROLE",
		joinColumns= @JoinColumn(name="COLAB_ID", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ROLE_ID", referencedColumnName="ID"))
	private Set<Role> roles;

	@OneToMany
	@JoinTable(name = "COLAB_ABSENCE",
		joinColumns = @JoinColumn(name = "COLAB_ID", referencedColumnName="ID"),
		inverseJoinColumns = @JoinColumn(name="ABSENCE_ID", referencedColumnName="ID"))
	private Set<Absence> absences;
	
	@NotNull
	@OneToMany
	@JoinTable(name = "COLAB_SERVICE",
			joinColumns = @JoinColumn(name = "COLAB_ID", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="SERVICE_ID", referencedColumnName="ID"))
	private Service service;
	
	public Collaborateur() {
		
	}

	public Collaborateur(@NotNull String nom, @NotNull String prenom, @NotNull Date dateEmbauche, @NotNull String email,
			@NotNull Integer telephone, @NotNull Set<Role> roles, Set<Absence> absences, Service service) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.roles = roles;
		this.absences = absences;
		this.service = service;
	}
	
	public Collaborateur(@NotNull String nom, @NotNull String prenom, @NotNull Date dateEmbauche, @NotNull String email,
			@NotNull Integer telephone, @NotNull Set<Role> roles,@NotNull Service service)  {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.roles = roles;
		this.absences = new HashSet<Absence>();
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsence(Set<Absence> absences) {
		this.absences = absences;
	}

}
