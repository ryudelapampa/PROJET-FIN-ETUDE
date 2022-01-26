package fr.diginamic.projet_final.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Absence")
public class Absence {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	@NotNull
	@Column(name="DATE_FIN")
	private Date dateFin;
	
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

	public Absence(@NotNull Date dateDebut, @NotNull Date dateFin, @NotNull String type, @NotNull String motif,
			@NotNull String statut) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
