package com.marketplace.tn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.tn.Repository.EntrepriseRepository;
import com.marketplace.tn.Repository.OffreRepository;
import com.marketplace.tn.dao.*;
import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Entreprise;
import com.marketplace.tn.model.Offre;

@RestController
@RequestMapping("/apientreprise")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EntrepriseController {
	@Autowired
	private IEntrepriseDAO e;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private OffreRepository Offrerep;
	
	@GetMapping("/entreprises")
	public List<Entreprise> getEntreprises(){
		
		return entrepriseRepository.findAll();
	}
	
	@GetMapping("/entreprise/{id_etr}")
	public Entreprise getEntreprise(@PathVariable Integer id_etr){
		
		return entrepriseRepository.findOne(id_etr);
	}
	
	@DeleteMapping("/entreprise/{id_etr}")
	public boolean deleteEntreprise(@PathVariable Integer id_etr){
        List<Offre> l=Offrerep.findAll();
        for (int i=0;i<l.size();i++)
        {
        	if (l.get(i).getEntreprise().getId_etr()==(int)id_etr) {
        		this.Offrerep.delete(l.get(i).getId_offre());
        	}
        }
		entrepriseRepository.delete(id_etr);
		return true;
	}

	@PostMapping("confirmer")
	public void Confirmer(@RequestBody String id) {
		e.Confirmer(id);
		System.out.println("-----------------:"+id);
	}
	@GetMapping("login")
	public ResponseEntity<Entreprise> login(@RequestParam("mail") String mail,@RequestParam("pass") String pass) {
		List<Entreprise> l=entrepriseRepository.findAll();
		Entreprise etr=new Entreprise();
		for (int i=0;i<l.size();i++)
		{
			if(l.get(i).getLogin().equals(mail)&&l.get(i).getPassword().equals(pass)&&l.get(i).getEtat_compt_etr()==1)
			{
				etr=l.get(i);
				System.out.println(etr.getNom_ent());
			}
		}
		return new ResponseEntity<Entreprise>(etr, HttpStatus.OK);

	}
	
	@PostMapping("/entreprise")
	public Entreprise createEntreprise(@RequestBody Entreprise entreprise){
		
		return entrepriseRepository.save(entreprise);
	}
	
	@PutMapping("/entreprise")
	public Entreprise updateEntreprise(@RequestBody Entreprise entreprise){
//		System.out.println(entreprise.getId_etr());
		return entrepriseRepository.save(entreprise);
	}
	
}
