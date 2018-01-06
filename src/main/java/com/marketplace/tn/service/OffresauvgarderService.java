package com.marketplace.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.tn.dao.IOffresauvgarderDAO;
import com.marketplace.tn.model.Offresauvgarder;
@Service
public class OffresauvgarderService implements IOffresauvgarderService {
	@Autowired
	private IOffresauvgarderDAO offresauvgarderDAO;
	@Override
	public Offresauvgarder getOffresauvgarderById(int offresauvgarderId) {
		Offresauvgarder obj = offresauvgarderDAO.getOffresauvgarderById(offresauvgarderId);
		return obj;
	}	
	@Override
	public List<Offresauvgarder> getAllOffresauvgarders(){
		return offresauvgarderDAO.getAllOffresauvgarders();
	}
	@Override
	public synchronized boolean createOffresauvgarder(Offresauvgarder offresauvgarder){
       if (offresauvgarderDAO.offresauvgarderExists(offresauvgarder.getOffre(),offresauvgarder.getAcheteur())) {
    	   return false;
       } else {
    	   offresauvgarderDAO.createOffresauvgarder(offresauvgarder);
    	   return true;
       }
	}

	
	
	@Override
	public void deleteOffresauvgarder(int offresauvgarderId) {
		offresauvgarderDAO.deleteOffresauvgarder(offresauvgarderId);
	}
}
