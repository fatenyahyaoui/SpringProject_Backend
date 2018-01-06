package com.marketplace.tn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.tn.dao.IArticleDAO;
import com.marketplace.tn.model.Article;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean createArticle(Article article){
       if (articleDAO.articleExists(article.getNom_article(),article.getPrix_article(),article.getAdresse_article(),article.getCategorie_article(),article.getVille_article(),article.getAvatar_article(),article.getTel_article(),article.getApropos_article(),article.getDatepub_article(),article.getEntreprise())) {
    	   return false;
       } else {
    	   articleDAO.createArticle(article);
    	   return true;
       }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
