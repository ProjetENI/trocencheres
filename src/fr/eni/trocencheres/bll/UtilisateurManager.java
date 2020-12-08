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
		BusinessException businessException = new BusinessException();
		validerUtilisateur(utilisateur, businessException);
	
		if(!businessException.hasErreurs()) {
			utilisateurDao.ajouterUtilisateur(utilisateur);
		} else {
			throw businessException;
		}
	}


	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerUtilisateur(utilisateur, businessException);
		
		if(!businessException.hasErreurs()) {
			utilisateurDao.modifierUtilisateur(utilisateur);
		} else {
			throw businessException;
		}
	}


	public void modifierMotDePasse(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerPassword(utilisateur, businessException);
		
		if(!businessException.hasErreurs()) {
			utilisateurDao.modifierMotDePasse(utilisateur);
		} else {
			throw businessException;
		}
	}


	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerUtilisateur(Utilisateur utilisateur, BusinessException businessException) {
		validerPseudo(utilisateur, businessException);
		validerEmail(utilisateur, businessException);
		validerNom(utilisateur, businessException);
		validerPrenom(utilisateur, businessException);
		validerTelephone(utilisateur, businessException);
		validerCodePotal(utilisateur, businessException);
		validerPassword(utilisateur, businessException);
	}

	private void validerPseudo(Utilisateur utilisateur, BusinessException businessException) {
		String checkAlphaNumeric = "[\\w]";

		if (utilisateur.getPseudo().length() < 5 && utilisateur.getPseudo().length() > 20) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_TAILLE_NOM_ERREUR);
		}
		if (utilisateur.getPseudo().matches(checkAlphaNumeric)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_CARACTERES_NOM_ERREUR);
		}
	}

	private void validerEmail(Utilisateur utilisateur, BusinessException businessException) {
		String checkEmail = "^[\\w-]+@[\\w-]+\\.[a-zA-Z]{2,6}$";

		if (!utilisateur.getEmail().matches(checkEmail)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_NOM_ERREUR);
		}
	}

	private void validerNom(Utilisateur utilisateur, BusinessException businessException) {

		if (utilisateur.getNom().length() < 3 && utilisateur.getNom().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validerPrenom(Utilisateur utilisateur, BusinessException businessException) {

		if (utilisateur.getPrenom().length() < 2 && utilisateur.getPrenom().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PRENOM_UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validerTelephone(Utilisateur utilisateur, BusinessException businessException) {
		String checkTelephone = "^(0|\\+33|33|0033)[0-9]{9}$";
		
		if (!utilisateur.getTelephone().matches(checkTelephone)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_TELEPHONE_NOM_ERREUR);
		}
	}

	private void validerCodePotal(Utilisateur utilisateur, BusinessException businessException) {
		String checkCodePostal = "[\\d]{5}";

		if (!utilisateur.getCodePostal().matches(checkCodePostal)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_CODEPOSTAL_NOM_ERREUR);
		}
	}

	private void validerPassword(Utilisateur utilisateur, BusinessException businessException) {
		String checkPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$€%&+=!])(?=\\S+$).{6,}$";
		// Contient minimum un chiffre, une minuscule, une majuscule, un caractère spécial et fait minimum 6 caractères
		if (utilisateur.getMotDePasse().length() < 6 ||
			utilisateur.getMotDePasse().length() > 30 ||
			utilisateur.getMotDePasse().matches(checkPassword) ) {

			businessException.ajouterErreur(CodesResultatBLL.REGLE_MOTDEPASSE_NOM_ERREUR);
		}
	}
}
