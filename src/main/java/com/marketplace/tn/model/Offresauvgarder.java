package com.marketplace.tn.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
@Table(name="offresauvgarder")
public class Offresauvgarder implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_offresauvgarder")
    private Long offresauvgarderId;  
	
	@ManyToOne
	@JoinColumn(name = "acheteur_id")
	private Acheteur acheteur;
	@OneToOne
	@JoinColumn(name = "id_offre")
	private Offre offre;
	
	
	public Long getOffresauvgarderId() {
		return offresauvgarderId;
	}
	public void setOffresauvgarderId(Long offresauvgarderId) {
		this.offresauvgarderId = offresauvgarderId;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	
	public Acheteur getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}
	
	
	
}
