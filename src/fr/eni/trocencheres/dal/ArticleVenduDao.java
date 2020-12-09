package fr.eni.trocencheres.dal;

import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.ArticleVendu;

public interface ArticleVenduDao {

	/**
	 * Fonction qui permet lister tous les articles présents en base de données
	 * @return une liste d'article vendu
	 * @throws BusinessException 
	 */
//	List<ArticleVendu> listerArticleVendu() throws BusinessException;

	/**
	 * Fonction prenant en paramètre un article pour l'ajouter en base de données
	 * @param article vendu
	 * @throws BusinessException 
	 */
	void ajouterArticleVendu(ArticleVendu articlevendu) throws BusinessException;

	
	/**
	 * Fonction prenant en paramètre une modification d'un article 
	 * @param article vendu
	 * @throws BusinessException 
	 */
	void modifierArticleVendu(ArticleVendu articlevendu) throws BusinessException ;

	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer un article en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	void supprimerArticleVendu(ArticleVendu articlevendu) throws BusinessException;

}