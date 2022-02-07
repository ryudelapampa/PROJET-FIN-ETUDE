package fr.diginamic.projet_final.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@SuppressWarnings("serial")
@Entity
@Table(name="Collaborateur")
public class Collaborateur implements UserDetails{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(name="USERNAME")
	private String username;
	
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
	@Column(name="PASSWORD")
	private String password;
	
	@NotNull
	@Column(name="TELEPHONE")
	private Integer telephone;
	
//	@NotNull
//	@ManyToMany
//	@JoinTable(name="COLAB_ROLE",
//		joinColumns= @JoinColumn(name="COLAB_ID", referencedColumnName="ID"),
//		inverseJoinColumns= @JoinColumn(name="ROLE_ID", referencedColumnName="ID"))
//	private Set<Role> roles;
	
	@ManyToOne
	@JoinColumn(name="ID_ROLE")
	private Role role;

	@JsonIgnore
	@OneToMany(mappedBy="collaborateur")
	private Set<Absence> absences;
	
	@ManyToOne
	@JoinColumn(name="ID_SERVICE")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="ID_CHEF")
	private Collaborateur chef;
	
	@OneToMany(mappedBy="chef")
	private List<Collaborateur> subordonnes;
	
	public Collaborateur() {
		
	}

	/*
	 * CONSTRUCTEUR COMPLET
	 */
	public Collaborateur(@NotNull String nom, @NotNull String prenom, @NotNull Date dateEmbauche, @NotNull String email,
			@NotNull Integer telephone, @NotNull Role role, Set<Absence> absences, String password, Service service) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.absences = absences;
		this.service = service;
		this.username = email;
		this.password = password;
	}
	
	/*
	 * CONSTRUCTEUR avec liste absence vide 
	 */
	public Collaborateur(@NotNull String nom, @NotNull String prenom, @NotNull Date dateEmbauche, @NotNull String email,
			@NotNull Integer telephone, @NotNull Role role,String password, Service service)  {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.absences = new HashSet<Absence>();
		this.service = service;
		this.username = email;
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsence(Set<Absence> absences) {
		this.absences = absences;
	}
	
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
	//SECURITY

	public Collaborateur getChef() {
		return chef;
	}

	public void setChef(Collaborateur chef) {
		this.chef = chef;
	}

	public List<Collaborateur> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<Collaborateur> subordonnes) {
		this.subordonnes = subordonnes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
