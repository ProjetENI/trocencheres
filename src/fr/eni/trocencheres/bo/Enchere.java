package fr.eni.trocencheres.bo;

import java.time.LocalDate;

public class Enchere {

	//Déclaration des variables de la classe article vendu 	
	private LocalDate dateEncheres;
	private int montant_enchere;

	private ArticleVendu articlevendu;
	private Utilisateur utilisateur;

	// construteur avec toutes les variables d'instances
	public Enchere(LocalDate dateEncheres, int montant_enchere, ArticleVendu articlevendu, Utilisateur utilisateur) {
		super();
		this.dateEncheres = dateEncheres;
		this.montant_enchere = montant_enchere;
		this.articlevendu = articlevendu;
		articlevendu.ajouterEnchere(this);
		this.utilisateur = utilisateur;
		utilisateur.ajouterEnchere(this);
	}
	
	// Getters et setters
	public LocalDate getDateEncheres() {
		return dateEncheres;
	}
	public void setDateEncheres(LocalDate dateEncheres) {
		this.dateEncheres = dateEncheres;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public ArticleVendu getArticlevendu() {
		return articlevendu;
	}
	public void setArticlevendu(ArticleVendu articlevendu) {
		this.articlevendu = articlevendu;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
