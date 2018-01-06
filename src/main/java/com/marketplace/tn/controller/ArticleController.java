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

import com.marketplace.tn.Repository.ArticleRepository;
import com.marketplace.tn.model.Acheteur;
import com.marketplace.tn.model.Article;
import com.marketplace.tn.model.Entreprise;
import com.marketplace.tn.model.Offre;
import com.marketplace.tn.model.Offresauvgarder;
import com.marketplace.tn.service.IArticleService;
import com.marketplace.tn.service.IEntrepriseService;
import com.marketplace.tn.Repository.EntrepriseRepository;

@Controller

@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private IEntrepriseService entrepriseService;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@GetMapping("article")
	public ResponseEntity<Article> getArticleById(@RequestParam("id") String id) {
		Article article = articleService.getArticleById(Integer.parseInt(id));
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@GetMapping("all-articles")
	public ResponseEntity<List<Article>> getAllArticles(@RequestParam("id") String id) {
		List<Article> list = articleService.getAllArticles();
		System.out.println("Exxxxx"+id);
		List<Article> list1 =new ArrayList();
		for (int i=0;i<list.size();i++) {
			if (list.get(i).getEntreprise().getId_etr()==Integer.parseInt(id)) {
			 list1.add(list.get(i));
			}
		}
		return new ResponseEntity<List<Article>>(list1, HttpStatus.OK);
	}
	@PostMapping("article")
	public ResponseEntity<Void> createArticle(@RequestBody Article article,@RequestParam("id") String id, UriComponentsBuilder builder) {
		System.out.println(id);
	    Long ii=Long.parseLong(id);
	    System.out.println("l9itou saye"+ii);
	   
	    Entreprise E= entrepriseRepository.findOne(Integer.parseInt(id));
	   
	    article.setEntreprise(E);
	   
	       
	    boolean flag = articleService.createArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	}
	
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@DeleteMapping("article")
	public ResponseEntity<Void> deleteArticle(@RequestParam("id") String id) {
		Article A=articleService.getArticleById(Integer.parseInt(id));
		articleRepository.delete(A);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}