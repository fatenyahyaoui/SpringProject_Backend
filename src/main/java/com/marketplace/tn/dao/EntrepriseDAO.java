package com.marketplace.tn.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.tn.model.*;

@Transactional
@Repository
public class EntrepriseDAO implements IEntrepriseDAO {
	@PersistenceContext	
	private EntityManager entityManager;	

	@Override
	public void Confirmer(String id) {
		Entreprise e=entityManager.find(Entreprise.class,Integer.parseInt(id));
		System.out.println(e);
        e.setEtat_compt_etr(1);
        entityManager.flush();
	
	}
	
}
