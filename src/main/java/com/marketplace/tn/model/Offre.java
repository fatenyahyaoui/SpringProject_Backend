package com.marketplace.tn.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


import javax.persistence.GeneratedValue;

@Entity
public class Offre {
	@Id
	@GeneratedValue
	private int id_offre;
	private String nom_produit;
	private String image;
	
	private String a_propos;
	private String categorie_p;
	private String date_pub;
	private String telephone;
	private String lieu_offre;
	private int prix;
    @ManyToOne  
	@JoinColumn(name = "id_etr")
	private Entreprise entreprise;
	
	
	


	public Offre(String nom_produit, String a_propos, String categorie_p, String date_pub, String telephone,
			String lieu_offre, int prix, Entreprise entreprise) {
	
		this.nom_produit = nom_produit;
		this.a_propos = a_propos;
		this.categorie_p = categorie_p;
		this.date_pub = date_pub;
		this.telephone = telephone;
		this.lieu_offre = lieu_offre;
		this.prix = prix;
		this.entreprise = entreprise;
	}


	public Offre() {

	}
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}



	public String getNom_produit() {
		return nom_produit;
	}


	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}


	public String getCategorie_p() {
		return categorie_p;
	}


	public void setCategorie_p(String categorie_p) {
		this.categorie_p = categorie_p;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getId_offre() {
		return id_offre;
	}


	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}




	public String getA_propos() {
		return a_propos;
	}


	public void setA_propos(String a_propos) {
		this.a_propos = a_propos;
	}


	


	public String getDate_pub() {
		return date_pub;
	}


	public void setDate_pub(String date_pub) {
		this.date_pub = date_pub;
	}


	

	public String getLieu_offre() {
		return lieu_offre;
	}


	public void setLieu_offre(String lieu_offre) {
		this.lieu_offre = lieu_offre;
	}


	

	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	

}
