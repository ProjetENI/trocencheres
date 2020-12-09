package fr.eni.trocencheres.bo;

public class Retrait {

	//Déclaration des variables de la classe article vendu 	
	private String rue;
	private String code_postal;
	private String ville;
	private ArticleVendu article;
	

	// construteur avec toutes les variables d'instances
	public Retrait(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}


	// Getters et setters
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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
