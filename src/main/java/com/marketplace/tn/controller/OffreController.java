package com.marketplace.tn.controller;

import java.util.ArrayList;
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

import com.marketplace.tn.Repository.EntrepriseRepository;
import com.marketplace.tn.Repository.OffreRepository;
import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Entreprise;
import com.marketplace.tn.model.Offre;

@RestController
@RequestMapping("/apioffre")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class OffreController {
	
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private EntrepriseRepository etr;
	private String id;

	@GetMapping("/offres")
	public List<Offre> getOffres(){
		
		return offreRepository.findAll();
	}
	
	@GetMapping("/OffreByID")
	public ResponseEntity<List<Offre>> TousOffreParIdEtr(@RequestParam("id") String id) {
	
	List <Offre> l=new ArrayList();
	List <Offre> l2=new ArrayList();
	l=offreRepository.findAll();
	System.out.println("taillee <:"+l.size());
	for (int i=0;i<l.size();i++)
	{
	

		if(l.get(i).getEntreprise().getId_etr()==Integer.parseInt(id)) {
			l2.add(l.get(i));
			
			
		}
	}
	return new ResponseEntity<List<Offre>>(l2, HttpStatus.OK);
	}
	
	@GetMapping("/offre/{id_offre}")
	public Offre getOffre(@PathVariable Integer id_offre){
		
		return offreRepository.findOne(id_offre);
	}
	
	
	@DeleteMapping("/offre/{id_offre}")
	public boolean deleteOffre(@PathVariable Integer id_offre){
	
		Offre e=offreRepository.findOne(id_offre);
		
		offreRepository.delete(e);
		return true;
	}
	
	
	@GetMapping("/CreateOffre")
	public ResponseEntity<Offre> AAA(@RequestParam("id") String id) {

		
		return null;
	}
	
	@GetMapping("/test")
	public Offre addOffre(@RequestParam("nom") String nom,@RequestParam("categorie") String categorie,@RequestParam("telephone") String telephone,@RequestParam("prix") String prix,@RequestParam("lieu") String lieu,@RequestParam("date") String date,@RequestParam("apropos") String apropos,@RequestParam("idtr") String idtr,@RequestParam("image") String image) {
Offre e=new Offre();
e.setA_propos(apropos);
e.setDate_pub(date);
e.setLieu_offre(lieu);
e.setCategorie_p(categorie);
e.setPrix(Integer.parseInt(prix));
e.setTelephone(telephone);
e.setNom_produit(nom);
e.setImage(image);
Entreprise ett=etr.findOne(Integer.parseInt(idtr));
e.setEntreprise(ett);
return offreRepository.save(e);
	}
	@PutMapping("/offre")
	public Offre updateOffre(@RequestBody Offre offre){
		
		return offreRepository.save(offre);
	}
}
