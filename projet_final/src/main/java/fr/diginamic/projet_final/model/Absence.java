package fr.diginamic.projet_final.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Absence")
public class Absence {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="DATE_JOUR")
	private Date dateJour;
	
	@NotNull
	@Column(name="TYPE")
	private String type;
	
	@NotNull
	@Column(name="MOTIF")
	private String motif;
	
	@NotNull
	@Column(name="STATUT")
	private String statut;
	
	public Absence() {
		// TODO Auto-generated constructor stub
	}

	public Absence(@NotNull Date dateJour, @NotNull Integer duree, @NotNull String type, @NotNull String motif,
			@NotNull String statut) {
		super();
		this.dateJour = dateJour;
		this.type = type;
		this.motif = motif;
		this.statut = statut;
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
}
