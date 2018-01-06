package com.marketplace.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.tn.dao.IAcheteurDAO;
import com.marketplace.tn.model.Acheteur;
@Service
public class AcheteurService implements IAcheteurService {
	@Autowired
	private IAcheteurDAO acheteurDAO;
	@Override
	public Acheteur getAcheteurById(int acheteurId) {
		Acheteur obj = acheteurDAO.getAcheteurById(acheteurId);
		return obj;
	}	
	@Override
	public List<Acheteur> getAllAcheteurs(){
		return acheteurDAO.getAllAcheteurs();
	}
	@Override
	public synchronized boolean createAcheteur(Acheteur acheteur){
       if (acheteurDAO.acheteurExists(acheteur.getNom_acheteur(), acheteur.getPrenom_acheteur(), acheteur.getAdresse_acheteur(), acheteur.getCode_postale(), acheteur.getAvatar(), acheteur.getTel_acheteur(), acheteur.getMail(), acheteur.getPassword())) {
    	   return false;
       } else {
    	   acheteurDAO.createAcheteur(acheteur);
    	   return true;
       }
	}
	@Override
	public void updateAcheteur(Acheteur acheteur) {
		acheteurDAO.updateAcheteur(acheteur);
	}
	@Override
	public void deleteAcheteur(int acheteurId) {
		acheteurDAO.deleteAcheteur(acheteurId);
	}
}
