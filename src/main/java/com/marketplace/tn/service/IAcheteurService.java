package com.marketplace.tn.service;

import java.util.List;

import com.marketplace.tn.model.Acheteur;

public interface IAcheteurService {
     List<Acheteur> getAllAcheteurs();
     Acheteur getAcheteurById(int acheteurId);
     boolean createAcheteur(Acheteur acheteur);
     void updateAcheteur(Acheteur acheteur);
     void deleteAcheteur(int acheteurId);
}
