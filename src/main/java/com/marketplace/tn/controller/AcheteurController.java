package com.marketplace.tn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.marketplace.tn.Repository.AcheteurRepository;
import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Entreprise;
import com.marketplace.tn.service.IAcheteurService;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AcheteurController {
	@Autowired
	private IAcheteurService acheteurService;
	@Autowired
	private AcheteurRepository acheteurRepository;
	@GetMapping("acheteur")
	public ResponseEntity<Acheteur> getAcheteurById(@RequestParam("id") String id) {
		Acheteur acheteur = acheteurService.getAcheteurById(Integer.parseInt(id));
		return new ResponseEntity<Acheteur>(acheteur, HttpStatus.OK);
	}
	@GetMapping("all-acheteurs")
	public ResponseEntity<List<Acheteur>> getAllAcheteurs() {
		List<Acheteur> list = acheteurService.getAllAcheteurs();
		return new ResponseEntity<List<Acheteur>>(list, HttpStatus.OK);
	}
	@PostMapping("acheteur")
	public ResponseEntity<Void> createAcheteur(@RequestBody Acheteur acheteur, UriComponentsBuilder builder) {
	       boolean flag = acheteurService.createAcheteur(acheteur);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/acheteur?id={id}").buildAndExpand(acheteur.getAcheteurId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	}
	@PutMapping("acheteur")
	public ResponseEntity<Acheteur> updateArticle(@RequestBody Acheteur acheteur) {
		acheteurService.updateAcheteur(acheteur);
		return new ResponseEntity<Acheteur>(acheteur, HttpStatus.OK);
	}
	
	@DeleteMapping("acheteur")
	public ResponseEntity<Void> deleteAcheteur(@RequestParam("id") String id) {
		acheteurService.deleteAcheteur(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	@GetMapping("login")
	public ResponseEntity<Acheteur> login(@RequestParam("mail") String mail,@RequestParam("pass") String pass) {
		List<Acheteur> l=acheteurRepository.findAll();
		Acheteur etr=new Acheteur();
		for (int i=0;i<l.size();i++)
		{
			if(l.get(i).getMail().equals(mail)&&l.get(i).getPassword().equals(pass))
			{
				etr=l.get(i);
				System.out.println(etr.getMail());
			}
		}
		return new ResponseEntity<Acheteur>(etr, HttpStatus.OK);

	}
}