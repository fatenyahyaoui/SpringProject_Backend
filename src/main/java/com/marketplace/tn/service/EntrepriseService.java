package com.marketplace.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.tn.dao.*;
import com.marketplace.tn.model.*;
@Service
public class EntrepriseService implements IEntrepriseService {
	@Autowired
	private IEntrepriseDAO Etr;
	
	@Override
	public void ConfirmMe(String id) {
      Etr.Confirmer(id);		
	}	
}