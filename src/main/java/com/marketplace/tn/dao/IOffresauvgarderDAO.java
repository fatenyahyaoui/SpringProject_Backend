package com.marketplace.tn.dao;
import java.util.List;

import com.marketplace.tn.model.*;
public interface IOffresauvgarderDAO {
    List<Offresauvgarder> getAllOffresauvgarders();
    Offresauvgarder getOffresauvgarderById(int offresauvgarderId);
    void createOffresauvgarder(Offresauvgarder offresauvgarder);
    
    void deleteOffresauvgarder(int offresauvgarderId);
    boolean offresauvgarderExists(Offre offreemploi,Acheteur candidat);
    
}
 