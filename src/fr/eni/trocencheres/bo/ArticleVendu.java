package fr.eni.trocencheres.bo;

import java.time.LocalDate;
import java.util.Date;

public class ArticleVendu {

	//D�claration des variables de la classe article vendu 	
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEcheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;


	// construteur avec toutes les variables d'instances
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEcheres, int miseAPrix, int prixVente, int etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEcheres = dateFinEcheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}


	// Getters et setters
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEcheres() {
		return dateFinEcheres;
	}
	public void setDateFinEcheres(LocalDate dateFinEcheres) {
		this.dateFinEcheres = dateFinEcheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}

}
