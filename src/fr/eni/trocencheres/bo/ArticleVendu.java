package fr.eni.trocencheres.bo;

import java.util.Date;

public class ArticleVendu {

//Déclaration des variables de la classe article vendu 	

	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEcheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;

// construteur avec toutes les variables d'instances

	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEcheres, int miseAPrix, int prixVente, int etatVente) {
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

// Constructeur sans paramètre
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

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEcheres() {
		return dateFinEcheres;
	}

	public void setDateFinEcheres(Date dateFinEcheres) {
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
