package com.faten.parfums.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Parfum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParfum;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomParfum;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixParfum;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;

	@ManyToOne
	private Type type;
	
	public Parfum() {
		super();
	}

	public Parfum(String nomParfum, Double prixParfum, Date dateCreation) {
		super();
		this.nomParfum = nomParfum;
		this.prixParfum = prixParfum;
		this.dateCreation = dateCreation;
	}

	public Long getIdParfum() {
		return idParfum;
	}

	public void setIdParfum(Long idParfum) {
		this.idParfum = idParfum;
	}

	public String getNomParfum() {
		return nomParfum;
	}

	public void setNomParfum(String nomParfum) {
		this.nomParfum = nomParfum;
	}

	public Double getPrixParfum() {
		return prixParfum;
	}

	public void setPrixParfum(Double prixParfum) {
		this.prixParfum = prixParfum;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Parfum [idParfum=" + idParfum + ", nomParfum=" + nomParfum + ", prixParfum=" + prixParfum + "]";
	}

}
