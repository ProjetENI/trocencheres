package fr.eni.trocencheres.bll;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Retrait;

public class RetraitManager {

	public RetraitManager() {
	}

	public void validerRetrait(Retrait retrait) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerCodePostal(retrait, businessException);
	}



	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerCodePostal(Retrait retrait, BusinessException businessException) {
		String checkCodePostal = "^[0-9]{5}$";

		if (!retrait.getCodePostal().matches(checkCodePostal)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_CODEPOSTAL_NOM_ERREUR);
		}
	}

}
