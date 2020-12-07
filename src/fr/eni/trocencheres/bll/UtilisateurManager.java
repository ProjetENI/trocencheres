package fr.eni.trocencheres.bll;

import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.DaoFactory;
import fr.eni.trocencheres.dal.UtilisateurDao;

public class UtilisateurManager {

	private UtilisateurDao utilisateurDao;


	public UtilisateurManager() {
		this.utilisateurDao = DaoFactory.getUtilisaseurDao();
	}


	public List<Utilisateur> listerUtilisateurs() throws BusinessException {
		return this.utilisateurDao.listerUtilisateurs();
	}


	public Utilisateur listerUtilisateurInformation(String identifiant,String mdp) throws BusinessException {
		return this.utilisateurDao.listerUtilisateurInformation(identifiant,mdp);
	}


	public void supprimerUtilisateur(Utilisateur utilisateur) throws BusinessException {
		this.utilisateurDao.supprimerUtilisateur(utilisateur);
	}


	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException {
		validerUtilisateur(utilisateur);
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}


	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
		validerUtilisateur(utilisateur);
		utilisateurDao.modifierUtilisateur(utilisateur);
	}


	public void modifierMotDePasse(Utilisateur identifiant) throws BusinessException {
		validerPseudo(identifiant);
		utilisateurDao.modifierMotDePasse(identifiant);
	}


	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerUtilisateur(Utilisateur utilisateur) throws BusinessException {
		validerPseudo(utilisateur);
		validerEmail(utilisateur);
		validerNom(utilisateur);
		validerPrenom(utilisateur);
		validerTelephone(utilisateur);
		validerCodePotal(utilisateur);
	}

	private void validerPseudo(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		String checkAlphaNumeric = "[\\w]";

		if (utilisateur.getPseudo().length() < 5 && utilisateur.getPseudo().length() > 20) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_TAILLE_NOM_ERREUR);
		}
		if (utilisateur.getPseudo().matches(checkAlphaNumeric)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_CARACTERES_NOM_ERREUR);
		}
	}

	private void validerEmail(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		String checkEmail = "^[\\w-]+@[\\w-]+\\.[a-zA-Z]{2,6}$";

		if (!utilisateur.getEmail().matches(checkEmail)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_NOM_ERREUR);
		}
	}

	private void validerNom(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();

		if (utilisateur.getNom().length() < 3 && utilisateur.getNom().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validerPrenom(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();

		if (utilisateur.getPrenom().length() < 2 && utilisateur.getPrenom().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PRENOM_UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validerTelephone(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		String checkTelephone = "^(0|\\+33|33|0033)[0-9]{9}$";
		
		if (!utilisateur.getTelephone().matches(checkTelephone)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_TELEPHONE_NOM_ERREUR);
		}
	}

	private void validerCodePotal(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		String checkCodePostal = "[\\d]{5}";

		if (!utilisateur.getCodePostal().matches(checkCodePostal)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_CODEPOSTAL_NOM_ERREUR);
		}
	}


}
