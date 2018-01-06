package com.marketplace.tn.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="article")
public class Article implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
    private int articleId;  
	@Column(name="nom_article")
    private String nom_article;
	@Column(name="prix_article")	
	private int prix_article;
	@Column(name="adresse_article")	
	private String adresse_article;
	@Column(name="categorie_article")	
	private String categorie_article;
	@Column(name="ville_article")	
	private String ville_article;
	@Column(name="avatar_article")	
	private String avatar_article;
	@Column(name="tel_article")	
	private int tel_article;
	@Column(name="apropos_article")	
	private String apropos_article;
	@Column(name="datepub_article")	
	private String datepub_article;
	
	@ManyToOne
	@JoinColumn(name = "id_etr")
	private Entreprise Entreprise;
	
	public Entreprise getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		Entreprise = entreprise;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public int getPrix_article() {
		return prix_article;
	}
	public void setPrix_article(int prix_article) {
		this.prix_article = prix_article;
	}
	public String getAdresse_article() {
		return adresse_article;
	}
	public void setAdresse_article(String adresse_article) {
		this.adresse_article = adresse_article;
	}
	public String getCategorie_article() {
		return categorie_article;
	}
	public void setCategorie_article(String categorie_article) {
		this.categorie_article = categorie_article;
	}
	public String getVille_article() {
		return ville_article;
	}
	public void setVille_article(String ville_article) {
		this.ville_article = ville_article;
	}
	public String getAvatar_article() {
		return avatar_article;
	}
	public void setAvatar_article(String avatar_article) {
		this.avatar_article = avatar_article;
	}
	public int getTel_article() {
		return tel_article;
	}
	public void setTel_article(int tel_article) {
		this.tel_article = tel_article;
	}
	public String getApropos_article() {
		return apropos_article;
	}
	public void setApropos_article(String apropos_article) {
		this.apropos_article = apropos_article;
	}
	public String getDatepub_article() {
		return datepub_article;
	}
	public void setDatepub_article(String datepub_article) {
		this.datepub_article = datepub_article;
	}
	
	
	
	
	
	
	
} 