package fr.diginamic.projet_final.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import fr.diginamic.projet_final.model.enumeration.ERole;

@Entity
@Table(name="Role")
public class Role {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="LIBELLE")
	private ERole name;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(@NotNull ERole name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
	
	

}
