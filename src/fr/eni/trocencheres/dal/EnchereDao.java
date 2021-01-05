package fr.eni.trocencheres.dal;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Enchere;

public interface EnchereDao{

	/**
	 * Fonction prenant en paramètre un article pour l'ajouter en base de données
	 * @param article vendu
	 * @throws BusinessException 
	 */
	void ajouterEnchere(Enchere enchere) throws BusinessException;

}