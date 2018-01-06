package com.marketplace.tn.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.tn.model.Article;
import com.marketplace.tn.model.Entreprise;
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId DESC";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createArticle(Article article) {
		entityManager.persist(article);
	}
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		
		artcl.setNom_article(article.getNom_article());
		artcl.setPrix_article(article.getPrix_article());
		artcl.setAdresse_article(article.getAdresse_article());
		artcl.setCategorie_article(article.getCategorie_article());
		artcl.setVille_article(article.getVille_article());
		artcl.setAvatar_article(article.getAvatar_article());
		artcl.setTel_article(article.getTel_article());
		artcl.setApropos_article(article.getApropos_article());
		artcl.setDatepub_article(article.getDatepub_article());
		artcl.setEntreprise(article.getEntreprise());
		entityManager.flush();
	}
	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}
	@Override
	public boolean articleExists(String nom_article, int prix_article, String adresse_article, String categorie_article, String ville_article, String avatar_article, int tel_article, String apropos_article, String datepub_article,Entreprise Entreprise) {
		String hql = "FROM Article as atcl WHERE atcl.nom_article = ? and atcl.prix_article = ? and atcl.adresse_article = ? and atcl.categorie_article = ? and atcl.ville_article = ? and atcl.avatar_article = ? and atcl.tel_article = ? and atcl.apropos_article = ?and atcl.datepub_article = ?and atcl.Entreprise = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nom_article)
		              .setParameter(2, prix_article).setParameter(3, adresse_article)
		              .setParameter(4, categorie_article).setParameter(5, ville_article)
		              .setParameter(6, avatar_article).setParameter(7,tel_article)
		              .setParameter(8, apropos_article).setParameter(9, datepub_article).setParameter(9, Entreprise).getResultList().size();
		return count > 0 ? true : false;		
	}
}
