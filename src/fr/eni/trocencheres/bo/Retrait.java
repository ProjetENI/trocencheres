package fr.eni.trocencheres.bo;

public class Retrait {

	//Déclaration des variables de la classe article vendu 	
	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu article;
	

	// construteur avec toutes les variables d'instances
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	// Getters et setters
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
	
	public void ajouterArticle (ArticleVendu pArticle) {
		if (this.equals(article.getLieuRetrait())) {
			this.article = pArticle ;
		}
	}
	
	
}
