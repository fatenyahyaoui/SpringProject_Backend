package com.marketplace.tn.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Offre;
import com.marketplace.tn.model.Offresauvgarder;
@Transactional
@Repository
public class OffresauvgarderDAO implements IOffresauvgarderDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Offresauvgarder getOffresauvgarderById(int offresauvgarderId) {
		return entityManager.find(Offresauvgarder.class, offresauvgarderId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Offresauvgarder> getAllOffresauvgarders() {
		String hql = "FROM Offresauvgarder as atcl ORDER BY atcl.offresauvgarderId DESC";
		return (List<Offresauvgarder>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createOffresauvgarder(Offresauvgarder offresauvgarder) {
		entityManager.persist(offresauvgarder);
	}
	
	
	@Override
	public boolean offresauvgarderExists(Offre offre,Acheteur acheteur) {
		String hql = "FROM Offresauvgarder as atcl WHERE atcl.offre = ? and atcl.acheteur = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, offre)
		              
		              .setParameter(2, acheteur)
		              .getResultList().size();
		return count > 0 ? true : false;		
	}

	@Override
	public void deleteOffresauvgarder(int offresauvgarderId) {
		entityManager.remove(getOffresauvgarderById(offresauvgarderId));
	}
	
}
