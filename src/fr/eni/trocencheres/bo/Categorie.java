package fr.eni.trocencheres.bo;

public class Categorie {

	//Déclaration des variables de la classe article vendu 	
	private int noCategorie;
	private String libelle;
	
	
	

	// construteur avec toutes les variables d'instances
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
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
	
}
