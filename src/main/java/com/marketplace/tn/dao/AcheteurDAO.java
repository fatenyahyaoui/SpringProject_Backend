package com.marketplace.tn.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.tn.model.Acheteur;
@Transactional
@Repository
public class AcheteurDAO implements IAcheteurDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Acheteur getAcheteurById(int acheteurId) {
		return entityManager.find(Acheteur.class, acheteurId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Acheteur> getAllAcheteurs() {
		String hql = "FROM Acheteur as atcl ORDER BY atcl.acheteurId DESC";
		return (List<Acheteur>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createAcheteur(Acheteur acheteur) {
		entityManager.persist(acheteur);
	}
	@Override
	public void updateAcheteur(Acheteur acheteur) {
		Acheteur artcl = getAcheteurById(acheteur.getAcheteurId());
		artcl.setNom_acheteur(acheteur.getNom_acheteur());
		artcl.setPrenom_acheteur(acheteur.getPrenom_acheteur());
		artcl.setAdresse_acheteur(acheteur.getAdresse_acheteur());
		artcl.setCode_postale(acheteur.getCode_postale());
		artcl.setAvatar(acheteur.getAvatar());
		artcl.setTel_acheteur(acheteur.getTel_acheteur());
		artcl.setMail(acheteur.getMail());
		artcl.setPassword(acheteur.getPassword());
		entityManager.flush();
	}
	@Override
	public void deleteAcheteur(int acheteurId) {
		entityManager.remove(getAcheteurById(acheteurId));
	}
	@Override
	public boolean acheteurExists(String nom_acheteur, String prenom_acheteur, String adresse_acheteur, int code_postale, String avatar, int tel_acheteur, String mail, String password) {
		String hql = "FROM Acheteur as atcl WHERE atcl.nom_acheteur = ? and atcl.prenom_acheteur = ? and atcl.adresse_acheteur = ? and atcl.code_postale = ? and atcl.avatar = ? and atcl.tel_acheteur = ? and atcl.mail = ? and atcl.password = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nom_acheteur)
		              .setParameter(2, prenom_acheteur).setParameter(3, adresse_acheteur)
		              .setParameter(4, code_postale).setParameter(5, avatar)
		              .setParameter(6, tel_acheteur).setParameter(7, mail)
		              .setParameter(8, password).getResultList().size();
		return count > 0 ? true : false;		
	}
}
