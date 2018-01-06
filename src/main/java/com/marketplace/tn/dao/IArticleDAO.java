package com.marketplace.tn.dao;
import java.util.List;

import com.marketplace.tn.model.*;
public interface IArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void createArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String nom_article, int prix_article, String adresse_article, String categorie_article, String ville_article, String avatar_article, int tel_article, String apropos_article, String datepub_article,Entreprise Entreprise );
}
 