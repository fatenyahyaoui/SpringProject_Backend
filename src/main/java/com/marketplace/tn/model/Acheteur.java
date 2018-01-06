package com.marketplace.tn.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="acheteur")
public class Acheteur implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="acheteur_id")
    private int acheteurId;  
	@Column(name="nom_acheteur")
    private String nom_acheteur;
	@Column(name="prenom_acheteur")	
	private String prenom_acheteur;
	@Column(name="adresse_acheteur")	
	private String adresse_acheteur;
	@Column(name="code_postale")	
	private int code_postale;
	@Column(name="avatar")	
	private String avatar;
	@Column(name="tel_acheteur")	
	private int tel_acheteur;
	@Column(name="mail")	
	private String mail;
	@Column(name="password")	
	private String password;
	
	
	
	
	public int getAcheteurId() {
		return acheteurId;
	}
	public void setAcheteurId(int acheteurId) {
		this.acheteurId = acheteurId;
	}
	public String getNom_acheteur() {
		return nom_acheteur;
	}
	public void setNom_acheteur(String nom_acheteur) {
		this.nom_acheteur = nom_acheteur;
	}
	public String getPrenom_acheteur() {
		return prenom_acheteur;
	}
	public void setPrenom_acheteur(String prenom_acheteur) {
		this.prenom_acheteur = prenom_acheteur;
	}
	public String getAdresse_acheteur() {
		return adresse_acheteur;
	}
	public void setAdresse_acheteur(String adresse_acheteur) {
		this.adresse_acheteur = adresse_acheteur;
	}
	public int getCode_postale() {
		return code_postale;
	}
	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getTel_acheteur() {
		return tel_acheteur;
	}
	public void setTel_acheteur(int tel_acheteur) {
		this.tel_acheteur = tel_acheteur;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
} 