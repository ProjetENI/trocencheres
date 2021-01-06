package fr.eni.trocencheres.bll;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Enchere;
import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.DaoFactory;
import fr.eni.trocencheres.dal.EnchereDao;

public class EnchereManager {

	private EnchereDao enchereDao;


	public EnchereManager() {
		this.enchereDao = DaoFactory.getEnchereDao();
	}

	public void ajouterEnchere(Enchere enchere) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerEnchere(enchere, businessException);
	
		if(!businessException.hasErreurs()) {
			enchereDao.ajouterEnchere(enchere);
		} else {
			throw businessException;
		}
	}


	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerEnchere(Enchere enchere, BusinessException businessException) {
		validerMontant(enchere.getMontant_enchere(), businessException);
	}

	private void validerMontant(int prix, BusinessException businessException) {
		if( prix < 0 || prix != (int)prix ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_MONTANT_ENCHERE_NOM_ERREUR);
		}
	}

}
