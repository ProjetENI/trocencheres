package fr.eni.trocencheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {

	//D�claration des variables de la classe article vendu 	
	private int noArticle;
	private String nomArticle;
	private String description;
	private String imageURL;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private int etatVente;
	
	private Categorie categorieArticle;
	private Utilisateur utilisateur;
	private Retrait lieuRetrait;
	private List<Enchere> historiqueEnchereArticle;

	//Constructeur vide
	public ArticleVendu () {
		
	}


	// construteur avec toutes les variables d'instances (nb param (12))
	public ArticleVendu(int noArticle, String nomArticle, String description, String imageURL,
			LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixInitial, int prixVente, int etatVente,
			Categorie categorieArticle, Utilisateur utilisateur, Retrait lieuRetrait) {
		this(noArticle, nomArticle, description, imageURL, dateDebutEncheres, dateFinEncheres, prixInitial,
				etatVente, categorieArticle, utilisateur, lieuRetrait);
		this.prixVente = prixVente;
	}


	// construteur pour l'ajout d'un article en base (nb param (11))
	public ArticleVendu(int noArticle, String nomArticle, String description, String imageURL, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int etatVente, Categorie categorieArticle, Utilisateur utilisateur, Retrait lieuRetrait) {
		
		this(nomArticle, description, imageURL, dateDebutEncheres, dateFinEncheres, prixInitial, categorieArticle, utilisateur, lieuRetrait);
		this.noArticle = noArticle;
		this.etatVente = etatVente;
	}
	
	// construteur pour passage des parametre de l'IHM à la DAL avec retrait (nb param (9))
	public ArticleVendu(String nomArticle, String description, String imageURL, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial,Categorie categorieArticle, Utilisateur utilisateur, Retrait lieuRetrait) {
		
		this(nomArticle, description, imageURL, dateDebutEncheres, dateFinEncheres, prixInitial, categorieArticle, utilisateur);
		this.setLieuRetrait(lieuRetrait);
		lieuRetrait.ajouterArticle(this);
	}
	
	// construteur pour passage des parametre de l'IHM à la DAL sans retrait (nb param (8))
	public ArticleVendu(String nomArticle, String description, String imageURL, LocalDate dateDebutEncheres,
				LocalDate dateFinEncheres, int prixInitial,Categorie categorieArticle, Utilisateur utilisateur) {
			this.nomArticle = nomArticle;
			this.description = description;
			this.imageURL = imageURL;
			this.dateDebutEncheres = dateDebutEncheres;
			this.dateFinEncheres = dateFinEncheres;
			this.prixInitial = prixInitial;
			this.categorieArticle = categorieArticle;
			categorieArticle.ajouterArticles(this);
			this.utilisateur = utilisateur;
			utilisateur.ajouterArticles(this);
			this.sethistoriqueEnchereArticle(new ArrayList<>());
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

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int miseAPrix) {
		this.prixInitial = miseAPrix;
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

	public Categorie getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}


	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}


	public List<Enchere> gethistoriqueEnchereArticle() {
		return historiqueEnchereArticle;
	}


	public void sethistoriqueEnchereArticle(List<Enchere> historiqueEnchere) {
		this.historiqueEnchereArticle = historiqueEnchere;
	}
	
	//Methode permettant de respecter l'association bidirectionelle
	public void ajouterEnchere (Enchere enchere) {
		if (this.equals(enchere.getArticlevendu())) {
			this.historiqueEnchereArticle.add(enchere);
		}
	}
	

}
