package com.marketplace.tn.service;

import java.util.List;

import com.marketplace.tn.model.Offresauvgarder;

public interface IOffresauvgarderService {
     List<Offresauvgarder> getAllOffresauvgarders();
     Offresauvgarder getOffresauvgarderById(int OffresauvgarderId);
     boolean createOffresauvgarder(Offresauvgarder offresauvgarder);
     
     void deleteOffresauvgarder(int offresauvgarderId);
}
