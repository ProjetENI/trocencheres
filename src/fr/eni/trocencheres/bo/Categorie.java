package fr.eni.trocencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	//Déclaration des variables de la classe article vendu 	
	private int noCategorie;
	private String libelle;
	private List<ArticleVendu> articles;

	
	public Categorie(int noCategorie, String libelle) {
		this(noCategorie);
		this.libelle = libelle;
	}
	
	// Constructeur pour passage des parametre de l'IHM à la DAL
	public Categorie(int noCategorie) {
		this.noCategorie = noCategorie;
		this.setArticles(new ArrayList<>());
	}
	
	// Getters et setters
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}


	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
	}
	
	public void ajouterArticles (ArticleVendu article) {
		if (this.equals(article.getCategorieArticle())) {
			this.articles.add(article);
		}
	}
	
}
