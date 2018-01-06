package com.marketplace.tn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.marketplace.tn.Repository.OffreRepository;
import com.marketplace.tn.Repository.OffresauvgarderRepository;
import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Offre;
import com.marketplace.tn.model.Offresauvgarder;
import com.marketplace.tn.service.IAcheteurService;
import com.marketplace.tn.service.IOffresauvgarderService;

@Controller
@CrossOrigin(origins = {"http://localhost:4200"})
public class OffresauvgarderController {
	@Autowired
	private IAcheteurService acheteurS;
	@Autowired
	private AcheteurRepository acheteurR;
	@Autowired
	private OffreRepository offre;
	@Autowired
	private OffresauvgarderRepository offresauvgarderRepository;
	@Autowired
	private IOffresauvgarderService offresauvgarderService;
	@GetMapping("offresauvgarder")
	public ResponseEntity<Offresauvgarder> getOffresauvgarderById(@RequestParam("id") String id) {
		Offresauvgarder offresauvgarder = offresauvgarderService.getOffresauvgarderById(Integer.parseInt(id));
		return new ResponseEntity<Offresauvgarder>(offresauvgarder, HttpStatus.OK);
	}
	@GetMapping("all-offresauvgarders")
	public ResponseEntity<List<Offresauvgarder>> getAllOffresauvgarders(@RequestParam("id") String id) {
		List<Offresauvgarder> list = offresauvgarderService.getAllOffresauvgarders();
		System.out.println("Exxxxx"+id);
		List<Offresauvgarder> list1 =new ArrayList();
		for (int i=0;i<list.size();i++) {
			if (list.get(i).getAcheteur().getAcheteurId()==Integer.parseInt(id)) {
			 list1.add(list.get(i));
			}
		}
		return new ResponseEntity<List<Offresauvgarder>>(list1, HttpStatus.OK);
	}
	@PostMapping("offresauvgarder")
	public ResponseEntity<Void> createOffresauvgarder(@RequestBody Offresauvgarder offresauvgarder,@RequestParam("id") String id,@RequestParam("id1") String id1, UriComponentsBuilder builder) {
		System.out.println(id);
	    Long ii=Long.parseLong(id);
	    System.out.println("l9itou saye"+ii);
	   
	    Acheteur cC1=acheteurS.getAcheteurById(Integer.parseInt(id));
	    Offre ef=offre.findOne(Integer.parseInt(id1));
	    offresauvgarder.setAcheteur(cC1);
	    offresauvgarder.setOffre(ef);
	       
	    boolean flag = offresauvgarderService.createOffresauvgarder(offresauvgarder);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/offresauvgarder?id={id}").buildAndExpand(offresauvgarder.getOffresauvgarderId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("offresauvgarder")
	public ResponseEntity<Void> deleteOffresauvgarder(@RequestParam("id") String id) {
		Offresauvgarder f=offresauvgarderService.getOffresauvgarderById(Integer.parseInt(id));
		offresauvgarderRepository.delete(f);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}