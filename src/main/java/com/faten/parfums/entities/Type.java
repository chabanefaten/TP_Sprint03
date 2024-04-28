package com.faten.parfums.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTyp;
	private String nomTyp;
	private String descriptionTyp;
	
	
	@OneToMany(mappedBy = "type")
	@JsonIgnore
	private List<Parfum> parfums;


	public Type() {
		super();
	}

	public Type(String nomTyp, String descriptionTyp, List<Parfum> parfums) {
		super();
		this.nomTyp = nomTyp;
		this.descriptionTyp = descriptionTyp;
		this.parfums = parfums;
	}

	public Long getIdTyp() {
		return idTyp;
	}

	public void setIdTyp(Long idTyp) {
		this.idTyp = idTyp;
	}

	public String getNomTyp() {
		return nomTyp;
	}

	public void setNomTyp(String nomTyp) {
		this.nomTyp = nomTyp;
	}

	public String getDescriptionTyp() {
		return descriptionTyp;
	}

	public void setDescriptionTyp(String descriptionTyp) {
		this.descriptionTyp = descriptionTyp;
	}
	


	public List<Parfum> getParfums() {
		return parfums;
	}

	public void setParfums(List<Parfum> parfums) {
		this.parfums = parfums;
	}
}
