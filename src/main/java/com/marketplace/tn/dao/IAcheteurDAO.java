package com.marketplace.tn.dao;
import java.util.List;

import com.marketplace.tn.model.*;
public interface IAcheteurDAO {
    List<Acheteur> getAllAcheteurs();
    Acheteur getAcheteurById(int acheteurId);
    void createAcheteur(Acheteur acheteur);
    void updateAcheteur(Acheteur acheteur);
    void deleteAcheteur(int acheteurId);
    boolean acheteurExists(String nom_acheteur, String prenom_acheteur, String adresse_acheteur, int code_postale, String avatar, int tel_acheteur, String mail, String password);
}
 