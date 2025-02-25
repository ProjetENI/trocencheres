package fr.eni.trocencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	
	// declaration des variables de la utilisateur
	
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville; 
	private String motDePasse;
	private int credit;
	private boolean administrateur = false;
	
	private List<ArticleVendu> articles;
	private List<Enchere> historiqueEnchereUtilisateur;

	
	//constructeur avec toutes les variables (Nb param (12))
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
				String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
			this(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, credit,
					administrateur);
			this.motDePasse = motDePasse;
	}
	
		
	//constructeur avec toutes les variables sauf le motDePasse (Nb param (11))
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, int credit, boolean administrateur) {
		this(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville);
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	//constructeur avec toutes les variables sauf le motDePasse (Nb param (9))
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articles = new ArrayList<>();
		this.historiqueEnchereUtilisateur = new ArrayList<>();
	}

	
	//constructeur pour modif mot de passe (Nb param (10))
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		this(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		this.noUtilisateur = noUtilisateur;
	}
	
	//constructeur pour l'inscription (Nb param (9))
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
				String rue, String codePostal, String ville, String motDePasse) {
			this(pseudo, nom, prenom, email, telephone, rue, codePostal, ville);
			this.motDePasse = motDePasse;
	}
	
	//constructeur pour l'inscription (Nb param (9))
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
				String rue, String codePostal, String ville) {
			this.pseudo = pseudo;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
			this.articles = new ArrayList<>();
			this.historiqueEnchereUtilisateur = new ArrayList<>();
	}
	//constructeur pour l'enchere d'un article (Nb param (1))
	public Utilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	// Getters et setters 
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public List<ArticleVendu> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
	}	
	
	//Methode permettant de respecter l'association bidirectionelle
	public void ajouterArticles (ArticleVendu article) {
		if (this.equals(article.getUtilisateur())) {
			this.articles.add(article);
		}
	}
	
	//Methode permettant de respecter l'association bidirectionelle
	public void ajouterEnchere (Enchere enchere) {
		if (this.equals(enchere.getUtilisateur())) {
			this.historiqueEnchereUtilisateur.add(enchere);
		}
	}

	@Override
	public String toString() {
		return String.format(
				"Utilisateur noUtilisateur=%s, pseudo=%s, nom=%s, prenom=%s, email=%s, telephone=%s, rue=%s, codePostal=%s, ville=%s, motDePasse=%s, credit=%s, administrateur=%s",
				noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit,
				administrateur);
	}

}
